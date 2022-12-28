package com.gestione_aziendale.persistenza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gestione_aziendale.persistenza.dao.UtenteDao;
import com.gestione_aziendale.persistenza.dao.postgres.UtenteDaoPostgres;

public class DBManager {
	private static DBManager instance = null;
	Connection conn;
	
	private DBManager() {}
	
	public static DBManager getInstance() {
		if(instance == null)
			instance = new DBManager();
		return instance;
	}
	
	public Connection getConnession()
	{
		if(conn == null)
			try {
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/", "postgres", "07092000");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return conn;
	}
	
	public UtenteDao getUtenteDao() {
		return new UtenteDaoPostgres(getConnession());
	}
	
}
