package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Api.ApiException;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Reposetory.CourseRepposertoy;
import com.example.schoolmanagement.Reposetory.TeacherReposertory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouserService {
    private final CourseRepposertoy courseRepposertoy;
    private final TeacherReposertory teacherReposertory;

    public List<Course> getCourseList() {
        return courseRepposertoy.findAll();
    }
    public void addCourse(Course course) {
        courseRepposertoy.save(course);
    }

    public void removeCourse(Integer id) {
        Course course = courseRepposertoy.findCourseById(id);
        if(course == null){
            throw new ApiException("Course not found");
        }
        courseRepposertoy.delete(course);
    }

    public void updateCourse(Integer id ,Course course){
        Course course1 = courseRepposertoy.findCourseById(id);
        if(course == null){
            throw new ApiException("Course not found");
        }
        course1.setName(course.getName());
        course1.setTeacher(course.getTeacher());
        courseRepposertoy.save(course1);
    }

    public void assignCourseToTeacher(Integer teacher_id,Integer course_id){
        Teacher teacher = teacherReposertory.findTeacherByTeacherId(teacher_id);
        Course course1 = courseRepposertoy.findCourseById(course_id);
        if(teacher == null || course1 == null){
            throw new ApiException("Can not assign");
        }
        course1.setTeacher(teacher);
        courseRepposertoy.save(course1);
    }

    public Teacher searchById(Integer id){
     Course course = courseRepposertoy.findCourseById(id);
     if(course == null){
         throw new ApiException("Course not found");
     }
    return course.getTeacher();
    }

}
