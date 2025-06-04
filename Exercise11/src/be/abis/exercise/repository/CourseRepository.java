package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import java.util.List;

public interface CourseRepository {

    List<Course> findAllCourses();
    void addCourse(Course c);
}
