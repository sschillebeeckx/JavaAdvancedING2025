package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.FileCourseRepository;

import java.io.IOException;

public class ReadCourseFileTest {

    public static void main(String[] args)  {
        CourseRepository cr = null;
        try {
            cr = new FileCourseRepository();
            cr.findAllCourses().forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
