package com.zensar.tss.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateProgramCodeException extends java.sql.SQLIntegrityConstraintViolationException {
	@Override
	public String getMessage() {
		return "Program code already exists";
	}
}
