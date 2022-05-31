package br.fiap.healthtrack;

import br.fiap.healthtrack.db.*;

/* 
	TITLE: CLASSE PRESSÃO SANGUÍNEA
	DESCRIPTION: GERENCIAMENTO DE PRESSÃO SANGUÍNEA
*/


public class UserBloodPressure extends DbUserBloodPressure {
	public UserBloodPressure(ConnectionManager connectionManager, int userId) {		
		super(connectionManager);
		this.row.setUserId(userId);	
	}
}
