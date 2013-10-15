package filmes.teste;

import filmes.dao.MovieDAO;
import filmes.pojo.Ator;
import filmes.pojo.Diretor;
import filmes.pojo.Estudio;
import filmes.pojo.Filme;
import filmes.pojo.Genero;

public class Teste {

	public static void main(String[] args) {
		MovieDAO dao = new MovieDAO();
		Filme filme = new Filme("Teste de conexão", 240, 2013, 5);
		dao.insertFilme(filme);

//		Cliente cliente = new Cliente("Teste de conexão DAO", "5555-5555", "a@a.com", "lalalalala");
//		dao.insertCliente(cliente);
//
//		Profissional prof = new Profissional("Teste de conexão DAO", "5555-5555", "lalalalalala", "a@a.com", "00000000000");
//		dao.insertProfissional(prof);

//		Produto prod = new Produto(789, "texte de conexão DAO", 10, 15, 100, 30);
//		dao.insertProduto(prod);

	}
}