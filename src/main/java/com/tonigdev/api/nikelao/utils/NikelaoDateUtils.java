package com.tonigdev.api.nikelao.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NikelaoDateUtils {
	
	private static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";


    public static String getDateToday() {
    	
        LocalDate localDate = LocalDate.now();
        
        // Formatear la fecha en el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT_YYYY_MM_DD);;
        return localDate.format(formatter);
    }

}
