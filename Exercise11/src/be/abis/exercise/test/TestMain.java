package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {

        PersonRepository pr = new MemoryPersonRepository();
        List<Person> persons = pr.findAllPersons();

        System.out.println("All persons:");
        for (Person p: persons){
            System.out.println(p);
        }
        
        CourseRepository cr = new MemoryCourseRepository();
        List<Course> courses = cr.findAllCourses();

        System.out.println("\nAll courses:");
        for (Course c: courses){
            System.out.println(c);
        }



    }
}
