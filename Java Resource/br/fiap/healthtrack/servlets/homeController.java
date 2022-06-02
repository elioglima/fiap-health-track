package br.fiap.healthtrack.servlets;

import java.util.ArrayList;

import br.fiap.healthtrack.TypeFoodConsumed;
import br.fiap.healthtrack.TypePhyActivity;
import br.fiap.healthtrack.UserBloodPressure;
import br.fiap.healthtrack.UserFoodConsumed;
import br.fiap.healthtrack.UserPhysicalActivity;
import br.fiap.healthtrack.model.TypeFoodConsumedModel;
import br.fiap.healthtrack.model.TypePhyactivityModel;
import br.fiap.healthtrack.model.UserBloodPressureModel;
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
		
		try {					
			if (!this.Connect()) return;			
			UserPhysicalActivity userPhysicalActivity = new UserPhysicalActivity(this.Connection, this.user.getId());
			TypePhyActivity typePhyActivity = new TypePhyActivity(this.Connection);
			userPhysicalActivity.findAll(4);			
			
			ArrayList<TypePhyactivityModel> listTypePhyActivity = new ArrayList<TypePhyactivityModel>();
			
			if (userPhysicalActivity.getRecordCount() > 0) {
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
			}
			
			
			
			this.setSession("listTypePhyActivity", listTypePhyActivity);
			
			
			// FOOD 			
			UserFoodConsumed userFoodConsumed = new UserFoodConsumed(this.Connection, this.user.getId());
			TypeFoodConsumed typeFoodConsumed = new TypeFoodConsumed(this.Connection);
			userFoodConsumed.findAll(4);
			
			ArrayList<TypeFoodConsumedModel> listTypeFoodConsumed = new ArrayList<TypeFoodConsumedModel>();
			
			if (userFoodConsumed.getRecordCount() > 0) {
				do {
					typeFoodConsumed.findId(userFoodConsumed.row.getTypeConsumedId());				
					TypeFoodConsumedModel t = new TypeFoodConsumedModel();
					t.setId(userFoodConsumed.row.getId());
					t.setDescription(typeFoodConsumed.row.getDescription());
					t.setQtde(userFoodConsumed.row.getQtde());				
					t.setValueCalorie(userFoodConsumed.row.getValueCalorie());
					t.setAtUpdate(userFoodConsumed.row.getAtUpdate());
					listTypeFoodConsumed.add(t);
				} while (userFoodConsumed.next());
			}
			
			this.setSession("listTypeFoodConsumed", listTypeFoodConsumed);
			
			
			// FOOD 			
			UserBloodPressure userBloodPressure = new UserBloodPressure(this.Connection, this.user.getId());
			userBloodPressure.findAll(4);
			ArrayList<UserBloodPressureModel> listUserBloodPressure = new ArrayList<UserBloodPressureModel>();
			
			if (userBloodPressure.getRecordCount() > 0) {				
				do {								
					UserBloodPressureModel t = new UserBloodPressureModel();
					t.setId(userBloodPressure.row.getId());
					t.setValueBeats(userBloodPressure.row.getValueBeats());
					t.setValueMax(userBloodPressure.row.getValueMax());
					t.setValueMin(userBloodPressure.row.getValueMin());
					t.setAtUpdate(userFoodConsumed.row.getAtUpdate());
					listUserBloodPressure.add(t);
				} while (userBloodPressure.next());
			}
			
			this.setSession("listUserBloodPressure", listUserBloodPressure);
			
			this.dispathFileHome();		
		} finally {
			this.Close();
		}
	}
	
	
}
