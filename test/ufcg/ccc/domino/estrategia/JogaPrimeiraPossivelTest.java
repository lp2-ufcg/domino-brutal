package ufcg.ccc.domino.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada;
import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.Mesa;
import ufcg.ccc.domino.Peca;

class JogaPrimeiraPossivelTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		mesa = new Mesa();
		mesa.jogaNaDireita(new Peca(1, 2));
		mesa.jogaNaEsquerda(new Peca(1, 1));
	}

	@Test
	void testPassa() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(0, 3)));

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	@Test
	void testJogaPrimeira() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(0, 2), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(0, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}

	@Test
	void testPrefereDireita() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(2, 1), new Peca(2, 6)));

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
	}
	
	@Test
	void testJogaNaEsquerda() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		Jogada j1 = estrategia.decideJogada(mesa, List.of(new Peca(3, 3), new Peca(4, 4), new Peca(1, 6)));

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}

}
