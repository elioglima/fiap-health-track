package br.fiap.healthtrack.db;

import java.util.Date;
import br.fiap.healthtrack.model.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* 
	TITLE: CLASSE USUARIOS
	DESCRIPTION: GERENCIAMENTO DE DADOS DE NOTIFICACOES DA APLICACAO
*/

public class DbUserAlerts extends InstanceManager implements IController {
	private String select = "select * from user_alerts ";
	private String insert = "insert into user_alerts ";
	private String update = "update into user_alerts set ";
	protected UserAlertsModel row;
	
	public DbUserAlerts() {
		this.row = new UserAlertsModel();
	}
	
	public void append() {
		Date now = new Date();	        
		java.sql.Date sqlDateNow = new java.sql.Date(now.getTime());	
		super.append();		
		this.row.clear();
		this.row.setAtCreate(sqlDateNow);
		this.row.setAtUpdate(sqlDateNow);
	}
	
	public void edit() {
		super.edit(); 		
	}
	
	public boolean save() {
		PreparedStatement pstmt;
		try {
			String sql = null;
			if (this.getDbState() == "insert") {
				sql = this.insert.concat(" (user_id, healthbeats_max, healthbeats_min, at_create, at_update)");
				sql = sql.concat(" values (?,?,?,?,?)");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setInt(1, this.row.getUserId());
				pstmt.setDouble(2, this.row.getHealthBeatsMax());
				pstmt.setDouble(3, this.row.getHealthBeatsMin());
				pstmt.setDate(3, this.row.getAtUpdateSQLDate());
				pstmt.setDate(4, this.row.getAtCreateSQLDate());
				return pstmt.executeUpdate() > 0;
				
			} else if (this.getDbState() == "edit") {								
				sql = this.update.concat(" healthbeats_max = ?, healthbeats_min = ?, at_update = ?");
				sql = sql.concat(" where id = ? and user_id = ?");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setDouble(1, this.row.getHealthBeatsMax());
				pstmt.setDouble(2, this.row.getHealthBeatsMin());
				pstmt.setDate(3, this.row.getAtUpdateSQLDate());
				pstmt.setInt(4, this.row.getId());
				pstmt.setInt(5, this.row.getUserId());
				return pstmt.executeUpdate() > 0;				
			}
												
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; 		
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

	@Override
	public boolean findAll() {
		String sql = this.select.concat("where user_id = ").concat(String.valueOf(this.row.getUserId()));
		this.clearSQL();
		this.addSQL(sql);		
		if (!this.executeSelect()) 
			return false;
		
		this.loadData();
		return this.getRecordCount() > 0;
	}

}
