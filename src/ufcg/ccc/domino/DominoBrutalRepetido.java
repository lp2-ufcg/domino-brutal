package ufcg.ccc.domino;

import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;

/**
 * Exemplo de como fazer um um main com uma disputa de muuuitos jogos entre duas
 * estratégias.
 * 
 */
public class DominoBrutalRepetido {

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		int vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0;

		EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new JogaPrimeiraPossivel(); 
		
		for (int i = 0; i < 10000; i++) {
			Jogo j = new Jogo("J1", estrategia1, "J2", estrategia2, 12);
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1++;
			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
			}
		}

		System.out.println("Jogos:\t" + (empates + vitoriasJ1 + vitoriasJ2) + "\nJ1:\t" + vitoriasJ1 + " vitórias\nJ2:\t"
				+ vitoriasJ2 + " vitórias\nEmpate:\t" + empates);
	}

}
