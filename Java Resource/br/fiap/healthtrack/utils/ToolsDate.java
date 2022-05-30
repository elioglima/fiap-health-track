package br.fiap.healthtrack.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class ToolsDate {
	public static String now() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	public static java.sql.Date DateToSQLDate(Date date) {		
		return new java.sql.Date(date.getTime());
	}
}
