package com.zensar.tss.bean;

public class TrainingProgram {
	private int trainingProgramCode;
	private String programName;
	private String executionMonth;
	
	public TrainingProgram() {
		
	}
		
	public TrainingProgram(int trainingProgramCode) {
		super();
		this.trainingProgramCode = trainingProgramCode;
	}

	public TrainingProgram(String executionMonth) {
		super();
		this.executionMonth = executionMonth;
	}

	public TrainingProgram(int trainingProgramCode, String programName, String executionMonth) {
		super();
		this.trainingProgramCode = trainingProgramCode;
		this.programName = programName;
		this.executionMonth = executionMonth;
	}

	public int getTrainingProgramCode() {
		return trainingProgramCode;
	}

	public void setTrainingProgramCode(int trainingProgramCode) {
		this.trainingProgramCode = trainingProgramCode;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getExecutionMonth() {
		return executionMonth;
	}

	public void setExecutionMonth(String executionMonth) {
		this.executionMonth = executionMonth;
	}
}
