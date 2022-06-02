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
			userPhysicalActivity.findAll(100);
			this.setSession("userPhysicalActivity", userPhysicalActivity.row);
			
			typePhyActivity.findAll(100);
			ArrayList<TypePhyactivityModel> listTypePhyActivity = new ArrayList<TypePhyactivityModel>();
			
			if (typePhyActivity.getRecordCount() > 0) {				
				do {			
	
					TypePhyactivityModel t = new TypePhyactivityModel();
					t.setResult(typePhyActivity.getResultQuery());
					listTypePhyActivity.add(t);
					
					System.out.println(typePhyActivity.row.getDescription());
				} while (typePhyActivity.next());
			}
			
			
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
		
		try {					
			if (!this.Connect()) return;			
			
			UserPhysicalActivity userPhysicalActivity = new UserPhysicalActivity(this.Connection, this.user.getId());
			userPhysicalActivity.findAll(100);
			
			int typePhyActivityId = this.getParamInt("typePhyActivityId");			
			TypePhyActivity typePhyActivity = new TypePhyActivity(this.Connection);
			
			if (!typePhyActivity.findId(typePhyActivityId)) {				
				this.dispathFileExercisesEdit();
				return;
			}
			
			
			double timeActivityMinute = this.getParamDoub("timeActivityMinute");			
			double valueCalorie = timeActivityMinute * typePhyActivity.row.getValueCalorie();
			
			userPhysicalActivity.append();
			userPhysicalActivity.row.setUserId(this.user.getId());
			userPhysicalActivity.row.setTypePhyActivityId(this.getParamInt("typePhyActivityId"));
			userPhysicalActivity.row.setTimeActivityMinute(this.getParamDoub("timeActivityMinute"));
			userPhysicalActivity.row.setValueCalorie(valueCalorie);
			
			if (!userPhysicalActivity.post()) {
				this.dispathExercisesEdit();
				return;
			}
			
			this.redirExercises();
		} catch(Exception e) {
			e.printStackTrace();
				
		} finally {
			this.Close();
		}
		
	}
}
