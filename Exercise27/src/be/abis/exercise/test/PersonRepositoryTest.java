package be.abis.exercise.test;

import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.List;

public class PersonRepositoryTest {

    public static void main(String[] args) {

        PersonRepository pr = new MemoryPersonRepository();
        List<Person> persons = pr.findAllPersons();

        System.out.println("All persons:");
        persons.forEach(System.out::println);

        try {
            System.out.println("\nFind by id:");
            System.out.println(pr.findPersonById(3));

            System.out.println("\nFind by email/pwd:");
            System.out.println(pr.findPersonByEmailAndPassword("sschillebeeckx@abis.be","somepass1"));

            System.out.println("\nFind by company:");
            pr.findPersonsForCompany("abis").forEach(System.out::println);

        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nFind by wrong id:");
            System.out.println(pr.findPersonById(200));
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nFind by wrong email/pwd:");
            System.out.println(pr.findPersonByEmailAndPassword("sschillebeeckx@abis.be","somepassWrong"));
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nFind by wrong company:");
            pr.findPersonsForCompany("siba").forEach(System.out::println);
        } catch (PersonNotFoundException e) {
            System.out.println(e.getMessage());
        }



    }
}
