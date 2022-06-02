package br.fiap.healthtrack.servlets;

import java.io.IOException;
import java.util.ArrayList;
import br.fiap.healthtrack.UserBloodPressure;
import br.fiap.healthtrack.model.UserBloodPressureModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/measurements")
public class measurememtsController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public measurememtsController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;		
		
		try {					
			if (!this.Connect()) return;			
			
			// BATIMENTO CARDIACO
			UserBloodPressure userBloodPressure = new UserBloodPressure(this.Connection, this.user.getId());
			userBloodPressure.findAll(20);
			
			ArrayList<UserBloodPressureModel> listUserBloodPressure = new ArrayList<UserBloodPressureModel>();			
			if (userBloodPressure.getRecordCount() > 0) {				
				do {
					UserBloodPressureModel t = new UserBloodPressureModel();
					t.setId(userBloodPressure.row.getId());
					t.setValueBeats(userBloodPressure.row.getValueBeats());
					t.setValueMax(userBloodPressure.row.getValueMax());
					t.setValueMin(userBloodPressure.row.getValueMin());					
					t.setAtUpdate(userBloodPressure.row.getAtUpdate());
					listUserBloodPressure.add(t);
				} while (userBloodPressure.next());
			}			
			
			System.out.println(listUserBloodPressure);
			this.setSession("listUserBloodPressure", listUserBloodPressure);			
			this.dispathFileMeasurememts();		
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
