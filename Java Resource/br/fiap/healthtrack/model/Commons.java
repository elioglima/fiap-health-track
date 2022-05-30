package br.fiap.healthtrack.model;

import java.util.Date;

import br.fiap.healthtrack.utils.ToolsDate;

public class Commons {
	public int id;	
	public Date atCreate;
	public Date atUpdate;	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Date getAtCreate() {
		return this.atCreate;
	}
	
	public Date getAtUpdate() {
		return this.atUpdate;
	}

	public void setAtUpdate(Date atUpdate) {
		this.atUpdate = atUpdate;
	}	
	
	public void setAtCreate(Date atCreate) {
		this.atCreate = atCreate;
	}

	public java.sql.Date getAtUpdateSQLDate() {
		return ToolsDate.DateToSQLDate(this.atUpdate);
	}
	
	public java.sql.Date getAtCreateSQLDate() {
		return ToolsDate.DateToSQLDate(this.atCreate);
	}
}
