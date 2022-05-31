package br.fiap.healthtrack.servlets;

import java.io.IOException;
import br.fiap.healthtrack.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/measurememts/edit")
public class measurememtsEditController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public measurememtsEditController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;
		
		try {					
			if (!this.Connect()) return;
			UserBloodPressure userBloodPressure = new UserBloodPressure(this.Connection, this.user.getId());
			userBloodPressure.findAll();			
			this.setSession("userBloodPressure", userBloodPressure.row);
			this.dispathFileMeasurememtsEdit();		
		} finally {
			this.Close();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;
		
		try {					
			if (!this.Connect()) return;			
			
			UserBloodPressure userBloodPressure = new UserBloodPressure(this.Connection, this.user.getId());
			userBloodPressure.findAll();
			
			userBloodPressure.append();
			userBloodPressure.row.setUserId(this.user.getId());
			userBloodPressure.row.setValueBeats(this.getParamInt("valueBeats"));
			userBloodPressure.row.setValueMax(this.getParamInt("valueMax"));
			userBloodPressure.row.setValueMin(this.getParamInt("valueMin"));			
			
			if (!userBloodPressure.post()) {
				this.dispathMeasurememtsEdit();
				return;
			}
			
			this.dispathFileMeasurememts();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			this.Close();
		}
	}
}
