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
	private double timeActivityMinute;
	
	public boolean setResult(ResultSet result) {
		try {
			if (result == null) return false;
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

	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getValueCalorie() {
		return this.valueCalorie;
	}

	public void setValueCalorie(double valueCalorie) {
		this.valueCalorie = valueCalorie;
	}

	public double getTimeActivityMinute() {
		return timeActivityMinute;
	}

	public void setTimeActivityMinute(double timeActivityMinute) {
		this.timeActivityMinute = timeActivityMinute;
	}
}

