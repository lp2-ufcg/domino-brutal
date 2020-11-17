package ufcg.ccc.domino;

public class Peca {

	private int numEsquerdo;
	private int numDireito;

	public Peca(int numEsquerdo, int numDireito) {
		this.numEsquerdo = numEsquerdo;
		this.numDireito = numDireito;
	}

	public void gira() {
		int tmp = numEsquerdo;
		numEsquerdo = numDireito;
		numDireito = tmp;
	}

	public int getNumDireito() {
		return numDireito;
	}

	public int getNumEsquerdo() {
		return numEsquerdo;
	}
	
	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito();
	}

	public boolean encaixa(int numero) {
 		return this.numDireito == numero || this.numEsquerdo == numero;
	}

}
