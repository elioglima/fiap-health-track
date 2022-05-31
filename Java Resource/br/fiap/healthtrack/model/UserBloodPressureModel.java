package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/* 
	TITLE: CLASSE PRESSÃO SANGUÍNEA
	DESCRIPTION: GERENCIAMENTO DE PRESSÃO SANGUÍNEA
*/

public class UserBloodPressureModel extends Commons  {
	private int userId;
	private int valueBeats;	
	private int valueMin;
	private int valueMax;
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("ID");
			this.userId = result.getInt("USER_ID");
			this.setValueBeats(result.getInt("VALUE_BEATS"));
			this.setValueMin(result.getInt("VALUE_MIN"));
			this.setValueMax(result.getInt("VALUE_MAX"));			
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
		this.setValueBeats(0);		
		this.setValueMin(0);
		this.setValueMax(0);
		this.atCreate = null;
		this.atUpdate = null;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getValueBeats() {
		return valueBeats;
	}

	public void setValueBeats(int valueBeats) {
		this.valueBeats = valueBeats;
	}

	public int getValueMax() {
		return valueMax;
	}

	public void setValueMax(int valueMax) {
		this.valueMax = valueMax;
	}

	public int getValueMin() {
		return valueMin;
	}

	public void setValueMin(int valueMin) {
		this.valueMin = valueMin;
	}
	
	
}
