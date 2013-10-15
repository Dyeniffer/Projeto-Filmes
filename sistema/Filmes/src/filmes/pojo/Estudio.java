package filmes.pojo;

public class Estudio {

	private String nome;
	private int qualidade;

	public Estudio(String nome, int qualidade) {
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
