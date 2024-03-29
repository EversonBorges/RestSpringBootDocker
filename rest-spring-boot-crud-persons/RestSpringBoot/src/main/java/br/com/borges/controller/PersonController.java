package br.com.borges.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.borges.data.vo.PersonVO;
import br.com.borges.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@Api(value = "Person Endpoint",description = "Controller para pessoas",tags = {"Person Endpoint"})
//@CrossOrigin
@Api(tags = "Person Endpoint")
@RestController
@RequestMapping("api/person")

public class PersonController {

	@Autowired
	private PersonServices services;
	
	@Autowired
	PagedResourcesAssembler<PersonVO> assembler;

	@ApiOperation(value = "Find All Peoples")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findByAll(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction
			) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"firstName"));

		Page<PersonVO> persons =  services.findAll(pageable);
		persons.stream()
			.forEach(p -> p.add(
				linkTo(methodOn(PersonController.class).findById(p.getIdPerson())).withSelfRel()));
		
		PagedResources<?> resources = assembler.toResource(persons);
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Find All Peoples")
	@GetMapping(value = "/findPersonByNames/{firstName}", produces= { "application/json", "application/xml", "application/x-yaml" })
	public ResponseEntity<?> findPersonByNames(
			@PathVariable("firstName") String firstName,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "12") int limit,
			@RequestParam(value = "direction", defaultValue = "asc") String direction
			) {
		
		var sortDirection = "desc".equalsIgnoreCase(direction) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection,"firstName"));

		Page<PersonVO> persons =  services.findPersonByNames(firstName,pageable);
		persons.stream()
			.forEach(p -> p.add(
				linkTo(methodOn(PersonController.class).findById(p.getIdPerson())).withSelfRel()));
		
		PagedResources<?> resources = assembler.toResource(persons);
		
		return new ResponseEntity<>(resources, HttpStatus.OK);
	}

	//@CrossOrigin(origins = "http://localhost:8080")
	@ApiOperation(value = "Find people by Id")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO findById(@PathVariable(value = "id") Long id) {

		PersonVO personVO = services.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

		return personVO;
	}

	//@CrossOrigin(origins = {"http://localhost:8080","http://www.borges.com.br"})
	@ApiOperation(value = "Create a new people")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public PersonVO create(@RequestBody PersonVO PersonVO) {

		PersonVO personVO =  services.create(PersonVO);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getIdPerson())).withSelfRel());

		return personVO;
	}

	@ApiOperation(value = "Update a People")
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public PersonVO update(@RequestBody PersonVO PersonVO) {

		PersonVO personVO =  services.update(PersonVO);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getIdPerson())).withSelfRel());

		return personVO;
	}
	
	@ApiOperation(value = "Disable a people by Id")
	@PatchMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public PersonVO disablePerson(@PathVariable(value = "id") Long id) {

		PersonVO personVO = services.disablePerson(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

		return personVO;
	}

	@ApiOperation(value = "Delete a People")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {

		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
