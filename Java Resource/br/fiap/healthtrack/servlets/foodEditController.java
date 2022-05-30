package br.fiap.healthtrack.servlets;

import java.io.IOException;

import br.fiap.healthtrack.utils.SessionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/food/edit")
public class foodEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public foodEditController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("/food/edit.goGet");
		
		RequestDispatcher rd = request.getRequestDispatcher("/foodEdit.jsp");  
        try {        	
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Home error");
			e.printStackTrace();
		} 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/food/edit.doPost");

		if (!SessionUtils.checked(request, response)) return;
		
//		HttpSession dataSesion = request.getSession();		
		
//		RequestDispatcher rd = request.getRequestDispatcher(request.getContextPath().concat("/profile/edit.jsp"));        
//		rd.forward(request, response);
		response.sendRedirect(request.getContextPath().concat("/home"));
	}
}
