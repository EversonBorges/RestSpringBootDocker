package br.com.borges.service;

public class OperationService {
	
	public  Double soma(String numberOne, String numberTwo) {
		return ValidationService.convertToDouble(numberOne) + ValidationService.convertToDouble(numberTwo);
	}
	
	public Double subtracao(String numberOne, String numberTwo) {
		return ValidationService.convertToDouble(numberOne) - ValidationService.convertToDouble(numberTwo);
	}
	
	public Double multiplicacao(String numberOne, String numberTwo) {
		return  ValidationService.convertToDouble(numberOne) * ValidationService.convertToDouble(numberTwo);
	}
	
	public double divisao(String numberOne, String numberTwo) {
		return ValidationService.convertToDouble(numberOne) / ValidationService.convertToDouble(numberTwo);
	}
	
	public Double media(String numberOne, String numberTwo) {
		return (ValidationService.convertToDouble(numberOne) + ValidationService.convertToDouble(numberTwo))/2;
	}
	
	public double raizQuadrada(String number) {
		return Math.sqrt(ValidationService.convertToDouble(number));
	}
}
