package br.fiap.healthtrack.db;

import java.util.Date;
import br.fiap.healthtrack.model.UserModel;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* 
	TITLE: CLASSE USUARIOS
	DESCRIPTION: GERENCIAMENTO DE DADOS DO USUARIOS
*/

public abstract class DbUser extends InstanceManager implements IController {
	
	private String select = "select * from users ";
	private String insert = "insert into users ";
	private String update = "update users set ";	
	public UserModel row;	
	
	public DbUser(ConnectionManager connectionManager) {
		this.row =  new UserModel();			
		this.setConnectionManager(connectionManager);
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
		String sql = this.select;
		sql = sql.concat(" and rownum <= ").concat(String.valueOf(rowNum));
		sql = sql.concat(" order by id desc");
		this.clearSQL();
		this.addSQL(sql);		
		if (!this.executeSelect()) 
			return false;
		
		this.loadData();		
		return this.recordCount > 0; 		
	}
	
	public boolean FindMail(String mail) {		
		String sql = this.select.concat("where mail = ").concat("'"+ mail + "'");
		sql = sql.concat(" and rownum <= ").concat(String.valueOf(1));
		System.out.println(sql);
		this.clearSQL();
		this.addSQL(sql);
		if (!this.executeSelect()) 
			return false;		
		this.loadData();
		this.executeSelectClose();
		return this.recordCount > 0;		 		
	}
	
	public boolean FindId(int id) {		
		String sql = this.select.concat("where id = ").concat(Integer.toString(id));
		sql = sql.concat(" and rownum <= ").concat(String.valueOf(1));
		this.clearSQL();
		this.addSQL(sql);
		if (!this.executeSelect()) 
			return false;		
		this.loadData();
		this.executeSelectClose();
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
	
	public boolean post() {
		PreparedStatement pstmt;
		try {	
			String sql = null;
			if (this.getDbState() == "insert") {						
				sql = this.insert.concat(" (mail, name, password, at_create, at_update, active)");
				sql = sql.concat(" values (?,?,?,?,?,?)");
				System.out.println(this.row.getPassword());
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setString(1, this.row.getMail());
				pstmt.setString(2, this.row.getName());
				pstmt.setString(3, this.row.getPassword());
				pstmt.setDate(4, this.row.getAtUpdateSQLDate());
				pstmt.setDate(5, this.row.getAtCreateSQLDate());
				pstmt.setInt(6, 1);				
				
			} else if (this.getDbState() == "edit") {
				sql = this.update.concat(" mail = ?, name = ?, phone_mobile = ?, at_update = ?, active = ?");
				sql = sql.concat(" where id = ?");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setString(1, this.row.getMail());
				pstmt.setString(2, this.row.getName());
				pstmt.setString(3, this.row.getPhoneMobile());
				pstmt.setDate(4, this.row.getAtUpdateSQLDate());
				pstmt.setInt(5, this.row.getActive() ? 1 : 0);
				pstmt.setInt(6, this.row.getId());
			} else {
				return false;
			}
			if (pstmt.executeUpdate() == 0) return false;
			return true;						
		} catch (SQLException e) {
			return false; 		
		}	
	}		
}
