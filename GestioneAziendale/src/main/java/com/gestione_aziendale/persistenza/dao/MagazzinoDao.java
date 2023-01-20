package com.gestione_aziendale.persistenza.dao;

import java.util.List;
import com.gestione_aziendale.persistenza.model.Magazzino;

public interface MagazzinoDao {
	
	public List<Magazzino> findAll();
	
	public Magazzino findByProduct(String id);
	
	public Magazzino findBySupplier(String id);
	
}
