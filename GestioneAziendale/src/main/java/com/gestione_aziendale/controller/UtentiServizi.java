package com.gestione_aziendale.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestione_aziendale.persistenza.DBManager;
import com.gestione_aziendale.persistenza.model.Utente;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin("http://localhost:4200")
public class UtentiServizi {
	public HttpSession session;
	public void setSession(HttpSession session) {
		this.session=session;
	}
	@PostMapping("/getUtente")
	public Utente getUtente(HttpServletRequest req ) {
		String [] sessionIdParam=req.getQueryString().split("&")[0].split("=");
		String sessionId=sessionIdParam[1];
		if(req.getServletContext().getAttribute(sessionId)!=null) {
			Utente u=(Utente) session.getAttribute("user");
			Utente utente=DBManager.getInstance().getUtenteDao().findByPrimaryKey(u.getEmail());
			return utente;
		}
		return null;
	}
	

}
