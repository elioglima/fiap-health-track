package br.fiap.healthtrack.utils;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ToolsValidation {
	
	public static boolean mailIsValide(String value) {		
		String regx = "^([\\w\\.\\-]+)@([\\w\\-]+)((\\.(\\w){2,3})+)$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	public static boolean phoneMobileIsValide(String value) {		
		String regx = "/^(?:(?:\\+|00)?(55)\\s?)?(?:\\(?([1-9][0-9])\\)?\\s?)?(?:((?:9\\d|[2-9])\\d{3})\\-?(\\d{4}))$/";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}
	
	public static boolean passwordIsValide(String value) {		
		String regx = "^(?=.*?[A-Z])(?=(.*[a-z]){1,})(?=(.*[\\d]){1,})(?=(.*[\\W]){1,})(?!.*\\s).{8,}$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(value);
		System.out.println(value);
		System.out.println(matcher.matches());
		return matcher.matches();
	}
}
