package br.com.borges.exception;

public class ValueLessThanZeroException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ValueLessThanZeroException(String exception) {
		super(exception);
	}

}
