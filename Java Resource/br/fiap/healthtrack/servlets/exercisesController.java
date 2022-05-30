package br.fiap.healthtrack.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercises")
public class exercisesController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public exercisesController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;		
		this.dispathFileExercises();		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;
		
//		HttpSession dataSesion = request.getSession();		
		
//		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath().concat("/profile/edit.jsp"));        
//		rd.forward(request, response);
		response.sendRedirect(request.getContextPath().concat("/home"));
	}
}
