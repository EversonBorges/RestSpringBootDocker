package br.com.borges.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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

import br.com.borges.data.vo.BookVO;
import br.com.borges.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Book Endpoint")
@RestController
@RequestMapping("api/book")
public class BookController {

	@Autowired
	private BookServices services;

	@ApiOperation(value = "Find all book")
	@GetMapping(produces = { "application/json", "application/xml", "application/x-yaml" })
	public List<BookVO> findByAll() {

		List<BookVO> books =  services.findAll();
		books.stream()
			.forEach(p -> p.add(
				linkTo(methodOn(BookController.class).findById(p.getIdBook())).withSelfRel()));
		
		return books;
	}

	@ApiOperation(value = "Find book by Id")
	@GetMapping(value = "/{id}", produces = { "application/json", "application/xml", "application/x-yaml" })
	public BookVO findById(@PathVariable(value = "id") Long id) {

		BookVO bookVO = services.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());

		return bookVO;
	}

	@ApiOperation(value = "Create a new book")
	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BookVO create(@RequestBody BookVO reqBookVO) {

		BookVO bookVO =  services.create(reqBookVO);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getIdBook())).withSelfRel());

		return bookVO;
	}

	@ApiOperation(value = "Update a Book" )
	@PutMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	public BookVO update(@RequestBody BookVO reqBookVO) {

		BookVO bookVO =  services.update(reqBookVO);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getIdBook())).withSelfRel());

		return bookVO;
	}

	@ApiOperation(value = "Delete a book")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {

		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
