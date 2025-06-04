package be.abis.exercise.model;

import java.time.LocalDate;
import java.time.Period;

public class Person {

	public static int counter = 0;

	private int personNumber;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String email;
	private String password;
	private String languageCode;
	private Company company;

	public Person(){
		personNumber = ++counter;
	}


	public Person(String firstName, String lastName, LocalDate birthDate, String email, String password, String languageCode) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.password = password;
		this.languageCode = languageCode;
	}

	public Person(String firstName, String lastName, LocalDate birthDate, String email,
                  String password, String languageCode, Company company) {
		this(firstName, lastName, birthDate, email, password,languageCode);
		this.company=company;
	}


	public int getPersonNumber() {
		return personNumber;
	}
	
	public void setPersonNumber(int personNumber) {
		this.personNumber=personNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String fName) {
		firstName = fName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lName) {
		lastName = lName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public static int getNumberOfPersons() {
		return counter;
	}

	@Override
	public String toString() {
		return "Person " + personNumber + ": " + this.firstName + " " + this.lastName;
	}

	public int calculateAge(){
		Period p = Period.between(birthDate,LocalDate.now());
		//System.out.println(p);
		return p.getYears();
	}
}