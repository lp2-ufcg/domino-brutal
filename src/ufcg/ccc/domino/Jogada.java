package ufcg.ccc.domino;

public class Jogada {

	public enum TipoJogada {
		NA_ESQUERDA, NA_DIREITA, PASSA
	}


	private Peca peca;
	private TipoJogada tipo;
	
	
	public Jogada(Peca peca, TipoJogada tipo) {
		this.peca = peca;
		this.tipo = tipo;
	}


	/**
	 * Cria uma jogada de PASSA. Sem usar peça, o jogador passa a vez.
	 */
	public Jogada() {
		this(null, TipoJogada.PASSA);
	}


	public TipoJogada getTipo() {
		return tipo;
	}


	public Peca getPeca() {
		return peca;
	}

}
