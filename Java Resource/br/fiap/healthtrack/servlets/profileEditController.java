package br.fiap.healthtrack.servlets;

import br.fiap.healthtrack.User;
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
