package br.fiap.healthtrack.servlets;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/measurements/edit")
public class measurementsEditController extends RouterController {	
	private static final long serialVersionUID = 1L;

	public measurementsEditController() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/measurements/edit.goGet");
		super.doGet(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/measurementsEdit.jsp");  
        try {        	
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Home error");
			e.printStackTrace();
		} 
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/measurements/edit.doPost");

		super.doPost(request, response);
		
//		HttpSession dataSesion = request.getSession();		
		
//		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath().concat("/profile/edit.jsp"));        
//		rd.forward(request, response);
		try {
			response.sendRedirect(request.getContextPath().concat("/home"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
