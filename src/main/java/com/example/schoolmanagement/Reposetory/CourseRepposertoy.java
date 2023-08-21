package com.example.schoolmanagement.Reposetory;

import com.example.schoolmanagement.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepposertoy extends JpaRepository<Course,Integer> {
    Course findCourseById(Integer id);
}
