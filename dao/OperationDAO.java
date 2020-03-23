package com.zensar.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.tss.bean.TrainingProgram;
import com.zensar.tss.connection.DatabaseConnection;
import com.zensar.tss.exception.CodeNotFoundException;

public class OperationDAO implements OperationInterface<Double, TrainingProgram, Integer >{
	
	Connection connection;
	Integer budget = 0;
	ResultSet resultSet;
	Integer count;
	
	PreparedStatement preparedStatement;


	@Override
	public Integer budgetOfMonth(TrainingProgram p) {
		boolean status=false;
		
				try {
					String month;
					month=p.getExecutionMonth();
					connection=DatabaseConnection.getConnection();
					
					
					PreparedStatement preparedStatementCheckProgram = connection.prepareStatement("select * from Training_Program where Execution_Months = ?");
					preparedStatementCheckProgram.setString(1, month);
					ResultSet resultSetCheckProgram = preparedStatementCheckProgram.executeQuery();
					
					 if (!resultSetCheckProgram.isBeforeFirst())
							throw new CodeNotFoundException("Program");
					 else {
						 	PreparedStatement preparedStatement=connection.prepareStatement("select sum(Training_Module.Budget_per_Day) from Training_Module inner join Link_TM_TP using(Training_Module_Code) inner join Training_Program using(Training_Program_Code) where Execution_Months=?");
							preparedStatement.setString(1, month);
							ResultSet resultSet=preparedStatement.executeQuery();
							resultSet.next();
							budget=resultSet.getInt(1);
					 }
					
					
				} catch (CodeNotFoundException e) {
					System.out.println("No program allotted in the entered month.");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return budget;
	}


	@Override
	public Integer countModule(TrainingProgram a) {
		int code;
		count=0;
		try {
			connection=DatabaseConnection.getConnection();
			
			PreparedStatement preparedStatementCheckProgram = connection.prepareStatement("select * from Training_Program where Training_Program_Code = ?");
			preparedStatementCheckProgram.setInt(1, a.getTrainingProgramCode());
			ResultSet resultSetCheckProgram = preparedStatementCheckProgram.executeQuery();
			
			 if (!resultSetCheckProgram.isBeforeFirst())
					throw new CodeNotFoundException("Program");
			else {
				preparedStatement=connection.prepareStatement("select Training_Module_Code from  Link_TM_TP where Training_Program_Code=?");
				code=a.getTrainingProgramCode();
				preparedStatement.setInt(1, code);
				resultSet=preparedStatement.executeQuery();
				while(resultSet.next())
					count++;
			}
			
		} catch (CodeNotFoundException e) {
			System.out.println(e.getMessage());
	
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		return count;
	}

	@Override
	public Double displayTotalFinancialBudget() {
		// TODO Auto-generated method stub
		ResultSet resultSet = null;
		connection=DatabaseConnection.getConnection();
		double total  = 0;
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement("select sum(Training_Module.Budget_per_Day) from Training_Module NATURAL JOIN Link_TM_TP");
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			total = resultSet.getDouble(1);
			return total;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return total;
	}
}
