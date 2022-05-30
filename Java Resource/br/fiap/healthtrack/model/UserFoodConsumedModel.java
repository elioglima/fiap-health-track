package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/* 
	TITLE: CLASSE ALIMENTOS CONSUMIDOS
	DESCRIPTION: GERENCIAMENTO DE ALIMENTOS CONSUMIDOS
*/

public class UserFoodConsumedModel extends Commons  {
	private int userId;
	private int typeConsumedId;
	private int qtde;
	private double valueCalorie;
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.userId = result.getInt("user_id");
			this.typeConsumedId = result.getInt("type_foodconsumedId");
			this.qtde = result.getInt("qtde");
			this.valueCalorie = result.getDouble("value_calorie");
			this.atCreate = result.getDate("at_create");
			this.atUpdate = result.getDate("at_update");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void clear() {
		this.id = 0;
		this.userId = 0;
		this.typeConsumedId = 0;
		this.qtde = 0;
		this.valueCalorie = 0;
		this.atCreate = null;
		this.atUpdate = null;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getTypeConsumedId() {
		return this.typeConsumedId;
	}

	public void setTypeConsumedId(int typeConsumedId) {
		this.typeConsumedId = typeConsumedId;
	}
	
	public int getQtde() {
		return this.qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	
	public Double getValueCalorie() {
		return this.valueCalorie;
	}

	public void setValueCalorie(Double valueCalorie) {
		this.valueCalorie = valueCalorie;
	}		
}
