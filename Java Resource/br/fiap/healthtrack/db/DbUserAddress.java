package br.fiap.healthtrack.db;

import java.util.Date;
import br.fiap.healthtrack.model.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/* 
	TITLE: CLASSE USUARIOS
	DESCRIPTION: GERENCIAMENTO DE DADOS DE ENDERECOS DO USUARIO
*/

public class DbUserAddress extends InstanceManager implements IController {
	private String select = "select * from user_address ";
	private String insert = "insert into user_address ";
	private String update = "update user_address set";
	public UserAddressModel row;
	
	public DbUserAddress() {
		this.row = new UserAddressModel();
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
				sql = this.insert.concat(" (user_id, address, zip_code, ADDRESS_NR, district, city, state, unit, complement, at_create, at_update)");
				sql = sql.concat(" values (?,?,?,?,?,?,?,?,?,?,?)");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setInt(1, this.row.getUserId());
				pstmt.setString(2, this.row.getAddress());
				pstmt.setString(3, this.row.getZipCode());
				pstmt.setInt(4, this.row.getNumber());
				pstmt.setString(5, this.row.getDistrict());
				pstmt.setString(6, this.row.getCity());
				pstmt.setString(7, this.row.getState());
				pstmt.setString(8, this.row.getUnit());
				pstmt.setString(9, this.row.getComplement());
				pstmt.setDate(10, this.row.getAtCreateSQLDate());
				pstmt.setDate(11, this.row.getAtUpdateSQLDate());
				return pstmt.executeUpdate() > 0;
				
			} else if (this.getDbState() == "edit") {
				sql = this.update.concat(" address = ?, zip_code = ?, ADDRESS_NR = ?, district = ?, city = ?, state = ?, unit = ?, complement = ?, at_update = ?");
				sql = sql.concat(" where id = ? and user_id = ?");
				
				pstmt = this.connectionManager.getInstance().prepareStatement(sql);
				pstmt.setString(1, this.row.getAddress());
				pstmt.setString(2, this.row.getZipCode());
				pstmt.setInt(3, this.row.getNumber());
				pstmt.setString(4, this.row.getDistrict());
				pstmt.setString(5, this.row.getCity());
				pstmt.setString(6, this.row.getState());
				pstmt.setString(7, this.row.getUnit());
				pstmt.setString(8, this.row.getComplement());
				pstmt.setDate(9, this.row.getAtUpdateSQLDate());				
				pstmt.setInt(10, this.row.getId());
				pstmt.setInt(11, this.row.getUserId());
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
