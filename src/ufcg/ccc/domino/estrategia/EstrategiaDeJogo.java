package ufcg.ccc.domino.estrategia;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Peca;

/**
 * Uma estratégia para jogar em uma partida de dominó. É usada pelo jogo para
 * decidir a próxima jogada do jogador.
 *
 */
public interface EstrategiaDeJogo {

	/**
	 * Decide a jogada na vez do jogador.
	 * @param mao  As peças disponíveis para o jogador.
	 * @param mesa O estado atual da mesa, com as peças já jogadas.
	 * 
	 * @return Uma Jogada
	 */
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa);
}