package filmes.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import filmes.pojo.Ator;
import filmes.pojo.Diretor;
import filmes.pojo.Estudio;
import filmes.pojo.Filme;
import filmes.pojo.Genero;



public class DiretorDAO {

	public void insertDiretor(Diretor diretor) {
		String cmd = "INSERT INTO diretor (`nome`,`qualidade`) VALUES (?, ?)";

		Connection db = null;
		PreparedStatement st = null;

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("Diretor.properties"));
			String url = prop.getProperty("url");

			db = DriverManager.getConnection(url, prop);

			st = db.prepareStatement(cmd);
			st.setString(1, diretor.getNome());
			st.setInt(2, diretor.getQualidade());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Diretor");
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

	public Diretor findDiretorByNome(String nome) {
		Diretor diretor = null;
		String cmd = "SELECT * FROM diretor WHERE nome LIKE ?";

		Connection db = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("Movie.properties"));
			String url = prop.getProperty("url");

			db = DriverManager.getConnection(url, prop);

			st = db.prepareStatement(cmd);
			st.setString(1, nome);
			rs = st.executeQuery();

			while (rs.next()) {
				// copiar dados para POJO
				String nomeBD = rs.getString("nome");
				int qualidade = rs.getInt(2);
				diretor = new Diretor(nomeBD,qualidade);
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
		return diretor;
	}
	  public void excluirDiretor(long Id) throws ClassNotFoundException, SQLException{
		  Connection db = null;
			PreparedStatement stmt = null;
	        String sql = "DELETE FROM Pessoa WHERE id=?";
	        PreparedStatement st = db.prepareStatement(sql);
	        stmt.setLong(1,Id);
	        stmt.executeQuery();
	        db.close();
	    }
	  public void pesquisarDiretor(String Diretor) throws ClassNotFoundException, SQLException{
		  Connection db = null;
		  PreparedStatement stmt = null;
	        String sql = "SELECT * FROM Diretor WHERE nome like %?%";
	        PreparedStatement st = db.prepareStatement(sql);
	        stmt.setString(1,"nome");
	        stmt.executeQuery();
	        db.close();
	    }
}
