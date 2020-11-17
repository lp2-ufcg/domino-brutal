package ufcg.ccc.domino.jogador;

import java.util.List;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

public interface Jogador {

	public Jogada decideJogada(Mesa mesa, List<Peca> mao);
}