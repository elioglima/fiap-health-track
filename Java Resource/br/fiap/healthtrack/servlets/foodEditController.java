package br.fiap.healthtrack.servlets;

import java.io.IOException;
import java.util.ArrayList;

import br.fiap.healthtrack.*;
import br.fiap.healthtrack.model.TypeFoodConsumedModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/food/edit")
public class foodEditController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public foodEditController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;
		
		try {					
			if (!this.Connect()) return;
			UserFoodConsumed userFoodConsumed = new UserFoodConsumed(this.Connection, this.user.getId());
			TypeFoodConsumed typeFoodConsumed = new TypeFoodConsumed(this.Connection);
			userFoodConsumed.findAll();
			this.setSession("userFoodConsumed", userFoodConsumed.row);
			
			typeFoodConsumed.findAll();			
			ArrayList<TypeFoodConsumedModel> listTypeFoodConsumed = new ArrayList<TypeFoodConsumedModel>();
			
			if (typeFoodConsumed.getRecordCount() > 0) {				
				do {			
					TypeFoodConsumedModel t = new TypeFoodConsumedModel();
					t.setResult(typeFoodConsumed.getResultQuery());
					listTypeFoodConsumed.add(t);				
				} while (typeFoodConsumed.next());
			}
			
			this.setSession("listTypeFoodConsumed", listTypeFoodConsumed);
			this.dispathFileFoodEdit();		
		} finally {
			this.Close();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;
		
		try {					
			if (!this.Connect()) return;			
			
			UserFoodConsumed userFoodConsumed = new UserFoodConsumed(this.Connection, this.user.getId());
			userFoodConsumed.findAll();
			
			int typeConsumedId = this.getParamInt("typeConsumedId");			
			TypeFoodConsumed typeFoodConsumed = new TypeFoodConsumed(this.Connection);
			
			if (!typeFoodConsumed.findId(typeConsumedId)) {				
				this.dispathFileFoodEdit();
				return;
			}
			
			int qtde = this.getParamInt("qtde");			
			double valueCalorie = qtde * typeFoodConsumed.row.getValueCalorie();
			
			userFoodConsumed.append();
			userFoodConsumed.row.setUserId(this.user.getId());
			userFoodConsumed.row.setTypeConsumedId(typeConsumedId);
			userFoodConsumed.row.setQtde(qtde);
			userFoodConsumed.row.setValueCalorie(valueCalorie);
			
			if (!userFoodConsumed.post()) {
				this.dispathFoodEdit();
				return;
			}
			
			this.dispathFileFood();
		} catch(Exception e) {
			e.printStackTrace();
				
		} finally {
			this.Close();
		}
	}
}
