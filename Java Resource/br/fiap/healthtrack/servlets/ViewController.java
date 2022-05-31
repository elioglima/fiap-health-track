package br.fiap.healthtrack.servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public HttpServletRequest request;
	public HttpServletResponse response;

	public boolean dispath(String Route) {
		RequestDispatcher rd = this.request.getRequestDispatcher(Route);
		try {
			rd.forward(this.request, this.response);
			return true;
		} catch (ServletException | IOException e) {
			return false;
		}	
	}
	
	public boolean redirect(String Route) {
		try {
			this.response.sendRedirect(this.request.getContextPath().concat(Route));
			return true;
		} catch (IOException e) {
			return false;
		}	
	}
	
	/* rotas */
	
	public void dispathFileLogin() {
		this.dispath("/login.jsp");
	}
	
	public void dispathLogin() {
		this.dispath("/login");
	}
	
	public void redirFileLogin() {
		this.redirect("/login.jsp");
	}
	
	public void redirLogin() {
		this.redirect("/login");
	}
	
	public void dispathFileHome() {
		this.dispath("/home.jsp");
	}
	
	public void dispathHome() {
		this.dispath("/home");
	}
	
	public void redirFileHome() {
		this.redirect("/home.jsp");
	}
	
	public void redirHome() {
		this.redirect("/home");
	}	
	
	public void dispathProfileEdit() {
		this.dispath("/profileEdit.jsp");
	}
	
	public void redirProfileEdit() {
		this.redirect("/profileEdit.jsp");
	}
	
	
	public void dispathFileExercisesEdit() {
		this.dispath("/exercisesEdit.jsp");
	}
	
	public void dispathExercisesEdit() {
		this.dispath("/exercisesEdit");
	}
	
	public void redirFileExercisesEdit() {
		this.redirect("/exercisesEdit.jsp");
	}
	
	public void redirExercisesEdit() {
		this.redirect("/exercisesEdit");
	}
	
	public void dispathFileExercises() {
		this.dispath("/exercises.jsp");
	}
	
	public void dispathExercises() {
		this.dispath("/exercises");
	}
	
	public void redirFileExercises() {
		this.redirect("/exercises.jsp");
	}
	
	public void redirExercises() {
		this.redirect("/exercises");
	}
	
	public void dispathFileFood() {
		this.dispath("/food.jsp");
	}
	
	public void dispathFood() {
		this.dispath("/food");
	}
	
	public void redirFileFood() {
		this.redirect("/food.jsp");
	}
	
	public void redirFood() {
		this.redirect("/food");
	}
	
	public void dispathFileOffline() {
		this.dispath("/offline.jsp");
	}
	
	// food edit
	
	public void dispathFileFoodEdit() {
		this.dispath("/foodEdit.jsp");
	}
	
	public void dispathFoodEdit() {
		this.dispath("/foodEdit");
	}
	
	public void redirFileFoodEdit() {
		this.redirect("/foodEdit.jsp");
	}
	
	public void redirFoodEdit() {
		this.redirect("/foodEdit");
	}
	
	// measurements
	
	public void dispathFileMeasurememts() {
		this.dispath("/measurements.jsp");
	}
	
	public void dispathMeasurememts() {
		this.dispath("/measurements");
	}
	
	public void redirFileMeasurememts() {
		this.redirect("/measurements.jsp");
	}
	
	public void redirMeasurememts() {
		this.redirect("/measurements");
	}
	
	// measurements edit
	
	public void dispathFileMeasurememtsEdit() {
		this.dispath("/measurementsEdit.jsp");
	}
	
	public void dispathMeasurememtsEdit() {
		this.dispath("/measurementsEdit");
	}
	
	public void redirFileMeasurememtsEdit() {
		this.redirect("/measurementsEdit.jsp");
	}
	
	public void redirMeasurememtsEdit() {
		this.redirect("/measurementsEdit");
	}

	
	// offline
	public void dispathOffline() {
		this.dispath("/offline");
	}
	
	public void redirFileOffline() {
		this.redirect("/offline.jsp");
	}
	
	public void redirOffline() {
		this.redirect("/offline");
	}
	
	// register
	
	public void dispathFileRegister() {
		this.dispath("/register.jsp");
	}
	
	public void dispathRegister() {
		this.dispath("/register");
	}
	
	public void redirFileRegister() {
		this.redirect("/register.jsp");
	}
	
	public void redirRegister() {
		this.redirect("/register");
	}
}
