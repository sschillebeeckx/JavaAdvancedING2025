package be.abis.exercise.test;

import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.util.List;

public class PersonStreamTest {

    public static void main(String[] args) {

        PersonRepository pr = new MemoryPersonRepository();
        List<Person> persons = pr.findAllPersons();

        //a
        System.out.println("Last names with S:");
        persons.stream().filter(p->p.getLastName().startsWith("S"))
                .forEach(System.out::println);
        //b
        System.out.println("\nPersons older than 40:");
        persons.stream().filter(p->p.calculateAge()>40)
                .forEach(System.out::println);

        //c
        System.out.println("\nPersons older than 40 with last name starting with S:");
        persons.stream()
                .filter(p->p.getLastName().startsWith("S"))
                .filter(p->p.calculateAge()>40)
                .forEach(System.out::println);
        System.out.println("filter with &&");
        persons.stream()
                .filter(p->p.getLastName().startsWith("S") && p.calculateAge()>40)
                .forEach(System.out::println);

        //d
        System.out.println("\nSorting persons on last name");
        persons.stream().sorted((p1,p2)->p1.getLastName().compareTo(p2.getLastName()))
                .forEach(System.out::println);

        //e
        System.out.println("\nPersons working in Leuven, sorted on age");
        persons.stream()
                .filter(p->p.getCompany()!=null && p.getCompany().getAddress().getTown().equalsIgnoreCase("Leuven"))
                .sorted((p1,p2)->p1.calculateAge()-p2.calculateAge())
                .forEach(p-> System.out.println(p.getFirstName() + " is " + p.calculateAge() + " years old."));
        //f
        System.out.println("\nCompany names of persons");
        persons.stream()
                .filter(p->p.getCompany()!=null)
                .map(p->p.getCompany().getName())
                //.distinct()
                .forEach(System.out::println);
    }
}
