package br.fiap.healthtrack.db;

import java.util.Date;
import br.fiap.healthtrack.model.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* 
	TITLE: CLASSE TIPO DE ATIVIDADE FISICA
	DESCRIPTION: GERENCIAMENTO DE DADOS DE TIPO DE ATIVIDADE FISICA
*/


public class DbTypePhyActivity extends InstanceManager implements IController {
	private String select = "select * from TYPE_PHYACTIVITY ";
	private String insert = "insert into TYPE_PHYACTIVITY ";
	private String update = "update TYPE_PHYACTIVITY set ";	
	public TypePhyactivityModel row;
	
	public DbTypePhyActivity(ConnectionManager connectionManager) {
		this.row = new TypePhyactivityModel();			
		this.setConnectionManager(connectionManager);
	}
	
	public boolean findAll(int rowNum) {
		String sql = this.select;
		sql = sql.concat(" where rownum <= ").concat(String.valueOf(rowNum));
		sql = sql.concat(" order by id desc");
		this.clearSQL();
		this.addSQL(sql);		
		if (!this.executeSelect()) 
			return false;
		
		this.loadData();		
		return this.recordCount > 0; 		
	}
	
	public boolean findId(int id) {
		String sql = this.select.concat("where id = ").concat(Integer.toString(id));
		sql = sql.concat(" and rownum <= ").concat(String.valueOf(1));
		this.clearSQL();
		this.addSQL(sql);		
		if (!this.executeSelect()) 
			return false;
		
		this.loadData();		
		return this.recordCount > 0;
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
	
	public boolean post() {
		PreparedStatement pstmt = null;
		try {			
			String sql = null;
			if (this.getDbState() == "insert") {
				sql = this.insert.concat(" (description, value_calorie, at_create, at_update)");
				sql = sql.concat(" values (?,?,?)");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setString(1, this.row.getDescription());
				pstmt.setDouble(2, this.row.getValueCalorie());
				pstmt.setDate(3, this.row.getAtCreateSQLDate());
				pstmt.setDate(4, this.row.getAtUpdateSQLDate());
				
			} else if (this.getDbState() == "edit") { 				
				sql = this.update.concat(" description = ?, value_calorie = ?, at_update = ? ");
				sql = sql.concat(" where id = ?");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setString(1, this.row.getDescription());
				pstmt.setDouble(2, this.row.getValueCalorie());
				pstmt.setDate(3, this.row.getAtUpdateSQLDate());
				pstmt.setInt(4, this.row.getId());
			}
												
			return pstmt.executeUpdate() > 0;				
		} catch (SQLException e) {
			return false;
		}
	}
}
