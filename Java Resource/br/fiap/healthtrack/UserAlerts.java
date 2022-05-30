package br.fiap.healthtrack;

import br.fiap.healthtrack.db.DbUserAlerts;

/* 
	TITLE: CLASSE USUARIOS
	DESCRIPTION: GERENCIAMENTO DE ENDEREÇOS DO USUARIO
*/


public class UserAlerts extends DbUserAlerts {
	
	public UserAlerts(int userId) {
		
		this.row.setUserId(userId);
		this.findAll();
	}
}
