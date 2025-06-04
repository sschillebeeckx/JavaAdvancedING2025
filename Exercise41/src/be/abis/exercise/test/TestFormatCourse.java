package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

import java.time.LocalDate;
import java.util.List;

public class TestFormatCourse {

    public static void main(String[] args) {

        Course course=  new Course("ChatGPT",1,500.0, LocalDate.now());
        String s = CourseRepository.formatCourse(course);
        System.out.println(s+"\n");

        CourseRepository cr = new MemoryCourseRepository();
        List<Course> courses = cr.findAllCourses();
        Course course1 = courses.getFirst();
        System.out.println(course1 + "\n");


        courses.stream()
                .map(c->CourseRepository.formatCourse(c))
                .forEach(System.out::println);

        courses.stream()
                .forEach(c -> System.out.println(CourseRepository.formatCourse(c)));
    }
}
