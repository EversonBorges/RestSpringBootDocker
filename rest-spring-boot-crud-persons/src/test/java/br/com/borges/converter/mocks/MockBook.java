package br.com.borges.converter.mocks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.borges.data.model.Book;
import br.com.borges.data.vo.BookVO;

public class MockBook {
	
	 public Book mockEntity() {
	    	return mockEntity(0);
	    }
	    
	    public BookVO mockVO() {
	    	return mockVO(0);
	    }
	    
	    public List<Book> mockEntityList() {
	        List<Book> Books = new ArrayList<Book>();
	        for (int i = 0; i < 14; i++) {
	            Books.add(mockEntity(i));
	        }
	        return Books;
	    }

	    public List<BookVO> mockVOList() {
	        List<BookVO> Books = new ArrayList<>();
	        for (int i = 0; i < 14; i++) {
	            Books.add(mockVO(i));
	        }
	        return Books;
	    }
	    
	    private Book mockEntity(Integer number) {
	    	Book Book = new Book();
	    	Book.setAuthor("Machado de Assis" + number);
	        Book.setLaunchDate(formataData("12/05/2020"));
	        Book.setPrice(2.5 + number);
	        Book.setId(number.longValue());
	        Book.setTitle("Olhando as Estrelas" + number);
	        return Book;
	    }

	    private BookVO mockVO(Integer number) {
	    	BookVO Book = new BookVO();
	    	Book.setAuthor("Machado de Assis" + number);
	        Book.setLaunch_date(formataData("12/05/2020"));
	        Book.setPrice(2.5 + number);
	        Book.setIdBook(number.longValue());
	        Book.setTitle("Olhando as Estrelas" + number);
	        return Book;
	    }
	    
	   public Date formataData(String data) {
		   SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
		   Date dataFormatada = null;
		try {
			dataFormatada = stf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		   
		   return dataFormatada;
	   }

}
