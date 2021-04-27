package ufcg.ccc.domino;

/**
 * Encapsula uma jogada, incluindo uma peça e a posição onde jogar.
 *
 */
public class Jogada {

	/**
	 * Constantes para informar se a jogada é na direita, esquerda (da mesa), oue é
	 * para passar a vez.
	 */
	public enum TipoJogada {
		NA_ESQUERDA, NA_DIREITA, PASSA
	}

	private Peca peca;
	private TipoJogada tipo;

	/**
	 * Cria a jogada.
	 * 
	 * @param peca A peça a jogar.
	 * @param tipo Se é uma jogada à esquerda, direita ou um passa.
	 */
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

	/**
	 * @return Se é uma jogada à esquerda, direita ou um passa.
	 */
	public TipoJogada getTipo() {
		return tipo;
	}

	/**
	 * @return A peça da jogada.
	 */
	public Peca getPeca() {
		return peca;
	}

	@Override
	public String toString() {
		return (this.tipo == TipoJogada.PASSA ? "" : peca.toString() + " ") + this.getTipoEmString();
	}

	/*
	 * Para facilitar o toString() 
	 */
	private String getTipoEmString() {
		switch (tipo) {
		case PASSA: {
			return "Passou";
		}
		case NA_DIREITA: {
			return "na direita";
		}
		case NA_ESQUERDA: {
			return "na esquerda";
		}
		default: {
			return null;
		}
		}
	}

}
