package br.fiap.healthtrack.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class logoutController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public logoutController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);		
		HttpSession dataSesion = request.getSession(false);
		
		if (dataSesion != null) 
	        request.getSession(true).invalidate();
	    		
		this.redirLogin();
	}
}
