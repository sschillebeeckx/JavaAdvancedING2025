package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

import java.util.Comparator;
import java.util.List;

public class CoursesSortTest {

    public static void main(String[] args) {
        CourseRepository cr = new MemoryCourseRepository();
        List<Course> courses = cr.findAllCourses();

        System.out.println("\nAll courses sorted on number of days and price:");
        courses.stream()
                .sorted(Comparator.comparing(Course::getDays).thenComparing(Course::getDailyPrice))
                .forEach(System.out::println);

    }
}
