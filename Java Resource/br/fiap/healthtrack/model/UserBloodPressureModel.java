package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/* 
	TITLE: CLASSE PRESSÃO SANGUÍNEA
	DESCRIPTION: GERENCIAMENTO DE PRESSÃO SANGUÍNEA
*/

public class UserBloodPressureModel extends Commons  {
	private int userId;
	private double value;	
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.userId = result.getInt("user_id");
			this.value = result.getDouble("value");
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
		this.value = 0;		
		this.atCreate = null;
		this.atUpdate = null;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public Double getValue() {
		return this.value;
	}

	public void setValue(Double value) {
		this.value = value;
	}		
}