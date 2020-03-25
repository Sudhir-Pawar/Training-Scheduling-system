package com.zensar.tss.main;

import java.util.Scanner;

import com.zensar.tss.bean.LinkModuleToProgram;
import com.zensar.tss.dao.LinkModuleToProgramDao;

public class LinkInsert {
	public boolean linkInsert() {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Module code to link to Program(eg. 1001,20):");
		int moduleCode=scanner.nextInt();
		System.out.println("Enter Program code to link to the Module(eg. 203,89):");
		int programCode=scanner.nextInt();
		
		LinkModuleToProgram linkModuleToProgram=new LinkModuleToProgram(moduleCode,programCode);
		LinkModuleToProgramDao linkModuleToProgramDao=new LinkModuleToProgramDao();
		
		if(linkModuleToProgramDao.insert(linkModuleToProgram)) {
		return true;
		}
		else {
			return false;
		}
	}
}
