package br.fiap.healthtrack;



import br.fiap.healthtrack.db.DbUserAddress;

/* 
	TITLE: CLASSE USUARIOS
	DESCRIPTION: GERENCIAMENTO DE ENDEREÇOS DO USUARIO
*/


public class UserAddress extends DbUserAddress {
	
	public UserAddress(int userId) {
		this.row.setUserId(userId);
		this.findAll();
	}
}
