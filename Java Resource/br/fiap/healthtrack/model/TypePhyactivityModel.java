package br.fiap.healthtrack.model;

/*
 * 
 * USER_BLOODPRESSURE
 * USER_PHYSICALACTIVITY
 * USER_PROFILE
 * 
 */

import java.sql.ResultSet;
import java.sql.SQLException;

public class TypePhyactivityModel extends Commons {
	private String description;
	private double valueCalorie;
	
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
	}	
	
	public String getDescription() {
		return this.description;
	}

	protected void setDescription(String description) {
		this.description = description;
	}
	
	public double getValueCalorie() {
		return this.valueCalorie;
	}

	protected void setValueCalorie(double valueCalorie) {
		this.valueCalorie = valueCalorie;
	}
}

