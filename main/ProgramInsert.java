package com.zensar.tss.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.zensar.tss.bean.TrainingModule;
import com.zensar.tss.bean.TrainingProgram;
import com.zensar.tss.dao.TrainingModuleDAO;
import com.zensar.tss.dao.TrainingProgramDAO;

public class ProgramInsert {
	public boolean programInsert() throws IOException {
		Scanner scanner=new Scanner(System.in);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter the program code(eg. 2001,2345,8):");
		int id=scanner.nextInt();
		System.out.println("Enter the name of the program:");
		String name= bufferedReader.readLine();
		System.out.println("Enter the execution month of the program:(Eg. JAN/Jan)");
		String month= bufferedReader.readLine();
		month = month.toUpperCase();
		
		if (VerifyMonth.exists(month)) {
			TrainingProgram trainingProgram=new TrainingProgram(id,name,month);
			TrainingProgramDAO trainingProgramDAO=new TrainingProgramDAO();
			
			if(trainingProgramDAO.insert(trainingProgram)) {
				return true;
			}
			else {
				return false; 
			}
		}
		return false;
	}
}
