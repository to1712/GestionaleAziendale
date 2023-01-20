package com.gestione_aziendale.persistenza.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gestione_aziendale.persistenza.dao.MagazzinoDao;
import com.gestione_aziendale.persistenza.model.Magazzino;

public class MagazzinoDaoPostgres implements MagazzinoDao {
	Connection conn;
	
	public MagazzinoDaoPostgres(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Magazzino> findAll() {
		List<Magazzino> magazzini = new ArrayList<Magazzino>();
		String query = "SELECT * FROM magazzino;";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Magazzino magazzino = new Magazzino();
				magazzino.setId_prodotto(rs.getString("id_prodotto"));
				magazzino.setId_fornitore(rs.getString("id_fornitore"));
				
				magazzini.add(magazzino);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return magazzini;
	}

	@Override
	public Magazzino findByProduct(String id) {
		Magazzino magazzino = null;
		String query = "SELECT * FROM magazzino WHERE id_prodotto=?;";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
		
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				magazzino = new Magazzino();
				magazzino.setId_prodotto(rs.getString("id_prodotto"));
				magazzino.setId_fornitore(rs.getString("id_fornitore"));
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return magazzino;
	}

	@Override
	public Magazzino findBySupplier(String id) {
		Magazzino magazzino = null;
		String query = "SELECT * FROM magazzino WHERE id_fornitore=?;";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, id);
		
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				magazzino = new Magazzino();
				magazzino.setId_prodotto(rs.getString("id_prodotto"));
				magazzino.setId_fornitore(rs.getString("id_fornitore"));
			}
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return magazzino;
	}
}
