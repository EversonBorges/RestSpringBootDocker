package br.com.borges.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.borges.data.vo.PersonVO;
import br.com.borges.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@GetMapping(produces = {"application/json","application/xml"})
	public List<PersonVO> findByAll(){
		
		return services.findAll();
	}
	
	@GetMapping(value = "/{id}",produces = {"application/json","application/xml"})
	public PersonVO findById(@PathVariable(value = "id") Long id){
		
		return services.findById(id);
	}
	
	@PostMapping(produces = {"application/json","application/xml"},
				 consumes = {"application/json","application/xml"})
	public PersonVO create(@RequestBody PersonVO PersonVO){
		
		return services.create(PersonVO);
	}
	
	@PutMapping(produces = {"application/json","application/xml"},
			    consumes = {"application/json","application/xml"})
	public PersonVO update(@RequestBody PersonVO PersonVO){
		
		return services.update(PersonVO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
		
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
