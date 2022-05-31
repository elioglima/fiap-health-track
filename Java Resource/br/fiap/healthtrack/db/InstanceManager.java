package br.fiap.healthtrack.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InstanceManager  {
	private String dbState;
	private String sql;
	protected ConnectionManager connectionManager;	
	protected int recordCount;
	protected ResultSet resultQuery;	
	protected boolean isConnected;
	protected Statement statement;
	
	public InstanceManager()  {
		this.sql = "";
	}
	
	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}
	
	public ConnectionManager getConnectionManager() {
		return this.connectionManager;
	}
	
	public boolean checkConnected() {
		return this.connectionManager.checkConnected();
	}
	
	protected void append() {
		this.setDbState("insert");		
	}
	
	protected void edit() {
		this.setDbState("edit");
	}
	
	public String asp(String value) {
		return "'"+ value + "'";		
	}
	
	public String clearSQL() {
		return this.sql = "";		
	}
	
	public String addSQL(String value) {
		return this.sql = this.sql + value;		
	}
	
	public boolean executeSelect() {		
		try {
			if (this.connectionManager.getInstance() == null) return false;
			statement = this.connectionManager.getInstance().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
		
				ResultSet result = statement.executeQuery(this.sql);
				result.last();
				this.recordCount = result.getRow();
				result.first();						
				this.resultQuery = result;
				return this.recordCount > 0;
	
		} catch (SQLException e) {
			this.resultQuery = null;
			this.recordCount = 0;
			return false; 		
		}		
	}	
	
	protected boolean executeSelectClose() {
		try {
			statement.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	public boolean firstResults() {		
		try {
			return this.resultQuery.first();
		} catch (SQLException e) {
			return false;
		}
	}	
	
	protected boolean nextResults() {
		try {
			if (this.isLastResults()) return false; 
			return this.resultQuery.next();
		} catch (SQLException e) {
			return false;
		}
	}
	
	protected boolean isLastResults() {
		try {
			return this.resultQuery.isLast();
		} catch (SQLException e) {
			return false;
		}
	}
	
	protected boolean previousResults() {
		try {
			return this.resultQuery.previous();
		} catch (SQLException e) {
			return false;
		}
	}

	public String getDbState() {
		return dbState;
	}

	public void setDbState(String dbState) {
		this.dbState = dbState;
	}
	
	public ResultSet getResultQuery() {
		return this.resultQuery;
	}
	
	public int getRecordCount() {
		return this.resultQuery == null ? 0 : this.recordCount;
	}
}
