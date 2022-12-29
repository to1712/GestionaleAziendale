package com.gestione_aziendale.controller;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import com.gestione_aziendale.persistenza.DBManager;
import com.gestione_aziendale.persistenza.dao.UtenteDao;
import com.gestione_aziendale.persistenza.model.Utente;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			resp.sendRedirect("/index.html");
		}else {
			resp.sendRedirect("/applicazioneAzienda/404.html");
		}
	}
}
