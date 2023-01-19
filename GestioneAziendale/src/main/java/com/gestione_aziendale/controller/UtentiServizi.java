package com.gestione_aziendale.controller;

import java.util.List;

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
	@PostMapping("/getUtente")
	public Utente getUtente(HttpServletRequest req ) {
		String [] sessionIdParam=req.getQueryString().split("&")[0].split("=");
		String sessionId=sessionIdParam[1];
		//System.out.println(session.getId());
		if(req.getServletContext().getAttribute(sessionId)!=null) {
			Utente utente= DBManager.getInstance().getUtenteDao().findByPrimaryKey(HomeAziendaleServlet.s);
			//System.out.println(HomeAziendaleServlet.s);
			System.out.println(utente.getEmail());
			return utente;
		}
		return null;
		
	}
	@PostMapping("/getUtenti")
	public List<Utente> getUtenti(HttpServletRequest req ) {
			
			List<Utente> utenti=DBManager.getInstance().getUtenteDao().findAll();
			//System.out.println(HomeAziendaleServlet.s);
			return utenti;
		
	}
	
	

}
