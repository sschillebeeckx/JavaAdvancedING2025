package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.FileCourseRepository;

import java.io.IOException;

public class ParseCourseTest {

    public static void main(String[] args) throws IOException {
        CourseRepository cr = new FileCourseRepository();

        String input = "DB2, an overview;5;550.0;30/4/1986";

        Course parsedCourse = ((FileCourseRepository)cr).parseCourse(input);
        System.out.println(parsedCourse);
    }
}
