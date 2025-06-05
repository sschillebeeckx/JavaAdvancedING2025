package be.abis.exercise.test;

import be.abis.exercise.exception.PersonAlreadyExistsException;
import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;
import be.abis.exercise.repository.MemoryPersonRepository;
import be.abis.exercise.repository.PersonRepository;

import java.time.LocalDate;

public class TestAddPerson {

    public static void main(String[] args) {

        PersonRepository pr = new MemoryPersonRepository();

        try {
            System.out.println("\nAdd person:");
            Address a = new Address("Diestsevest","32 bus 4b","3000","Leuven","België","B");
            Company c = new Company("Abis",a);
            Person p1 = new Person("Emily","Mees", LocalDate.of(1990,02,5),"emees@abis.be","abis345","nl",c);
            pr.addPerson(p1);
        } catch (PersonAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("\nAdd existing person:");
            Person p2 = new Person("Sam","Schillebeeckx", LocalDate.of(1983,12,15),"sschillebeeckx@abis.be","abis365","fr");
            pr.addPerson(p2);
        } catch (PersonAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

    }
}
