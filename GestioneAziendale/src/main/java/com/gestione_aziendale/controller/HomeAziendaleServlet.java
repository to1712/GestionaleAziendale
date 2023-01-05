package com.gestione_aziendale.controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/views")
public class HomeAziendaleServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		System.out.println(session.getId());

		resp.sendRedirect("/views/home.html");
	}
	/*
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
		resp.sendRedirect("/home");
		return ruolo;
	}*/
}