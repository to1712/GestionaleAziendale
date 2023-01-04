package com.gestione_aziendale.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gestione_aziendale.persistenza.model.Utente;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
public class HomeAziendaleServlet {
	
	@GetMapping("")
	public String home(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		HttpSession session = req.getSession();
		System.out.println(session.getId());
		Utente utente = (Utente) session.getAttribute("user");
		
		String ruolo = "Nessuno";
		System.out.println(utente.getRuolo());
		if(utente.getRuolo() == "bu")
			ruolo = "bu";
		else if(utente.getRuolo() == "lgs")
			ruolo ="it";
		else if(utente.getRuolo() == "mns")
			ruolo ="mns";
		resp.sendRedirect("home.html");
		return ruolo;
	}
}