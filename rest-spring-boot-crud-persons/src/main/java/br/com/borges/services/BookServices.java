package br.com.borges.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.borges.converter.DozerConverter;
import br.com.borges.data.model.Book;
import br.com.borges.data.vo.BookVO;
import br.com.borges.exception.ResourceNotFoundException;
import br.com.borges.repository.BookRepository;


@Service
public class BookServices {

	@Autowired
	private BookRepository repository;
	
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public List<BookVO> findAll() {
		
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
	}
	
	public BookVO findById(Long id) {
		var entity =  repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + id));
		return DozerConverter.parseObject(entity, BookVO.class);
	}

	public BookVO update(BookVO book) {
		
		var entity = repository.findById(book.getIdBook())
				.orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + book.getId()));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunch_date());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Book entity = repository.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Não há dados para o Id " + id));
		
		repository.delete(entity);
	}
}
