package pojo;

public class Filme {
	private String nome;
	private String genero;
	private String autor;

	public Filme(String nome, String genero, String autor){
		this.nome = nome;
		this.genero = genero;
		this.autor = autor;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}