package filmes.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import filmes.pojo.Ator;
import filmes.pojo.Diretor;
import filmes.pojo.Estudio;
import filmes.pojo.Filme;
import filmes.pojo.Genero;



public class MovieDAO {

	public void insertFilme(Filme filme) {
		String cmd = "INSERT INTO filme (`nome`, `tempoDeDuracao`, `anoDeLancamento`, `qualidade`) VALUES (?, ?, ?, ?)";

		Connection db = null;
		PreparedStatement st = null;

		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("Movie.properties"));
			String url = prop.getProperty("url");

			db = DriverManager.getConnection(url, prop);

			st = db.prepareStatement(cmd);
			st.setString(1, filme.getNome());
			st.setInt(2, filme.getTempoDeDuracao());
			st.setInt(3, filme.getAnoDeLancamento());
			st.setInt(4, filme.getQualidade());
			int r = st.executeUpdate();

			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Filme");
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
		String cmd = "SELECT * FROM filme WHERE nome LIKE ?";

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
				int tempoDeDuracao = rs.getInt(3);
				int anoDeLancamento = rs.getInt(4);
				int qualidade = rs.getInt(5);
				filme = new Filme(nomeBD, tempoDeDuracao, anoDeLancamento,
						qualidade);
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
