package be.abis.exercise.test;

import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;

public class TestCoursePrinting {

    public static void main(String[] args) {
        CourseRepository cr = new MemoryCourseRepository();

        cr.printAllCourses();
    }
}
