package com.zensar.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.tss.bean.TrainingProgram;
import com.zensar.tss.connection.DatabaseConnection;
import com.zensar.tss.exception.DuplicateProgramCodeException;

public class TrainingProgramDAO implements TrainingInterface<Boolean,TrainingProgram>{

	Connection connection=null;
	@Override
	public Boolean insert(TrainingProgram tp) {
		boolean status=false;
		try {
			int trainingProgramCode=tp.getTrainingProgramCode();
			String programName=tp.getProgramName();
			String executionMonth=tp.getExecutionMonth();
			
			connection=DatabaseConnection.getConnection();
			
			PreparedStatement preparedStatement = connection .prepareStatement("select * from Training_Program where Training_Program_Code = ?");
			preparedStatement.setInt(1, trainingProgramCode);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst() ) {    
				PreparedStatement preparedStatement2=connection.prepareStatement("insert into Training_Program values(?,?,?)");
				preparedStatement2.setInt(1, trainingProgramCode);
				preparedStatement2.setString(2,programName);
				preparedStatement2.setString(3, executionMonth);
				int count=preparedStatement2.executeUpdate();
				if(count>0)
					status=true;
			} else {
				throw new DuplicateProgramCodeException();
			}	
			
		} catch (DuplicateProgramCodeException e) {
			System.out.println(e.getMessage());		
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
		return status;
	
	}
	

}
