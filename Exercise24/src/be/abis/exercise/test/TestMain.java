package be.abis.exercise.test;

import be.abis.exercise.model.Course;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.CourseRepository;
import be.abis.exercise.repository.MemoryCourseRepository;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.List;
import java.util.function.Predicate;

public class TestMain {

    public static void main(String[] args) {

        PersonRepository pr = new MemoryPersonRepository();
        List<Person> persons = pr.findAllPersons();

        System.out.println("All persons:");
        for (Person p: persons){
            System.out.print(p);
            System.out.println(" is " + p.calculateAge() + " years old.");
            boolean startsWithS = doTheTest(s -> s.startsWith("S"),p.getFirstName());
            System.out.println("FirstName with S:" + (startsWithS?"yes":"no"));
        }
        
        CourseRepository cr = new MemoryCourseRepository();
        List<Course> courses = cr.findAllCourses();

        System.out.println("\nAll courses:");
        courses.forEach(c -> System.out.println(c));

        courses.forEach(System.out::println);



    }

    public static boolean doTheTest(Predicate<String> tsi, String s){
        return  tsi.test(s);
    }
}
