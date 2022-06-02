package br.fiap.healthtrack.db;

import java.util.Date;
import br.fiap.healthtrack.model.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* 
	TITLE: CLASSE PRESSÃO SANGUÍNEA
	DESCRIPTION: GERENCIAMENTO DE PRESSÃO SANGUÍNEA
*/

public class DbUserBloodPressure extends InstanceManager implements IController {
	private String select = "select * from USER_BLOODPRESSURE ";
	private String insert = "insert into USER_BLOODPRESSURE ";
	private String update = "update USER_BLOODPRESSURE set ";
	public UserBloodPressureModel row;
	
	public DbUserBloodPressure(ConnectionManager connectionManager) {
		this.setConnectionManager(connectionManager);
		this.row = new UserBloodPressureModel();
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
	
	public boolean post() {
		PreparedStatement pstmt;
		try {
			String sql = null;
			if (this.getDbState() == "insert") {
				sql = this.insert.concat(" (USER_ID, VALUE_BEATS, VALUE_MIN, VALUE_MAX, AT_CREATE, AT_UPDATE)");
				sql = sql.concat(" values (?,?,?,?,?,?)");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setInt(1, this.row.getUserId());
				pstmt.setInt(2, this.row.getValueBeats());				
				pstmt.setInt(3, this.row.getValueMin());
				pstmt.setInt(4, this.row.getValueMax());
				pstmt.setDate(5, this.row.getAtUpdateSQLDate());
				pstmt.setDate(6, this.row.getAtCreateSQLDate());
			} else if (this.getDbState() == "edit") {								
				sql = this.update.concat(" VALUE_BEATS = ?, VALUE_MIN = ?, VALUE_MAX = ?, AT_UPDATE = ?");
				sql = sql.concat(" where id = ? and USER_ID = ?");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setInt(1, this.row.getValueBeats());				
				pstmt.setInt(2, this.row.getValueMin());
				pstmt.setInt(3, this.row.getValueMax());				
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

	public boolean findAll(int rowNum) {
		String sql = this.select.concat("where user_id = ").concat(String.valueOf(this.row.getUserId()));
		sql = sql.concat(" and rownum <= ").concat(String.valueOf(rowNum));
		sql = sql.concat(" order by id desc");
		this.clearSQL();
		this.addSQL(sql);		
		if (!this.executeSelect()) 
			return false;
		
		this.loadData();
		return this.getRecordCount() > 0;
	}

}
