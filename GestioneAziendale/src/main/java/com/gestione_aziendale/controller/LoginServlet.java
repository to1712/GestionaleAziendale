package com.gestione_aziendale.controller;

import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestione_aziendale.persistenza.DBManager;
import com.gestione_aziendale.persistenza.dao.UtenteDao;
import com.gestione_aziendale.persistenza.model.Utente;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class LoginServlet {
	@PostMapping("/doLogin")
	public void doLogin(HttpServletRequest req, HttpServletResponse resp, String email, String password) throws IOException, ServletException
	{
		UtenteDao udao = DBManager.getInstance().getUtenteDao();
		Utente utente = udao.findByPrimaryKey(email);
		
		boolean logged;
		if(utente == null)
			logged = false;
		else {
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
			resp.sendRedirect("/views");
		}else {
			resp.sendRedirect("/applicazioneAzienda/404.html");
		}
	}
}	
	



/*
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import com.gestione_aziendale.persistenza.DBManager;
import com.gestione_aziendale.persistenza.dao.UtenteDao;
import com.gestione_aziendale.persistenza.model.Utente;

@WebServlet(urlPatterns={"/applicazioneAzienda/doLogin","/doLogin"})
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
			resp.sendRedirect("/applicazioneAzienda");
		}else {
			resp.sendRedirect("/applicazioneAzienda/404.html");
		}
		
	}
}*/

