package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.FileCourseRepository;

import java.io.IOException;
import java.time.LocalDate;

public class TestFileCourseRepository {

    public static void main(String[] args) {
        CourseRepository cr = null;
        try {
            cr = new FileCourseRepository();
            cr.findAllCourses().forEach(System.out::println);

            Course c = new Course("Java Advanced",3,625.0, LocalDate.of(2014,7,5));
            cr.addCourse(c);
            
            cr.printAllCourses();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
