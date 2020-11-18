package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada.TipoJogada;

class JogadaTest {

	@Test
	void testJogadaPassa() {
		Jogada j1 = new Jogada();
		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogadaComPeca() {
		Jogada j1 = new Jogada(new Peca(1, 1), TipoJogada.NA_ESQUERDA);
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
	}
}
