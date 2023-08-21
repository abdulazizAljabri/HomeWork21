package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Api.ApiResponse;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Service.CouserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/courses")
public class CourseController {
    private final CouserService couserService;

    @GetMapping("/")
    public ResponseEntity getCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(couserService.getCourseList());
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course){
        couserService.addCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("course added"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        couserService.removeCourse(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("course deleted"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id ,@RequestBody @Valid Course course){
        couserService.updateCourse(id, course);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("course updated"));
    }
    @GetMapping("/assign/{courseId}/{teacherId}")
    public ResponseEntity assignCourse(@PathVariable Integer courseId,@PathVariable Integer teacherId){
        couserService.assignCourseToTeacher(courseId, teacherId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("course assigned"));
    }
    @GetMapping("/search/{courseId}")
    public ResponseEntity searchCourse(@PathVariable Integer courseId){
      return ResponseEntity.status(HttpStatus.OK).body(couserService.searchById(courseId));
    }
}
