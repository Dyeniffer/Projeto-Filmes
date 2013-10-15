package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import pojo.Filme;

public class FilmeDao {

	public void insertFilme(Filme filme) {
		String cmd = "INSERT INTO filme (nome, genero, autor) VALUES (?, ?, ?)";

		Connection db = null;
		PreparedStatement st = null;

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("Filme.properties"));
			String url = prop.getProperty("url");

			db = DriverManager.getConnection(url, prop);

			st = db.prepareStatement(cmd);
			st.setString(1, filme.getNome());
			st.setString(2, filme.getGenero());
			st.setString(3, filme.getAutor());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Filme!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public Filme findFilmeByNome(String nome) {
		Filme filme = null;
		String cmd = "select * from filme where nome like ?";

		Connection db = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("filme.properties"));
			String url = prop.getProperty("url");

			db = DriverManager.getConnection(url, prop);

			st = db.prepareStatement(cmd);
			st.setString(1, nome);
			rs = st.executeQuery();

			while (rs.next()) {
				// copiar dados para POJO
				String nomeBD = rs.getString("nome");
				String genero = rs.getString(3);
				String autor = rs.getString(4);
				filme = new Filme(nomeBD, genero, autor);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (db != null) {
					db.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return filme;
	}
}