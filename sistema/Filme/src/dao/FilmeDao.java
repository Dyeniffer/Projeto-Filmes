package dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import pojo.Filme;

public class FilmeDao {
	private Connection db;
	private Statement statement;
	private ResultSet rs;
	private PreparedStatement st;

	public void conecta() throws Exception {
		Class.forName("org.sqlite.JDBC");
		db = DriverManager.getConnection("jdbc:sqlite:filmes.db");
		statement = db.createStatement();
		db.setAutoCommit(false);
		db.setAutoCommit(true);

	}

	public void desconecta() {
		try {
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertFilme(Filme filme) {
		String cmd = "INSERT INTO filmes (nome, genero, diretor, qualidade) VALUES (?, ?, ?,?)";

		db = null;
		st = null;

		try {
			conecta();

			st = db.prepareStatement(cmd);
			st.setString(1, filme.getNome());
			st.setString(3, filme.getGenero());
			st.setString(2, filme.getDiretor());
			st.setInt(4, filme.getQualidade());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Filme!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		desconecta();
	}
	
	public void RemoveFilmePorNome(String nome) {
		String cmd = "DELETE FROM filmes where nome like ?";

		db = null;
		st = null;

		try {
			conecta();

			st = db.prepareStatement(cmd);
			st.setString(1, nome);
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao excluir Filme!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		desconecta();
	}

	public List<Filme> listarFilmes(int ordem) {

		List<Filme> lista = new ArrayList<Filme>();
		String cmd = "";

		switch(ordem){
			case 0: cmd = "SELECT * FROM filmes ORDER BY diretor"; break;
				
			case 1: cmd = "SELECT * FROM filmes ORDER BY genero"; break;
				
			case 2: cmd = "SELECT * FROM filmes ORDER BY nome"; break;
				
			case 3: cmd = "SELECT * FROM filmes ORDER BY qualidade"; break;
		}

		db = null;
		st = null;
		rs = null;

		try {
			conecta();
			st = db.prepareStatement(cmd);
			rs = st.executeQuery();

			while (rs.next()) {
				// copiar dados para POJO
				String nome = rs.getString(2);
				String genero = rs.getString(3);
				String diretor = rs.getString(4);
				int qualidade = rs.getInt(5);
				lista.add(new Filme(nome, genero, diretor, qualidade));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				desconecta();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
	
	public List<Filme> listarFilmes() {

		List<Filme> lista = new ArrayList<Filme>();
		String cmd = "SELECT * FROM filmes";
		

		db = null;
		st = null;
		rs = null;

		try {
			conecta();
			st = db.prepareStatement(cmd);
			rs = st.executeQuery();

			while (rs.next()) {
				// copiar dados para POJO
				String nome = rs.getString(2);
				String genero = rs.getString(3);
				String diretor = rs.getString(4);
				int qualidade = rs.getInt(5);
				lista.add(new Filme(nome, genero, diretor, qualidade));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				desconecta();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
	
}