package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Api.ApiException;
import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Reposetory.AddressReposertory;
import com.example.schoolmanagement.Reposetory.TeacherReposertory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressReposertory addressreposertory;
    private final TeacherReposertory teacherreposertory;

    public List<Address> getAddress(){
        return addressreposertory.findAll();
    }

    public void addAdress(AddressDTO addressdto){
       Teacher  teacher = teacherreposertory.findTeacherByTeacherId(addressdto.getTeacher_teacher_id());
        if(teacher == null){
            System.out.println("ho");
            throw new ApiException("Teacher not found");
        }
        Address address = new Address(null,addressdto.getStreet(), addressdto.getArea(), addressdto.getBuildingNumber(),teacher);
        addressreposertory.save(address);
    }

    public void removeAdress(Integer id){
        Teacher teacher = teacherreposertory.findTeacherByTeacherId(id);
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        Address address = addressreposertory.findAddressByAddressId(id);
        addressreposertory.delete(address);
    }

    public void updateAddress(AddressDTO addressdto){
        Teacher teacher = teacherreposertory.findTeacherByTeacherId(addressdto.getTeacher_teacher_id());
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        Address address = addressreposertory.findAddressByAddressId(addressdto.getTeacher_teacher_id());
        address.setArea(addressdto.getArea());
        address.setStreet(addressdto.getStreet());
        address.setBuildingNumber(addressdto.getBuildingNumber());
        addressreposertory.save(address);
    }

    public Address getAddressById(Integer teacherId){
        Teacher teacher = teacherreposertory.findTeacherByTeacherId(teacherId);
        if(teacher == null){
            throw new ApiException("Teacher not found");
        }
        return teacher.getAddress();
    }

}


