package filmes.pojo;

public class Filme {
	private String nome;
	private int tempoDeDuracao;
	private int anoDeLancamento;
	private int qualidade;

	public Filme(String nome, int tempoDeDuracao, int anoDeLancamento,
			int qualidade) {
		super();
		this.nome = nome;
		this.tempoDeDuracao = tempoDeDuracao;
		this.anoDeLancamento = anoDeLancamento;
		this.qualidade = qualidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempoDeDuracao() {
		return tempoDeDuracao;
	}

	public void setTempoDeDuracao(int tempoDeDuracao) {
		this.tempoDeDuracao = tempoDeDuracao;
	}

	public int getAnoDeLancamento() {
		return anoDeLancamento;
	}

	public void setAnoDeLancamento(int anoDeLancamento) {
		this.anoDeLancamento = anoDeLancamento;
	}

	public int getQualidade() {
		return qualidade;
	}

	public void setQualidade(int qualidade) {
		this.qualidade = qualidade;
	}

}
