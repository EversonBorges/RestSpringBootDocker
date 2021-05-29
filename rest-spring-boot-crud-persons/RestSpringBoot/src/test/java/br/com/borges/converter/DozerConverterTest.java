package br.com.borges.converter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.borges.converter.mocks.MockBook;
import br.com.borges.converter.mocks.MockPerson;
import br.com.borges.data.model.Book;
import br.com.borges.data.model.Person;
import br.com.borges.data.vo.BookVO;
import br.com.borges.data.vo.PersonVO;

public class DozerConverterTest {
	
	 MockPerson inputObject;
	 
	    @Before
	    public void setUp() {
	        inputObject = new MockPerson();
	    }

	    @Test
	    public void parseEntityToVOTest() {
	        PersonVO output = DozerConverter.parseObject(inputObject.mockEntity(), PersonVO.class);
	        Assert.assertEquals(Long.valueOf(0L), output.getIdPerson());
	        Assert.assertEquals("First Name Test0", output.getFirstName());
	        Assert.assertEquals("Last Name Test0", output.getLastName());
	        Assert.assertEquals("Addres Test0", output.getAddress());
	        Assert.assertEquals("Male", output.getGender());
	    }

	    @Test
	    public void parseEntityListToVOListTest() {
	        List<PersonVO> outputList = DozerConverter.parseListObjects(inputObject.mockEntityList(), PersonVO.class);
	        PersonVO outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getIdPerson());
	        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
	        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
	        Assert.assertEquals("Addres Test0", outputZero.getAddress());
	        Assert.assertEquals("Male", outputZero.getGender());
	        
	        PersonVO outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getIdPerson());
	        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
	        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
	        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
	        Assert.assertEquals("Female", outputSeven.getGender());
	        
	        PersonVO outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getIdPerson());
	        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
	        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
	        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
	        Assert.assertEquals("Male", outputTwelve.getGender());
	    }

	    @Test
	    public void parseVOToEntityTest() {
	        Person output = DozerConverter.parseObject(inputObject.mockVO(), Person.class);
	        Assert.assertEquals(Long.valueOf(0L), output.getId());
	        Assert.assertEquals("First Name Test0", output.getFirstName());
	        Assert.assertEquals("Last Name Test0", output.getLastName());
	        Assert.assertEquals("Addres Test0", output.getAddress());
	        Assert.assertEquals("Male", output.getGender());
	    }

	    @Test
	    public void parserVOListToEntityListTest() {
	        List<Person> outputList = DozerConverter.parseListObjects(inputObject.mockVOList(), Person.class);
	        Person outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
	        Assert.assertEquals("First Name Test0", outputZero.getFirstName());
	        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
	        Assert.assertEquals("Addres Test0", outputZero.getAddress());
	        Assert.assertEquals("Male", outputZero.getGender());
	        
	        Person outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
	        Assert.assertEquals("First Name Test7", outputSeven.getFirstName());
	        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
	        Assert.assertEquals("Addres Test7", outputSeven.getAddress());
	        Assert.assertEquals("Female", outputSeven.getGender());
	        
	        Person outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        Assert.assertEquals("First Name Test12", outputTwelve.getFirstName());
	        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
	        Assert.assertEquals("Addres Test12", outputTwelve.getAddress());
	        Assert.assertEquals("Male", outputTwelve.getGender());
	    }
	    
	    MockBook book;
	    
	    @Before
	    public void setUpBook() {
	    	book = new MockBook();
	    }
	   
	    @Test
	    public void parseEntityBookToVOTest() {
	        BookVO output = DozerConverter.parseObject(book.mockEntity(), BookVO.class);
	        Assert.assertEquals(Long.valueOf(0L), output.getIdBook());
	        Assert.assertEquals("Machado de Assis0", output.getAuthor());
	        Assert.assertEquals(book.formataData("12/05/2020"), output.getLaunch_date());
	        Assert.assertEquals("2.5", output.getPrice().toString());
	        Assert.assertEquals("Olhando as Estrelas0", output.getTitle());
	    }

	    @Test
	    public void parseEntityListBookToVOListTest() {
	        List<BookVO> outputList = DozerConverter.parseListObjects(book.mockEntityList(), BookVO.class);
	        BookVO outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getIdBook());
	        Assert.assertEquals("Machado de Assis0", outputZero.getAuthor());
	        Assert.assertEquals(book.formataData("12/05/2020"), outputZero.getLaunch_date());
	        Assert.assertEquals("2.5", outputZero.getPrice().toString());
	        Assert.assertEquals("Olhando as Estrelas0", outputZero.getTitle());
	        
	        BookVO outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getIdBook());
	        Assert.assertEquals("Machado de Assis7", outputSeven.getAuthor());
	        Assert.assertEquals(book.formataData("12/05/2020"), outputSeven.getLaunch_date());
	        Assert.assertEquals("9.5", outputSeven.getPrice().toString());
	        Assert.assertEquals("Olhando as Estrelas7", outputSeven.getTitle());
	        
	        BookVO outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getIdBook());
	        Assert.assertEquals("Machado de Assis12", outputTwelve.getAuthor());
	        Assert.assertEquals(book.formataData("12/05/2020"), outputTwelve.getLaunch_date());
	        Assert.assertEquals("14.5", outputTwelve.getPrice().toString());
	        Assert.assertEquals("Olhando as Estrelas12", outputTwelve.getTitle());
	    }

	    @Test
	    public void parseVOToEntityBookTest() {
	        Book output = DozerConverter.parseObject(book.mockVO(), Book.class);
	        
	        Assert.assertEquals(Long.valueOf(0L), output.getId());
	        Assert.assertEquals("Machado de Assis0", output.getAuthor());
	        Assert.assertEquals(book.formataData("12/05/2020"), output.getLaunchDate());
	        Assert.assertEquals("2.5", output.getPrice().toString());
	        Assert.assertEquals("Olhando as Estrelas0", output.getTitle());
	        
	    }

	    @Test
	    public void parserVOListBookToEntityListTest() {
	        List<Book> outputList = DozerConverter.parseListObjects(book.mockVOList(), Book.class);
	        Book outputZero = outputList.get(0);
	        
	        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
	        Assert.assertEquals("Machado de Assis0", outputZero.getAuthor());
	        Assert.assertEquals(book.formataData("12/05/2020"), outputZero.getLaunchDate());
	        Assert.assertEquals("2.5", outputZero.getPrice().toString());
	        Assert.assertEquals("Olhando as Estrelas0", outputZero.getTitle());
	        
	        Book outputSeven = outputList.get(7);
	        
	        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
	        Assert.assertEquals("Machado de Assis7", outputSeven.getAuthor());
	        Assert.assertEquals(book.formataData("12/05/2020"), outputSeven.getLaunchDate());
	        Assert.assertEquals("9.5", outputSeven.getPrice().toString());
	        Assert.assertEquals("Olhando as Estrelas7", outputSeven.getTitle());
	        
	        Book outputTwelve = outputList.get(12);
	        
	        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
	        Assert.assertEquals("Machado de Assis12", outputTwelve.getAuthor());
	        Assert.assertEquals(book.formataData("12/05/2020"), outputTwelve.getLaunchDate());
	        Assert.assertEquals("14.5", outputTwelve.getPrice().toString());
	        Assert.assertEquals("Olhando as Estrelas12", outputTwelve.getTitle());
	    }


}
