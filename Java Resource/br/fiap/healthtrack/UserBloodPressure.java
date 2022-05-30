package br.fiap.healthtrack;

import br.fiap.healthtrack.db.*;

/* 
	TITLE: CLASSE PRESSÃO SANGUÍNEA
	DESCRIPTION: GERENCIAMENTO DE PRESSÃO SANGUÍNEA
*/


public class UserBloodPressure extends DbUserBloodPressure {
	
	public UserBloodPressure(int userId) {
		
		this.row.setUserId(userId);
		this.findAll();
	}
}
