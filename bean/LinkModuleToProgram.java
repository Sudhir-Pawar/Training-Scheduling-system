package com.zensar.tss.bean;

public class LinkModuleToProgram {
	private int trainingModuleCode;
	private int trainingProgramCode;
	
	public LinkModuleToProgram() {
		
	}

	public LinkModuleToProgram(int trainingModuleCode, int trainingProgramCode) {
		super();
		this.trainingModuleCode = trainingModuleCode;
		this.trainingProgramCode = trainingProgramCode;
	}

	public int getTrainingModuleCode() {
		return trainingModuleCode;
	}

	public void setTrainingModuleCode(int trainingModuleCode) {
		this.trainingModuleCode = trainingModuleCode;
	}

	public int getTrainingProgramCode() {
		return trainingProgramCode;
	}

	public void setTrainingProgramCode(int trainingProgramCode) {
		this.trainingProgramCode = trainingProgramCode;
	}
}
