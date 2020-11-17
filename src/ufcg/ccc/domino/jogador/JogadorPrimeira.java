/**
 * 
 */
package ufcg.ccc.domino.jogador;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

/**
 *
 */
public class JogadorPrimeira implements Jogador {

	public Jogada decideJogada(Mesa mesa, List<Peca> mao) {
		Peca queroJogar = mao.get(0);
		if(mesa.getNumPecas()  == 0 || queroJogar.encaixa(mesa.getNumNaDireita())) {
			return new Jogada(queroJogar, TipoJogada.NA_DIREITA);	
		} else {
			return new Jogada();
		}
		
	}

}
