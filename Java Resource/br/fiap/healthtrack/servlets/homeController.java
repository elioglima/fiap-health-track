package br.fiap.healthtrack.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class homeController extends RouterController {
	private static final long serialVersionUID = 1L;

	public homeController() {
		super();
	}	
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;		
		this.dispathFileHome();		
	}
	
	
}
