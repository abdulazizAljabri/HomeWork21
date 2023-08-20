package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Api.ApiException;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Reposetory.AddressReposertory;
import com.example.schoolmanagement.Reposetory.TeacherReposertory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherSerivce {
    private final TeacherReposertory teacherreposertory;
    private final AddressReposertory addressreposertory;

    public List<Teacher> getTeachers(){
        return teacherreposertory.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherreposertory.save(teacher);
    }

    public void removeTeacher(Integer teacherId){
        Teacher teacher = teacherreposertory.findTeacherByTeacherId(teacherId);
        if(teacher == null){
           throw new ApiException("Teacher not found");
        }
        addressreposertory.deleteById(teacherId);
        teacherreposertory.deleteById(teacherId);
    }
    public void updateTeacher(Integer teacherId ,Teacher teacher){
        Teacher teacher1 = teacherreposertory.findTeacherByTeacherId(teacherId);
        if(teacher1 == null){
            throw new ApiException("Teacher not found");
        }
        teacher1.setTeacherName(teacher.getTeacherName());
        teacher1.setTeacherAge(teacher.getTeacherAge());
        teacher1.setTeacherEmail(teacher.getTeacherEmail());
        teacherreposertory.save(teacher1);
    }

}

