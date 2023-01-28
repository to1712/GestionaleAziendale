package com.gestione_aziendale.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gestione_aziendale.persistenza.DBManager;
import com.gestione_aziendale.persistenza.model.Filiale;
import com.gestione_aziendale.persistenza.model.Fornitore;
import com.gestione_aziendale.persistenza.model.Magazzino;
import com.gestione_aziendale.persistenza.model.Prodotto;
import com.gestione_aziendale.persistenza.model.Spedizione;
import com.gestione_aziendale.persistenza.model.Utente;
import jakarta.servlet.http.HttpServletRequest;

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
	
	@PostMapping("/getFornitori")
	public List<Fornitore> getFornitori(HttpServletRequest req ) {
			
			List<Fornitore> fornitori = DBManager.getInstance().getFornitoreDao().findAll();
			//System.out.println(HomeAziendaleServlet.s);
			return fornitori;
		
	}
	
	@PostMapping("/getFiliali")
	public List<Filiale> getFiliali(HttpServletRequest req ) {
			
			List<Filiale> filiali = DBManager.getInstance().getFilialeDao().findAll();
			//System.out.println(HomeAziendaleServlet.s);
			return filiali;
	}
	
	@PostMapping("/getMagazzino")
	public List<Magazzino> getMagazzino(HttpServletRequest req ) {
			
			List<Magazzino> magazzino = DBManager.getInstance().getMagazzinoDao().findAll();
			//System.out.println(HomeAziendaleServlet.s);
			return magazzino;
	}
	
	@PostMapping("/getSpedizioni")
	public List<Spedizione> getSpedizione(HttpServletRequest req ) {
			
			List<Spedizione> spedizione = DBManager.getInstance().getSpedizioneDao().findAll();
			//System.out.println(HomeAziendaleServlet.s);
			return spedizione;
	}
	@PostMapping("/getProdotti")
	public List<Prodotto> getProdotto(HttpServletRequest req ) {
			
			List<Prodotto> prodotto = DBManager.getInstance().getProdottoDao().findAll();
			//System.out.println(HomeAziendaleServlet.s);
			return prodotto;
	}
	
	@PostMapping("/addSpedizione")
	public void setSpedizione(@RequestBody Spedizione spedizione ) {
		System.out.println(spedizione.getFiliale());

		 Spedizione s = new Spedizione(spedizione.getProdotto(),spedizione.getFornitore(),spedizione.getFiliale(),spedizione.getQta());

		 DBManager.getInstance().getSpedizioneDao().insert(s);
	}
	@PostMapping("/addProdotto")
	public void setProdotto(@RequestBody Magazzino magazzino) {
		 Magazzino m = new Magazzino(magazzino.getId_prodotto(),magazzino.getId_fornitore(),magazzino.getQta());
		 DBManager.getInstance().getMagazzinoDao().saveUpdate(m);
	}
}
