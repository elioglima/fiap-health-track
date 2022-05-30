package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.fiap.healthtrack.db.ConnectionManager;

/* 
	TITLE: CLASSE ATIVIDADE FISICA
	DESCRIPTION: GERENCIAMENTO DE ATIVIDADE FISICA
*/

public class UserPhysicalActivityModel extends Commons  {
	private int userId;
	private int typePhyActivityId;
	private double timeActivityMinute;
	private double valueCalorie;	
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.userId = result.getInt("user_id");
			this.typePhyActivityId = result.getInt("type_phyactivityid");
			this.timeActivityMinute = result.getDouble("time_activityminute");
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
		this.typePhyActivityId = 0;
		this.timeActivityMinute = 0;
		this.valueCalorie = 0;
		this.atCreate = null;
		this.atUpdate = null;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public int getTypePhyActivityId() {
		return this.typePhyActivityId;
	}

	public void setTypePhyActivityId(int typePhyActivityId) {
		this.typePhyActivityId = typePhyActivityId;
	}
	
	public double getTimeActivityMinute() {
		return this.timeActivityMinute;
	}

	public void setTimeActivityMinute(double timeActivityMinute) {
		this.timeActivityMinute = timeActivityMinute;
	}
	
	
	public double getValueCalorie() {
		return this.valueCalorie;
	}

	public void setValueCalorie(double valueCalorie) {
		this.valueCalorie = valueCalorie;
	}	
}
