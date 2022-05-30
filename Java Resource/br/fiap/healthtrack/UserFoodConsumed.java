package br.fiap.healthtrack;

import br.fiap.healthtrack.db.*;

/* 
	TITLE: CLASSE ALIMENTOS CONSUMIDOS
	DESCRIPTION: GERENCIAMENTO DE ALIMENTOS CONSUMIDOS
*/

public class UserFoodConsumed extends DbUserFoodConsumed {
	
	public UserFoodConsumed(int userId) {		
		this.row.setUserId(userId);
		this.findAll();
	}
}
