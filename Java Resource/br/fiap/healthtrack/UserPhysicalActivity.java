package br.fiap.healthtrack;

import br.fiap.healthtrack.db.*;

/* 
	TITLE: CLASSE ALIMENTOS CONSUMIDOS
	DESCRIPTION: GERENCIAMENTO DE ALIMENTOS CONSUMIDOS
*/

public class UserPhysicalActivity extends DbUserPhysicalActivity {
	
	public UserPhysicalActivity(ConnectionManager connectionManager, int userId) {
		super(connectionManager);
		this.row.setUserId(userId);		
	}
}
