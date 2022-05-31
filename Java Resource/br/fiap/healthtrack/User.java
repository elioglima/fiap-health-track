package br.fiap.healthtrack;

import java.util.Base64;
import java.util.Date;

import br.fiap.healthtrack.db.ConnectionManager;
import br.fiap.healthtrack.db.DbUser;

/* 
	TITLE: CLASSE USUARIOS
	DESCRIPTION: GERENCIAMENTO DE USUARIOS
*/

public class User extends DbUser {
	private boolean isLogged;	
	public UserAddress address;
	public UserAlerts alerts;
	
	public User(ConnectionManager connectionManager) {
		super(connectionManager);
		this.isLogged = false;
	}
	
	private boolean load() {
		if (this.isLogged == false) return false;
//		this.address = new UserAddress(this.row.getId());		
//		this.alerts = new UserAlerts(this.row.getId());
		return true;
	}	
		
	public boolean logIn(String mail, String password) {
		System.out.println("user.logIn.");
		
		if (!this.FindMail(mail)) {
			this.isLogged = false;
			System.err.println("Usuario nao localizado.");
			return false;
		}
		
		this.isLogged = true;
		this.load();
		
		try {
			String passwordEncoded = Base64.getUrlEncoder().encodeToString(password.getBytes());
			System.err.println("CHECKED");
			System.err.println(this.row.getPassword());
			System.err.println(passwordEncoded);			
			return passwordEncoded.equals(this.row.getPassword());
		} catch (Exception e) {
			return false;
		}		
	}	
	
	
	public boolean register(String mail, String password, String name, String phoneMobile, Date birthDate) {
		// CADASTRAR USUARIO
		this.isLogged = false;
		
		this.append();
		this.row.setMail(mail);
		this.row.setPassword(password);
		this.row.setPhoneMobile(phoneMobile);
		this.row.setName(name);
		if (!this.post()) {			
			System.err.println("Falha ao cadastrar usuário.");
			return false; 
		}
		
		System.err.println("Usuario Logado.");
		return this.logIn(mail, password);
	}


	
	public void addressFindAll() {
		// PESQUISAR OS ENDERECOS
		this.address.row.setUserId(this.row.getId());
		this.address.findAll();
	}
	
	public void addAddress() {
		this.address.row.setUserId(this.row.getId());
		this.address.append();		
	}
	
	public void editAddress() {
		this.address.edit();		
	}

	public void saveAddress() {
		this.address.save();		
		
	}

	
}
