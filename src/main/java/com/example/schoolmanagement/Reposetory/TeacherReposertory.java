package com.example.schoolmanagement.Reposetory;

import com.example.schoolmanagement.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherReposertory extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherByTeacherId(Integer teacherId);
}
