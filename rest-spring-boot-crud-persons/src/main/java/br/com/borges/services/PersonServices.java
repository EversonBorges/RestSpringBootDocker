package br.com.borges.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.borges.data.model.Person;
import br.com.borges.exception.ResourceNotFoundException;
import br.com.borges.repository.PersonRepository;


@Service
public class PersonServices {

	@Autowired
	private PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public List<Person> findAll() {
		return repository.findAll();
	}
	
	public Person findById(Long id) {
		return repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + id));
	}

	public Person update(Person person) {
		
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + person.getId()));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + id));
		
		repository.delete(entity);
	}
}
