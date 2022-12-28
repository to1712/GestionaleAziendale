package com.gestione_aziendale.controller;

import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import com.gestione_aziendale.persistenza.DBManager;
import com.gestione_aziendale.persistenza.dao.UtenteDao;
import com.gestione_aziendale.persistenza.model.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/doLogin")
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		UtenteDao utenteDao = DBManager.getInstance().getUtenteDao();
		Utente utente = utenteDao.findByPrimaryKey(email);
		boolean login;
		if(utente == null)
			login = false;
		else
		{
			if (password.equals(utente.getPassword())) {
				login = true;
				HttpSession session = req.getSession();
				session.setAttribute("email", utente);
				session.setAttribute("sessionId", session.getId());
				
				req.getServletContext().setAttribute(session.getId(), session);
			}else {
				login = false;
			}
		}
		if (login) {
			resp.sendRedirect("/applicazioneAzienda/index.html");
		}else {
			resp.sendRedirect("/applicazioneAzienda/404.html");
		}
	}
}
