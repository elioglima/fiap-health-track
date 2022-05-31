package br.fiap.healthtrack;

import br.fiap.healthtrack.db.*;

/* 
	TITLE: CLASSE ALIMENTOS CONSUMIDOS
	DESCRIPTION: GERENCIAMENTO DE ALIMENTOS CONSUMIDOS
*/

public class UserFoodConsumed extends DbUserFoodConsumed {
	public UserFoodConsumed(ConnectionManager connectionManager, int userId) {		
		super(connectionManager);
		this.row.setUserId(userId);	
	}
}
