package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAlertsModel extends Commons  {
	private int userId;
	private double healthBeatsMax;
	private double healthBeatsMin;
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.userId = result.getInt("user_id");
			this.healthBeatsMax = result.getDouble("healthbeats_max");
			this.healthBeatsMin = result.getDouble("healthbeats_min");
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
		this.healthBeatsMax = 0;
		this.healthBeatsMin = 0;
		this.atCreate = null;
		this.atUpdate = null;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Double getHealthBeatsMax() {
		return this.healthBeatsMax;
	}

	public void setHealthBeatsMax(Double healthBeatsMax) {
		this.healthBeatsMax = healthBeatsMax;
	}
	
	public Double getHealthBeatsMin() {
		return this.healthBeatsMin;
	}

	public void setHealthBeatsMin(Double healthBeatsMin) {
		this.healthBeatsMin = healthBeatsMin;
	}		
}
