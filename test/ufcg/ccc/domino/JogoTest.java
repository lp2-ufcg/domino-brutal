package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.jogador.JogadorPrimeira;

class JogoTest {

	@Test
	void testRodadaInicial() throws JogadaInvalidaException {
		Jogo j = new Jogo(new JogadorPrimeira(), new JogadorPrimeira(), 6);
		
		assertEquals(0, j.getNumRodadas());
		assertEquals(6, j.getNumPecasJ1());
		assertEquals(6, j.getNumPecasJ2());
		
		j.rodada(); 
		
		assertEquals(1, j.getNumRodadas());
		assertEquals(5, j.getNumPecasJ1());
		assertEquals(5, j.getNumPecasJ2());
		
		System.out.println(j.toString());
	}
	
	@Test
	void testJogarRestante() throws Exception {
		
	}
}
