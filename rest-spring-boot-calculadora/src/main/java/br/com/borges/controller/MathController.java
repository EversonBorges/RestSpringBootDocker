package br.com.borges.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.borges.exception.DivisionArithmeticException;
import br.com.borges.exception.UnsuportedMathOperationException;
import br.com.borges.exception.ValueLessThanZeroException;
import br.com.borges.service.OperationService;
import br.com.borges.service.ValidationService;

@RestController
public class MathController {
	
	OperationService service = new OperationService();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double soma(@PathVariable(value = "numberOne") String numberOne, 
						    @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!ValidationService.isNumeric(numberOne) || !ValidationService.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Informe um valor numerico !");
		}
		
		return service.soma(numberOne, numberTwo);
	}

	@RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtrcao(@PathVariable(value = "numberOne") String numberOne, 
						    @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!ValidationService.isNumeric(numberOne) || !ValidationService.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Informe um valor numerico !");
		}
		
		return service.subtracao(numberOne, numberTwo);
	}

	@RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplicacao(@PathVariable(value = "numberOne") String numberOne, 
						    @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!ValidationService.isNumeric(numberOne) || !ValidationService.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Informe um valor numerico !");
		}
		
		return service.multiplicacao(numberOne, numberTwo);
	}

	@RequestMapping(value = "/divisao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double divisao(@PathVariable(value = "numberOne") String numberOne, 
						    @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!ValidationService.isNumeric(numberOne) || !ValidationService.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Informe um valor numerico !");
		}
		
		if(ValidationService.isNumberZero(numberOne)|| ValidationService.isNumberZero(numberTwo)) {
			throw new DivisionArithmeticException("Não é possivel dividir por Zero ou Nulo!");
		}
		
		return service.divisao(numberOne, numberTwo);
	}

	@RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable(value = "numberOne") String numberOne, 
						    @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!ValidationService.isNumeric(numberOne) || !ValidationService.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Informe um valor numerico !");
		}
		
		return service.media(numberOne, numberTwo);
	}
	
	@RequestMapping(value = "/raiz-quadrada/{number}", method = RequestMethod.GET)
	public Double raizQuadrada(@PathVariable(value = "number") String number) throws Exception {
		
		if(!ValidationService.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Informe um valor numerico !");
		}
		
		if(ValidationService.isMenorZero(number)) {
			throw new ValueLessThanZeroException("Não existe Raiz Quadrada de valor negativo !");
		}
		
		return  service.raizQuadrada(number);
	}
}
