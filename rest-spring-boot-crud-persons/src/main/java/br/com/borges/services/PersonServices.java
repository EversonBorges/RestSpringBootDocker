package br.com.borges.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.borges.converter.DozerConverter;
import br.com.borges.data.model.Person;
import br.com.borges.data.vo.PersonVO;
import br.com.borges.exception.ResourceNotFoundException;
import br.com.borges.repository.PersonRepository;


@Service
public class PersonServices {

	@Autowired
	private PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public Page<PersonVO> findPersonByNames(String firstName, Pageable pageable) {
		
		var page = repository.findPersonByNames(firstName,pageable);
		return page.map(this::converToPersonVO);
			
	}
	
	public Page<PersonVO> findAll(Pageable pageable) {
		
		var page = repository.findAll(pageable);
		
		return page.map(this::converToPersonVO);
			
	}
	
	private PersonVO converToPersonVO(Person entity) {
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		var entity =  repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + id));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		
		var entity = repository.findById(person.getIdPerson())
				.orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + person.getId()));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	@Transactional
	public PersonVO disablePerson(Long id) {
		repository.disablePersons(id);
		var entity =  repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + id));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + id));
		
		repository.delete(entity);
	}
}
