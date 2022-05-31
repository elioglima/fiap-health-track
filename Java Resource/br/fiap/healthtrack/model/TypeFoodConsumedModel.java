package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeFoodConsumedModel extends Commons {
	private String description;	
	private double valueCalorie;
	private double qtde;
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.description = result.getString("description");
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
		this.description = "";
		this.qtde = 0;
		this.valueCalorie = 0;
	}	
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getValueCalorie() {
		return this.valueCalorie;
	}

	public void setValueCalorie(double valueCalorie) {
		this.valueCalorie = valueCalorie;
	}

	public double getQtde() {
		return qtde;
	}

	public void setQtde(double qtde) {
		this.qtde = qtde;
	}
}