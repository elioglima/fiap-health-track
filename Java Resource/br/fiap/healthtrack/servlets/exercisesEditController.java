package br.fiap.healthtrack.servlets;

import java.io.IOException;
import java.util.ArrayList;

import br.fiap.healthtrack.*;
import br.fiap.healthtrack.model.TypePhyactivityModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/exercises/edit")
public class exercisesEditController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public exercisesEditController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;
		
		try {					
			if (!this.Connect()) return;			
			UserPhysicalActivity userPhysicalActivity = new UserPhysicalActivity(this.Connection, this.user.getId());
			TypePhyActivity typePhyActivity = new TypePhyActivity(this.Connection);
			userPhysicalActivity.findAll();
			this.setSession("userPhysicalActivity", userPhysicalActivity.row);
			
			typePhyActivity.findAll();
			ArrayList<TypePhyactivityModel> listTypePhyActivity = new ArrayList<TypePhyactivityModel>();
			
			do {			

				TypePhyactivityModel t = new TypePhyactivityModel();
				t.setResult(typePhyActivity.getResultQuery());
				listTypePhyActivity.add(t);
				
				System.out.println(typePhyActivity.row.getDescription());
			} while (typePhyActivity.next());
			
			
			System.out.println(listTypePhyActivity);
			this.setSession("listTypePhyActivity", listTypePhyActivity);
			this.dispathFileExercisesEdit();		
		} finally {
			this.Close();
		}
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
