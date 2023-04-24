package entity;

public class Posicao {
	
	int linha;
	int coluna;
	public Posicao(int linha, int coluna) {
		super();
		this.linha = linha;
		this.coluna = coluna;
	}
	@Override
	public String toString() {
		return "(" + linha + ", " + coluna + ")";
	}
	
	
	

}
