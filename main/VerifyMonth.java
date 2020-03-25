package com.zensar.tss.main;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

import com.zensar.tss.exception.InvalidMonthNameException;

public class VerifyMonth {
	static ArrayList<String> months = null;
	public static boolean exists(String inputMonth){
		boolean isValid = false;
		months = new ArrayList<String>();
		String[] monthsArray = new DateFormatSymbols().getMonths();
        for (String month : monthsArray) {
            months.add(month);
        }

        String[] shortMonthsArray = new DateFormatSymbols().getShortMonths();
        for (String shortMonth : shortMonthsArray) {
            months.add(shortMonth);
        }
        for (String string : months) {
        	if (string.equalsIgnoreCase(inputMonth)) {
        		isValid = true;
    			return isValid;
    		} 
		}
		try {
			if (!isValid) {
				throw new InvalidMonthNameException();
			}
		} catch (InvalidMonthNameException e) {
			System.out.println(e.getMessage());
		}
        
		return false;
	}
}
