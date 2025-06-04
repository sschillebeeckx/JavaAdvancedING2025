package be.abis.exercise.repository;

import be.abis.exercise.exception.PersonNotFoundException;
import be.abis.exercise.model.Person;

import java.util.List;

public interface PersonRepository {

	List<Person> findAllPersons();
	Person findPersonById(int id) throws PersonNotFoundException;
	Person findPersonByEmailAndPassword(String email, String password) throws PersonNotFoundException;
	List<Person> findPersonsForCompany(String companyName) throws PersonNotFoundException;
	void addPerson(Person p);
}
