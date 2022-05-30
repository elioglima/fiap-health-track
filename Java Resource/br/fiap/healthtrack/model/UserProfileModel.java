package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/* 
	TITLE: CLASSE PERFIL DO USUARIO
	DESCRIPTION: GERENCIAMENTO DE PERFIL DO USUARIO
*/

public class UserProfileModel extends Commons  {
	private int userId;
	private int languagesId;
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.userId = result.getInt("user_id");
			this.languagesId = result.getInt("languages_id");
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
		this.languagesId = 0;
		this.atCreate = null;
		this.atUpdate = null;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public int getLanguagesId() {
		return this.languagesId;
	}

	public void setLanguagesId(int languagesId) {
		this.languagesId = languagesId;
	}		
}
