package br.fiap.healthtrack.db;

import java.util.Date;
import br.fiap.healthtrack.model.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* 
	TITLE: CLASSE LANGUAGES
	DESCRIPTION: GERENCIAMENTO DE DADOS DE NOTIFICACOES DA APLICACAO
*/


public class DbLanguages extends InstanceManager implements IController {
	private String select = "select * from languages ";
	private String insert = "insert into languages ";
	private String update = "update into languages set";	
	protected LanguagesModel row;	
	
	public DbLanguages() {
		this.row = new LanguagesModel();
	}
	
	public boolean findAll() {
		String sql = this.select;		
		this.clearSQL();
		this.addSQL(sql);		
		if (!this.executeSelect()) 
			return false;
		
		this.loadData();
		return this.getRecordCount() > 0;
	}
	
	
	@Override
	public void append() {
		super.append();
		this.row.clear();
		
		Date now = new Date();	        
		java.sql.Date sqlDateNow = new java.sql.Date(now.getTime());
		this.row.setAtCreate(sqlDateNow);
		this.row.setAtUpdate(sqlDateNow);
	}

	@Override
	public void edit() {
		super.edit();
		
	}

	@Override
	public boolean loadData() {
		if (!this.checkConnected()) return false;
		this.row.setResult(this.resultQuery);		
		return true;		
	}

	@Override
	public boolean next() {
		if (!super.nextResults()) return false;
		return this.loadData();
	}

	@Override
	public boolean first() {
		super.firstResults();		
		return this.loadData();	
	}
	
	public boolean save() {
		PreparedStatement pstmt;
		try {			
			String sql = null;
			if (this.getDbState() == "insert") {
				sql = this.insert.concat(" (description, at_create, at_update)");
				sql = sql.concat(" values (?,?,?)");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setString(1, this.row.getDescription());
				pstmt.setDate(2, this.row.getAtCreateSQLDate());
				pstmt.setDate(3, this.row.getAtUpdateSQLDate());
				return pstmt.executeUpdate() > 0;
				
			} else if (this.getDbState() == "edit") { 				
				sql = this.update.concat(" description = ?, at_update = ? ");
				sql = sql.concat(" where id = ?");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setString(1, this.row.getDescription());
				pstmt.setDate(2, this.row.getAtUpdateSQLDate());
				pstmt.setInt(3, this.row.getId());
				return pstmt.executeUpdate() > 0;				
			}
												
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false; 		
	}
}
