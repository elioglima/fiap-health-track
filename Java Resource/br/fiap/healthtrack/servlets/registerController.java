package br.fiap.healthtrack.servlets;

import java.io.IOException;
import java.util.Base64;

import br.fiap.healthtrack.User;
import br.fiap.healthtrack.model.UserModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class registerController extends RouterController  {
	private static final long serialVersionUID = 1L;
	
	public registerController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);				
		this.dispathFileRegister();   
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);		
		
		try {					
			if (!this.Connect()) return;			
			User user = new User(this.Connection);
			
			String name = (String) request.getParameter("name");
			String mail = (String) request.getParameter("mail");
			String password = (String) request.getParameter("password");
			String passwordConfirm = (String) request.getParameter("passwordConfirm");
			
			System.out.println(password);
			System.out.println(passwordConfirm);
			if (!password.equals(passwordConfirm)) {
				this.setSession("messageError", "A confirmação de senha não confere.");
				this.dispathFileRegister();
				return;
			}		
			
			String passwordEncoded = Base64.getUrlEncoder().encodeToString(password.getBytes());
			
			user.append();
			user.row.setName(name);
			user.row.setMail(mail);
			user.row.setPassword(passwordEncoded);
			
			if (!user.post()) {
				this.setSession("messageError", "Não foi possível cadastrar o usuario.");
				this.dispathFileRegister();
				return;
			}		
			
			this.redirLogin();
		} finally {
			this.Close();
		}

	}
	
}
