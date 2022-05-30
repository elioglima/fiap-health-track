package br.fiap.healthtrack.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/offline")
public class offlineController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public offlineController() {
		super();
	}	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		System.out.println(1233);
		this.redirFileOffline();		
	}	
}
