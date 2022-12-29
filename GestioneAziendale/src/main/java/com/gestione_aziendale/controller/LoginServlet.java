package com.gestione_aziendale.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestione_aziendale.persistenza.DBManager;
import com.gestione_aziendale.persistenza.dao.UtenteDao;
import com.gestione_aziendale.persistenza.model.Utente;

@RestController
public class LoginServlet {
	@PostMapping("/applicazioneAzienda/doLogin")
	public String doLogin(HttpServletResponse resp,String email,String password) throws IOException
	{
		UtenteDao udao = DBManager.getInstance().getUtenteDao();
		Utente utente = udao.findByPrimaryKey(email);
		boolean logged;
		if (utente == null) {
			logged = false;
		}else {
			if (password.equals(utente.getPassword())) {
				logged = true;
				/*HttpSession session = req.getSession();
				session.setAttribute("user", utente);
				session.setAttribute("sessionId", session.getId());
				
				req.getServletContext().setAttribute(session.getId(), session);*/
			}else {
				logged = false;
			}
		}
		if (logged) {
			resp.sendRedirect("/applicazioneAzienda/index.html");
		}else {
			resp.sendRedirect("/applicazioneAzienda/404.html");
		}
		return null;
	}
}	
	



/*
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.gestione_aziendale.persistenza.DBManager;
import com.gestione_aziendale.persistenza.dao.UtenteDao;
import com.gestione_aziendale.persistenza.model.Utente;

@WebServlet("/applicazioneAzienda/doLogin")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UtenteDao udao = DBManager.getInstance().getUtenteDao();
		Utente utente = udao.findByPrimaryKey(email);
		boolean logged;
		if (utente == null) {
			logged = false;
		}else {
			if (password.equals(utente.getPassword())) {
				logged = true;
				HttpSession session = req.getSession();
				session.setAttribute("user", utente);
				session.setAttribute("sessionId", session.getId());
				
				req.getServletContext().setAttribute(session.getId(), session);
			}else {
				logged = false;
			}
		}
		if (logged) {
//			RequestDispatcher dispacher = req.getRequestDispatcher("views/index.html");
//			dispacher.forward(req, resp);
			resp.sendRedirect("/index.html");
		}else {
			resp.sendRedirect("/404.html");
		}
		
	}
}*/

