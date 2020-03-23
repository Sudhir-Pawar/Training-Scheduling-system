package com.zensar.tss.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class DuplicateModuleCodeException extends SQLIntegrityConstraintViolationException{
	@Override
	public String getMessage() {
		return "Module code already exists";
	}
}
