package com.zensar.tss.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.zensar.tss.bean.TrainingModule;
import com.zensar.tss.dao.TrainingModuleDAO;

public class ModuleInsert {
	
	
	public boolean moduleInsert() throws IOException { 
	Scanner scanner=new Scanner(System.in);
	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	System.out.println("Enter the Module code(eg. 1001,1234,9):");
	int id=scanner.nextInt();
	System.out.println("Enter the name of the Module:");
	String name= bufferedReader.readLine();
	System.out.println("Enter the duration of the Module in days(eg. 2,6,9):");
	int duration=scanner.nextInt();
	System.out.println("Enter the budget per day(eg. 10,200,50):");
	int budget=scanner.nextInt();
	
	TrainingModule trainingModule=new TrainingModule(id,name,duration,budget);
	TrainingModuleDAO trainingModuleDAO=new TrainingModuleDAO();
	
	if(trainingModuleDAO.insert(trainingModule)) {
		return true;
	}
	else {
		return false; 
	}
}
}