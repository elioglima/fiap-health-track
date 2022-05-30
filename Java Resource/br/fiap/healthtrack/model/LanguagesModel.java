package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguagesModel extends Commons {
	private String description;
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.description = result.getString("description");
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
}