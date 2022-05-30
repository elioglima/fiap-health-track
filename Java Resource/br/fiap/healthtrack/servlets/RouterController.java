package br.fiap.healthtrack.servlets;

import br.fiap.healthtrack.db.ConnectionManager;
import br.fiap.healthtrack.model.IRouterControler;
import br.fiap.healthtrack.model.UserModel;
import br.fiap.healthtrack.utils.SessionUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class RouterController extends ViewController implements IRouterControler {
	protected static final long serialVersionUID = 1L;
	protected ConnectionManager Connection;
	protected UserModel user;
	protected UserModel userDataForm;
	protected String nameRouteLocal;
	private String messageError;
	private String message;

	public RouterController() {
		super();
		this.Connection = new ConnectionManager();
		this.user = new UserModel();
		this.userDataForm = new UserModel();
	}

	public void destroy() {		
		this.Close();
		super.destroy();
	}

	protected boolean Connect() {
		if (!this.Connection.Connect()) {
			this.setSession("messageError", "Não foi possível estabelecer uma conexão com servidor de dados. Tente mais tarde.");
			this.redirFileOffline();			
			return false;
		}
		return true;
	}

	protected boolean Close() {
		this.Connection.Close();
		return true;
	}

	public void loadHttp(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public boolean getUser() {
		HttpSession dataSesion = this.request.getSession();
		return this.user.load((UserModel) dataSesion.getAttribute("user"));
	}

	public void setSession(String name, Object value) {
		HttpSession dataSesion = this.request.getSession();
		dataSesion.setAttribute(name, value);
		;
	}
	
	

	
	public boolean doVerify() {
		if (!SessionUtils.checked(this.request, this.response))
			return false;
		this.getUser();
		return true;
	}

	protected void setMessage(String message) {
		this.setSession("message", message);
		this.message = message;
	}

	protected String getMensage() {
		return this.message;
	}

	protected void setError(String messageError) {
		this.setSession("messageError", messageError);
		this.setMessageError(messageError);
	}

	protected String getMessageError() {
		return messageError;
	}

	protected void setMessageError(String messageError) {
		this.messageError = messageError;
	}
	
	public String getParameter(String name) {
		return this.request.getParameter(name);		
	}
	
	public int getParamInt(String name) {		
		return this.request.getParameter(name) != null ? Integer.parseInt(this.request.getParameter(name)) : null;		
	}
	
	public double getParamDoub(String name) {		
		return this.request.getParameter(name) != null ? Double.parseDouble(this.request.getParameter(name)) : null;		
	}
	
	public boolean getParamBoo(String name) {		
		return this.request.getParameter(name) != null ? Boolean.parseBoolean(this.request.getParameter(name)) : null;		
	}
	
	public String getParamStr(String name) {		
		return this.request.getParameter(name) != null ? this.request.getParameter(name) : null;		
	}

}
