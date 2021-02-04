package br.com.borges.service;

public class ValidationService {

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) {
			return 0D;
		}
		String number = strNumber.replaceAll(",", ",");

		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}

	public static boolean isNumeric(String strNumber) {

		if (strNumber == null) {
			return false;
		}
		String number = strNumber.replaceAll(",", ",");

		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	public static boolean isNumberZero(String strNumber) {

		if (strNumber == null) {
			return true;
		}

		String number = strNumber.replaceAll(",", ",");

		if (isNumeric(number)) {
		 
		 	if(Double.parseDouble(number) == 0D) {
		 		return true;
		 	}
		}
		return false;
	}

	public static boolean isMenorZero(String strNumber) {
		if (strNumber == null) {
			return true;
		}

		String number = strNumber.replaceAll(",", ",");

		if (isNumeric(number)) {
		 
		 	if(Double.parseDouble(number) < 0D) {
		 		return true;
		 	}
		}
		return false;
	}

}
