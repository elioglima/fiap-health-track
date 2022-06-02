package br.fiap.healthtrack.servlets;

import java.util.ArrayList;
import br.fiap.healthtrack.TypeFoodConsumed;
import br.fiap.healthtrack.UserFoodConsumed;
import br.fiap.healthtrack.model.TypeFoodConsumedModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/food")
public class foodController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public foodController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;		
		
		try {					
			if (!this.Connect()) return;			
			UserFoodConsumed userFoodConsumed = new UserFoodConsumed(this.Connection, this.user.getId());
			TypeFoodConsumed typeFoodConsumed = new TypeFoodConsumed(this.Connection);
			userFoodConsumed.findAll(20);
			this.setSession("userFoodConsumed", userFoodConsumed.row);
			
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
			this.dispathFileFood();		
		} finally {
			this.Close();
		}
	}
}
