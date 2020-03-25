package com.zensar.tss.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.zensar.tss.bean.TrainingProgram;
import com.zensar.tss.dao.OperationDAO;

public class MainClass {

	public static void main(String[] args) throws IOException {
		int choice=0,totalBudgetOfMonth, programCode;
		Integer moduleCount;
		String ch = null;
		ProgramInsert programInsert=new ProgramInsert();
		ModuleInsert moduleInsert=new ModuleInsert();
		LinkInsert linkInsert=new LinkInsert();
		String month = new String();
		OperationDAO operationDAO=new OperationDAO();
		TrainingProgram trainingProgram=new TrainingProgram();
		System.out.println("\t\tTraining Scheduling System");
		do {
			Scanner scanner=new Scanner(System.in);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\nMenu");
			System.out.println("\n1. Create a new training module");
			System.out.println("2. Create a new training program");
			System.out.println("3. Link training module to training program ");
			System.out.println("4. Display total financial budget");
			System.out.println("5. Display budget according to month");
			System.out.println("6. Display total modules for particular program");
			System.out.println("7. Exit");
			System.out.print("\nEnter your choice:");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				if (moduleInsert.moduleInsert()) {
					System.out.println("Module inserted successfully");
				}
				break;
				
			case 2:
				if (programInsert.programInsert()) {
					System.out.println("Program inserted successfully");
				}
				break;
			
			case 3:
				if(linkInsert.linkInsert()) {
					System.out.println("Module and Program Linked successfully");
				}
				break;
				
				
			case 4:
				System.out.println(operationDAO.displayTotalFinancialBudget());
				break;
			
			case 5:
				System.out.println("Enter month:(Eg. JAN/Jan)");
				month = bufferedReader.readLine().trim();
				month = month.toUpperCase();
				trainingProgram.setExecutionMonth(month);
				if (VerifyMonth.exists(month)) {
					totalBudgetOfMonth=operationDAO.budgetOfMonth(trainingProgram);
					if (totalBudgetOfMonth != 0) 
						System.out.println("Budget:"+totalBudgetOfMonth);
				}	
				break;
			
			case 6:
				System.out.println("Enter the program code(eg:2001):");
				programCode = scanner.nextInt();
				trainingProgram.setTrainingProgramCode(programCode);
				moduleCount=operationDAO.countModule(trainingProgram);
				if (moduleCount > 0) 
					System.out.println("Count:"+moduleCount);
				break;
				
				
			case 7:
				System.out.println("Exiting the application...");
				System.exit(0);
				break;
			
			default:
				System.out.println("Enter a valid choice");
				break;
			
			}
			System.out.println("------------------------------------------------------------------------------------------------");
			System.out.println("DO you want to continue(Y/N)?");
			ch=scanner.next();
			
		
		
		}while(ch.equals("Y")||ch.equals("y"));
		
	}

}
