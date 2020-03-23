package com.zensar.tss.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zensar.tss.bean.TrainingModule;
import com.zensar.tss.connection.*;
import com.zensar.tss.exception.DuplicateModuleCodeException;
public class TrainingModuleDAO implements TrainingInterface<Boolean, TrainingModule>{

	Connection connection=null;
	@Override
	public Boolean insert(TrainingModule tm) {
		boolean status=false;
		try {
			connection=DatabaseConnection.getConnection();
			PreparedStatement preparedStatement = connection .prepareStatement("select * from Training_Module where Training_Module_Code = ?");
			preparedStatement.setInt(1, tm.getTrainingModuleCode());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.isBeforeFirst() ) {    
				PreparedStatement preparedStatement2=connection.prepareStatement("insert into Training_Module values(?,?,?,?)");	
				preparedStatement2.setInt(1, tm.getTrainingModuleCode());
				preparedStatement2.setString(2, tm.getModuleName());
				preparedStatement2.setInt(3, tm.getDurationOfDays());
				preparedStatement2.setInt(4,tm.getBudgetPerDay());
				int cnt=preparedStatement2.executeUpdate();
				if(cnt>0)
					status=true;
			} else {
				throw new DuplicateModuleCodeException();
			}
		} catch (DuplicateModuleCodeException e) {
			System.out.println(e.getMessage());		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return status;
	}

}
