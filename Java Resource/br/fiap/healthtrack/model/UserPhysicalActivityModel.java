package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

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
			this.id = result.getInt("ID");
			this.userId = result.getInt("USER_ID");
			this.typePhyActivityId = result.getInt("TYPE_PHYACTIVITYID");
			this.timeActivityMinute = result.getDouble("TIME_ACTIVITYMINUTE");
			this.valueCalorie = result.getDouble("VALUE_CALORIE");
			this.atCreate = result.getDate("AT_CREATE");
			this.atUpdate = result.getDate("AT_UPDATE");
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
