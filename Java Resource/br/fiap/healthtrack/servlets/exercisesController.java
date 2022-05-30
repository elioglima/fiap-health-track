package br.fiap.healthtrack.servlets;

import java.io.IOException;
import java.util.ArrayList;

import br.fiap.healthtrack.TypePhyActivity;
import br.fiap.healthtrack.UserPhysicalActivity;
import br.fiap.healthtrack.model.TypePhyactivityModel;
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
		
		try {					
			if (!this.Connect()) return;			
			UserPhysicalActivity userPhysicalActivity = new UserPhysicalActivity(this.Connection, this.user.getId());
			TypePhyActivity typePhyActivity = new TypePhyActivity(this.Connection);
			userPhysicalActivity.findAll();
			this.setSession("userPhysicalActivity", userPhysicalActivity.row);
			
			
			ArrayList<TypePhyactivityModel> listTypePhyActivity = new ArrayList<TypePhyactivityModel>();
			
			do {
				typePhyActivity.findId(userPhysicalActivity.row.getTypePhyActivityId());				
				TypePhyactivityModel t = new TypePhyactivityModel();
				t.setId(userPhysicalActivity.row.getId());
				t.setDescription(typePhyActivity.row.getDescription());
				t.setTimeActivityMinute(userPhysicalActivity.row.getTimeActivityMinute());				
				t.setValueCalorie(userPhysicalActivity.row.getValueCalorie());
				t.setAtUpdate(userPhysicalActivity.row.getAtUpdate());
				listTypePhyActivity.add(t);
			} while (userPhysicalActivity.next());
			
			
			System.out.println(listTypePhyActivity);
			this.setSession("listTypePhyActivity", listTypePhyActivity);
			this.dispathFileExercises();		
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
