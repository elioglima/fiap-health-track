package br.fiap.healthtrack.servlets;

import java.util.regex.*;
import java.util.*;
import br.fiap.healthtrack.User;
import br.fiap.healthtrack.utils.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/profile/edit")
public class profileEditController extends RouterController {
	private static final long serialVersionUID = 1L;
	
	public profileEditController() {
		super();
	}	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;
		this.dispathProfileEdit();
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)  {
		this.loadHttp(request, response);
		if (!this.doVerify()) return;
		
		try {		
			if (!this.Connect()) return;
			System.out.println("iniciando post");
			
			User user = new User(this.Connection);			
			if (!user.FindId(this.user.id)) {				
				this.setError("Usuário não foi localizado");
				this.dispathProfileEdit();		
				return;
			}
			
			if (this.isNull(request.getParameter("name"))) {
				this.setError("Nome não foi informado!");
				this.dispathProfileEdit();		
				return;
			} else if (request.getParameter("name").trim().length() <= 5) {
				this.setError("O nome informado não é válido!");
				this.dispathProfileEdit();		
				return;
			} else if (this.isNull(request.getParameter("mail"))) {
				this.setError("Email não foi informado!");
				this.dispathProfileEdit();		
				return;
			} else if (!ToolsValidation.mailIsValide(request.getParameter("mail"))) {
				this.setError("E-mail informado não é válido!");
				this.dispathProfileEdit();		
				return;
			} else if (this.isNull(request.getParameter("phoneMobile"))) {
				this.setError("Telefone não foi informado!");
				this.dispathProfileEdit();		
				return; 
			} else if (!ToolsValidation.phoneMobileIsValide(request.getParameter("phoneMobile"))) {
				this.setError("E-mail informado não é válido!");
				this.dispathProfileEdit();		
				return;
			} else if (request.getParameter("phoneMobile").length() < 11) {
				this.setError("Telefone informado não é válido!");
				this.dispathProfileEdit();		
				return;
			} 
			
			user.edit();
			user.row.setMail((String) request.getParameter("mail"));
			user.row.setName((String) request.getParameter("name"));
			user.row.setPhoneMobile((String) request.getParameter("phoneMobile"));
			if (!user.post()) {
				this.setError("Não foi possível salvar os dados.");
				this.dispathProfileEdit();
				return;
			}
			
			if (!user.FindId(this.user.id)) {				
				this.setError("Usuário não foi localizado");
				this.dispathProfileEdit();		
				return;
			}			
			
			this.setMessage("Dados salvos com sucesso");
			this.setSession("user", user.row);
			this.redirHome();
		} finally {
			this.Close();
		}
	}

	
	
}
