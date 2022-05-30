package br.fiap.healthtrack.utils;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public abstract class SessionUtils {	
    public static boolean checked(HttpServletRequest request, HttpServletResponse response) {    	
    	try {
    		HttpSession dataSesion = request.getSession();
    		boolean isLogged = dataSesion.getAttribute("isLogged") == null ? false : (boolean) dataSesion.getAttribute("isLogged");
    		if (!isLogged) {			
				response.sendRedirect(request.getContextPath().concat("/login"));				
    		}
    		return true;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return false;
    }    
    
    public static Object getData(HttpServletRequest request, String name) {
    	HttpSession dataSesion = request.getSession();
    	return dataSesion.getAttribute(name);		
    }    

}
