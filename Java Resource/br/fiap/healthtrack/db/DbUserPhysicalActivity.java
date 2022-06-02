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
	private String select = "select * from USER_PHYSICALACTIVITY ";
	private String insert = "insert into USER_PHYSICALACTIVITY ";
	private String update = "update USER_PHYSICALACTIVITY set ";
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
				sql = this.insert.concat(" (USER_ID, TYPE_PHYACTIVITYID, TIME_ACTIVITYMINUTE, VALUE_CALORIE, AT_CREATE, AT_UPDATE)");
				sql = sql.concat(" values (?,?,?,?,?,?)");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setInt(1, this.row.getUserId());
				pstmt.setInt(2, this.row.getTypePhyActivityId());
				pstmt.setDouble(3, this.row.getTimeActivityMinute());
				pstmt.setDouble(4, this.row.getValueCalorie());
				pstmt.setDate(5, this.row.getAtUpdateSQLDate());
				pstmt.setDate(6, this.row.getAtCreateSQLDate());
				
			} else if (this.getDbState() == "edit") {								
				sql = this.update.concat(" TYPE_PHYACTIVITYID = ?, TIME_ACTIVITYMINUTE = ?, VALUE_CALORIE = ?, AT_UPDATE = ?");
				sql = sql.concat(" where ID = ? and USER_ID = ?");
				
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
			e.printStackTrace();
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
	
	public boolean findAll(int rowNum) {
		
		String sql = this.select.concat("where user_id = ").concat(String.valueOf(this.row.getUserId()));
		sql = sql.concat(" and rownum <= ").concat(String.valueOf(rowNum));
		sql = sql.concat(" order by id desc");
		System.out.println(sql);
		
		this.clearSQL();
		this.addSQL(sql);		
		if (!this.executeSelect()) 
			return false;
		
		this.loadData();
		return this.getRecordCount() > 0;
	}

}
