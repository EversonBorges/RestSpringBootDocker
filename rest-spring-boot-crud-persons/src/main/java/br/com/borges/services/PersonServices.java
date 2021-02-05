package br.com.borges.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.borges.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();

	public Person findById(String id) {

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Everson");
		person.setLastName("Borges");
		person.setAddress("Betim-MG");
		person.setGender("Male");

		return person;
	}

	public List<Person> findByAll() {

		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 7; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}

		return persons;
	}

	public Person create(Person person) {
		return person;
	}

	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}

	private Person mockPerson(int i) {

		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("FirstName" + i);
		person.setLastName("LastName" + i);
		person.setAddress("Brasil" + i);
		person.setGender("Male" + i);

		return person;
	}
}
