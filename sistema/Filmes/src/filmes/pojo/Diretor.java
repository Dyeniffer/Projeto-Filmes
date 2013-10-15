package filmes.pojo;

public class Diretor {

	private String nome;
	private int qualidade;

	public Diretor(String nome, int qualidade) {
		super();
		this.nome = nome;
		this.qualidade = qualidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQualidade() {
		return qualidade;
	}

	public void setQualidade(int qualidade) {
		this.qualidade = qualidade;
	}

}
