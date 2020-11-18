package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Peca;

/**
 * Essa interface define os métodos que implementações de EstrategiaDeJogo podem
 * acessar sobre as peças do jogo. Dessa maneira, controlamos acesso aos métodos
 * que alteram a mesa de fato.
 *
 */
public interface VisaoDaMesa {

	/**
	 * Acessa o número aberto na peça mais à direita da mesa.
	 * 
	 * @return Número que pode ser jogado nesse lado.
	 */
	int getNumNaDireita();

	/**
	 * Acessa o número aberto na peça mais à esquerda da mesa.
	 * 
	 * @return Número que pode ser jogado nesse lado.
	 */
	int getNumNaEsquerda();

	/**
	 * Acessa o número de peças na mesa.
	 * 
	 * @return peças na mesa.
	 */
	int getNumPecas();

	/**
	 * Acessa uma cópia das peças da mesa em ordem, da esquerda para a direita. Como
	 * é uma cópia, as estratégias não podem alterar a mesa.
	 * 
	 * @return lista da peças na mesa.
	 */
	List<Peca> getPecasNaMesa();
}
