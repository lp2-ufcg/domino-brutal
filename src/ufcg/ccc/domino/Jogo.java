package ufcg.ccc.domino;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.jogador.Jogador;
import ufcg.ccc.domino.jogador.JogadorPrimeira;

public class Jogo {

	private Jogador jogador1;
	private List<Peca> maoJ1;

	private Jogador jogador2;
	private List<Peca> maoJ2;

	private Mesa mesa;
	private int rodadasJogadas;

	public Jogo(JogadorPrimeira jogador1, JogadorPrimeira jogador2, int numPecasInicial) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;

		this.mesa = new Mesa();
		this.maoJ1 = new LinkedList<Peca>();
		this.maoJ2 = new LinkedList<Peca>();

		distribuiPecas(numPecasInicial);
		
		this.rodadasJogadas = 0;
	}

	private Set<Peca> distribuiPecas(int numPecasInicial) {
		List<Peca> todas = criaPecas();
		for (int i = 0; i < numPecasInicial; i++) {
			maoJ1.add(todas.remove(0));
			maoJ2.add(todas.remove(0));
		}
		return new HashSet<Peca>(todas);
	}

	private List<Peca> criaPecas() {
		List<Peca> pecas = new LinkedList<Peca>();

		for (int i = 0; i <= 6; i++) {
			for (int j = i; j <= 6; j++) {
				pecas.add(new Peca(i, j));
			}
		}

		return pecas;
	}

	public int getNumPecasJ1() {
		return this.maoJ1.size();
	}

	public int getNumPecasJ2() {
		return this.maoJ2.size();
	}

	public void rodada() throws JogadaInvalidaException {
		Jogada jogadaJ1 = jogador1.decideJogada(mesa, maoJ1);
		jogaJogada(jogador1, maoJ1, jogadaJ1);

		Jogada jogadaJ2 = jogador2.decideJogada(mesa, maoJ2);
		jogaJogada(jogador2, maoJ2, jogadaJ2);
		
		rodadasJogadas += 1;
	}

	private void jogaJogada(Jogador jogador, List<Peca> mao, Jogada jogada) throws JogadaInvalidaException {
		if (jogada.getTipo() == TipoJogada.PASSA) {
			System.out.println(jogador + " passa a vez");
			return;
		}

		Peca pecaJogada = jogada.getPeca();
		boolean realmenteTem = mao.contains(pecaJogada);
		if (!realmenteTem) {
			throw new JogadaInvalidaException(jogador + " tentou jogar peça que não tem: " + pecaJogada);
		}

		switch (jogada.getTipo()) {
		case NA_ESQUERDA: {
			this.mesa.jogaNaEsquerda(pecaJogada);
			break;
		}
		case NA_DIREITA: {
			this.mesa.jogaNaDireita(pecaJogada);
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + jogada.getTipo());
		}

		mao.remove(pecaJogada);
	}

	@Override
	public String toString() {
		String o = "MESA: " + mesa.toString() + "\n" + jogador1.toString() + " x " + jogador2.toString();
		return o;
	}

	public int getNumRodadas() {
		return rodadasJogadas;
	}
}
