package br.fiap.healthtrack.db;

import java.util.Date;
import br.fiap.healthtrack.model.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* 
	TITLE: CLASSE ATIVIDADE FISICA
	DESCRIPTION: GERENCIAMENTO DE ATIVIDADE FISICA
*/

public class DbUserPhysicalActivity extends InstanceManager implements IController {
	private String select = "select * from user_foodconsumed ";
	private String insert = "insert into user_foodconsumed ";
	private String update = "update user_foodconsumed set ";
	public UserPhysicalActivityModel row;
	
	public DbUserPhysicalActivity(ConnectionManager connectionManager) {
		this.setConnectionManager(connectionManager);
		this.row = new UserPhysicalActivityModel();
	}
	
	public void append() {		
		super.append();
		this.row.clear();
		
		Date now = new Date();	        
		java.sql.Date sqlDateNow = new java.sql.Date(now.getTime());
		this.row.setAtCreate(sqlDateNow);
		this.row.setAtUpdate(sqlDateNow);
	}
	
	public void edit() {
		super.edit();		
	}	
	
	public boolean post() {
		PreparedStatement pstmt = null;
		try {
			String sql = null;
			if (this.getDbState() == "insert") {
				sql = this.insert.concat(" (user_id, type_phyactivityid, time_activityminute, value_calorie, at_create, at_update)");
				sql = sql.concat(" values (?,?,?,?,?,?)");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setInt(1, this.row.getUserId());
				pstmt.setInt(2, this.row.getTypePhyActivityId());
				pstmt.setDouble(3, this.row.getTimeActivityMinute());
				pstmt.setDouble(4, this.row.getValueCalorie());
				pstmt.setDate(5, this.row.getAtUpdateSQLDate());
				pstmt.setDate(6, this.row.getAtCreateSQLDate());
				
			} else if (this.getDbState() == "edit") {								
				sql = this.update.concat(" type_phyactivityid = ?, time_activityminute = ?, value_calorie = ?, at_update = ?");
				sql = sql.concat(" where id = ? and user_id = ?");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setInt(1, this.row.getTypePhyActivityId());
				pstmt.setDouble(2, this.row.getTimeActivityMinute());
				pstmt.setDouble(3, this.row.getValueCalorie());				
				pstmt.setDate(4, this.row.getAtUpdateSQLDate());
				pstmt.setInt(5, this.row.getId());
				pstmt.setInt(6, this.row.getUserId());
			} else {
				return false;
			}
			
			if (pstmt.executeUpdate() == 0) return false;
			return true;												
			
		} catch (SQLException e) {
			return false; 		
		}
	}
	
	public boolean loadData() {
		if (!this.checkConnected()) return false;
		this.row.setResult(this.resultQuery);		
		return true;
	}

	public boolean next() {
		if (!super.nextResults()) return false;
		return this.loadData();	
	}	
	
	public boolean first() {
		super.firstResults();		
		return this.loadData();	
	}
	
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
