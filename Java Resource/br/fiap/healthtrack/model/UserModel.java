package br.fiap.healthtrack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.fiap.healthtrack.utils.ToolsDate;
import jakarta.servlet.http.HttpServletRequest;

public class UserModel extends Commons {
	private String name;
	private String mail;
	private String password;
	private String phoneMobile;
	private Date birthDate;
	private boolean verifyMail;
	private boolean active;
	
	
	public boolean setResult(ResultSet result) {
		try {
			this.id = result.getInt("id");
			this.mail = result.getString("mail");
			this.name = result.getString("name");
			this.phoneMobile = result.getString("phone_mobile");
			this.birthDate = result.getDate("birth_date");
			this.password = result.getString("password");
			this.verifyMail = result.getInt("verify_mail") == 1;
			this.active = result.getInt("active") == 1;
			this.atCreate = result.getDate("at_create");
			this.atUpdate = result.getDate("at_update");
			System.out.println("aqui");
			System.out.println(this);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean load(UserModel result) {
		if (result == null) return false;
		this.id = result.id;
		this.mail = result.mail;
		this.name = result.name;
		this.phoneMobile = result.phoneMobile;
		this.birthDate = result.birthDate;
		this.verifyMail = result.verifyMail;
		this.active = result.active;
		this.atCreate = result.atCreate;
		this.atUpdate = result.atUpdate;
		return true;
	}
	
	public void loadRequestParams(HttpServletRequest request) {
		this.mail = request.getParameter("mail");
		this.name = request.getParameter("name");
		this.phoneMobile = request.getParameter("phone_mobile");
	}
	
	public void clear() {
		this.name = "";
		this.mail = "";
		this.phoneMobile = "";
		this.birthDate = null;
		this.active = true;
		this.verifyMail = false;
	}	
	
	public void setName(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}

	public void setName(String nome) {
		this.name = nome;
	}
	
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhoneMobile() {
		return this.phoneMobile;
	}

	public void setPhoneMobile(String phoneMobile) {
		this.phoneMobile= phoneMobile;
	}
	
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public boolean getVerifyMail() {
		return this.verifyMail;
	}

	public void setVerifyMail(boolean verifyMail) {
		this.verifyMail = verifyMail;
	}
	
	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Date getAtCreate() {
		return this.atCreate;
	}
	
	public Date getAtUpdate() {
		return this.atUpdate;
	}		

	public void setActive(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public java.sql.Date getBirthDateSQLDate() {
		return ToolsDate.DateToSQLDate(this.birthDate);
	}
	
	

	
}
