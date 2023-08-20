package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Api.ApiResponse;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Service.TeacherSerivce;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teachers")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherSerivce teacherserivce;

    @GetMapping("/")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherserivce.getTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherserivce.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Teacher added"));
    }
    @PutMapping("/update/{teacherId}")
    public ResponseEntity updateTeacher(@PathVariable Integer teacherId, @Valid @RequestBody Teacher teacher){
        teacherserivce.updateTeacher(teacherId,teacher);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Teacher updated"));
    }
    @DeleteMapping("/delete/{teacherId}")
    public ResponseEntity removeTeacher(@PathVariable Integer teacherId){
        teacherserivce.removeTeacher(teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Teacher removed"));
    }

}
