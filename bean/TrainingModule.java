package com.zensar.tss.bean;

public class TrainingModule {
	private int trainingModuleCode;
	private String moduleName;
	private int durationOfDays;
	private int budgetPerDay;
	
	public TrainingModule() {
		
	}
	
	public TrainingModule(int trainingModuleCode, String moduleName, int durationOfDays, int budgetPerDay) {
		super();
		this.trainingModuleCode = trainingModuleCode;
		this.moduleName = moduleName;
		this.durationOfDays = durationOfDays;
		this.budgetPerDay = budgetPerDay;
	}

	public int getTrainingModuleCode() {
		return this.trainingModuleCode;
	}	
	
	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public int getDurationOfDays() {
		return durationOfDays;
	}

	public void setDurationOfDays(int durationOfDays) {
		this.durationOfDays = durationOfDays;
	}

	public int getBudgetPerDay() {
		return budgetPerDay;
	}

	public void setBudgetPerDay(int budgetPerDay) {
		this.budgetPerDay = budgetPerDay;
	}

	public void setTrainingModuleCode(int trainingModuleCode) {
		this.trainingModuleCode = trainingModuleCode;
	}
	
	
	@Override
	public String toString() {
		return "TrainingModuleBeans [Training_Module_Code=" + trainingModuleCode + ", Module_Name=" + moduleName
				+ ", Duration_of_Days=" + durationOfDays + ", Budget_per_Day=" + budgetPerDay + "]";
	}

}
