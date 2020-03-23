package com.zensar.tss.exception;

public class InvalidMonthNameException extends Exception{
	@Override
	public String getMessage() {
		return "Please Enter a valid month name";
	}
}
