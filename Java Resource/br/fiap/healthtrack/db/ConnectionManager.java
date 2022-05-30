package br.fiap.healthtrack.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager  {
	protected boolean isConnected;
	private Connection instance;
	private String url;
	private String userName;
	private String password;
	
	public ConnectionManager()  {		
		this.url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		this.userName = "rm92270";
		this.password = "041179";
	}
	
	public boolean Connect() {		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		
		try {
			// VERIFICAR POSSIBILIDADE DE FAZER POOL CONNECTION							
			java.sql.Connection cnx = DriverManager.getConnection(this.url, this.userName, this.password);
			this.instance = cnx;
			this.isConnected = true;						
			return true;
		} catch (SQLException c) {
			System.err.println("Não foi possível conectar.");
			return false;
		}		
	}

	
	public boolean checkConnected() {		 
		try {
			if (this.instance == null) {
				return this.Connect();
			} else if (this.instance.isClosed()) {
				return this.Connect();				
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return this.Connect();
		}
		return this.isConnected;
	}
	
	public Connection getInstance() {
		if (!checkConnected()) {
			this.Connect();
			if (!checkConnected()) 
				return null; 
		}
		return this.instance;
	}
	
	public void Close() {
		try {
			if (this.instance != null) {
				this.instance.close();				
			}
			
			this.isConnected = false;
		} catch (SQLException e) {
			this.isConnected = false;						
		}
	}
	
}
