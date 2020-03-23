package com.zensar.tss.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class CodeNotFoundException extends SQLIntegrityConstraintViolationException {
	String codeName;
	
	public CodeNotFoundException(String codeName) {
		super();
		this.codeName = codeName;
	}


	@Override
	public String getMessage() {
		return  codeName + " code not found";
	}
}
