package br.fiap.healthtrack.servlets;

import java.io.IOException;
import br.fiap.healthtrack.User;
import br.fiap.healthtrack.model.UserModel;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class loginController extends RouterController  {
	private static final long serialVersionUID = 1L;
	
	public loginController() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		this.loadHttp(request, response);				
		this.dispathFileLogin();   
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession dataSesion = request.getSession();
		this.loadHttp(request, response);		
		
		try {					
			if (!this.Connect()) return;			
			User user = new User(this.Connection);
			
			String mail = (String) request.getParameter("mail");
			String password = (String) request.getParameter("password");
			
			// ACESSO AO SISTEMA
			if (!user.logIn(mail, password)) {
				System.err.println("Usuário não localizado. senha ou password errado");				
				dataSesion.setAttribute("isLogged", false);
				return;
			} 
			
			System.out.println("");		
			System.out.println("Usuário logado");
			System.out.println("Nome :: ".concat(user.row.getName()));
			System.out.println("************************************************************************");
			System.out.println("");
			
			dataSesion.setAttribute("isLogged", true);
			dataSesion.setAttribute("user", (UserModel) user.row);			
			response.sendRedirect(request.getContextPath().concat("/home"));			
		} catch (IOException e) {
			dataSesion.setAttribute("isLogged", false);
			e.printStackTrace();
		} finally {
			this.Close();
		}

	}
	
}
