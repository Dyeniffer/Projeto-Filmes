package pojo;

public class Filme {
	private String nome;
	private String genero;
	private String diretor;
	private int qualidade;

	public Filme(String nome, String genero, String diretor, int qualidade){
		this.nome = nome;
		this.genero = genero;
		this.diretor = diretor;
		this.qualidade = qualidade;
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

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public int getQualidade() {
		return qualidade;
	}

	public void setQualidade(int qualidade) {
		this.qualidade = qualidade;
	}


	@Override
	public String toString() {
		return "nome: " + nome + "\n genero: " + genero + "\n diretor: "
				+ diretor + "\n qualidade: " + qualidade;
	}

	
}