package com.zensar.tss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.tss.bean.LinkModuleToProgram;
import com.zensar.tss.connection.DatabaseConnection;
import com.zensar.tss.exception.CodeNotFoundException;
import com.zensar.tss.exception.DuplicateModuleCodeException;
import com.zensar.tss.exception.DuplicateProgramCodeException;

public class LinkModuleToProgramDao implements TrainingInterface <Boolean, LinkModuleToProgram>{
	Connection connection;

	@Override
	public Boolean insert(LinkModuleToProgram p) {
		boolean status = false;
		try {
			connection=DatabaseConnection.getConnection();
			
			PreparedStatement preparedStatementCheckModule = connection.prepareStatement("select * from Training_Module where Training_Module_Code = ?");
			preparedStatementCheckModule.setInt(1, p.getTrainingModuleCode());
			ResultSet resultSetCheckModule = preparedStatementCheckModule.executeQuery();
			
			
			PreparedStatement preparedStatementCheckProgram = connection.prepareStatement("select * from Training_Program where Training_Program_Code = ?");
			preparedStatementCheckProgram.setInt(1, p.getTrainingProgramCode());
			ResultSet resultSetCheckProgram = preparedStatementCheckProgram.executeQuery();
			
			if (!resultSetCheckModule.isBeforeFirst() ) {    
				throw new CodeNotFoundException("Module");
			} else if (!resultSetCheckProgram.isBeforeFirst()){
				throw new CodeNotFoundException("Program");
			} else {
				PreparedStatement preparedStatement=connection.prepareStatement("insert into Link_TM_TP values(?,?)");
								
				preparedStatement.setInt(1, p.getTrainingModuleCode());
				preparedStatement.setInt(2,p.getTrainingProgramCode());
				
				int cnt=preparedStatement.executeUpdate();
				
				if(cnt>0)
					status=true;
			}
		} catch (CodeNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return status;
	}
	
	
	

}
