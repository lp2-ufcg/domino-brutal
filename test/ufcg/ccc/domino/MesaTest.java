package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MesaTest {

	private Mesa mesa;

	@BeforeEach
	void setUp() throws Exception {
		this.mesa = new Mesa();
	}

	@Test
	void testComecaVazio() throws Exception {
		assertEquals(0, mesa.getNumPecas());
		assertEquals(Mesa.SEM_PECA, mesa.getNumNaDireita());
		assertEquals(Mesa.SEM_PECA, mesa.getNumNaEsquerda());
	}

	@Test
	void testAddPecaCorreta() throws JogadaInvalidaException {
		Peca peca12 = new Peca(1, 2);
		Peca peca25 = new Peca(2, 5);

		mesa.jogaNaDireita(peca12);
		// 1:2

		assertEquals(1, mesa.getNumPecas());
		assertEquals(2, mesa.getNumNaDireita());
		assertEquals(1, mesa.getNumNaEsquerda());

		mesa.jogaNaDireita(peca25);
		// 1:2 2:5

		assertEquals(2, mesa.getNumPecas());
		assertEquals(5, mesa.getNumNaDireita());
		assertEquals(1, mesa.getNumNaEsquerda());
		
		mesa.jogaNaEsquerda(new Peca(1, 5));
		// 5:1 1:2 2:5

		assertEquals(5, mesa.getNumNaDireita());
		assertEquals(5, mesa.getNumNaEsquerda());
		
		mesa.jogaNaEsquerda(new Peca(5, 5));
		// 5:5 5:1 1:2 2:5
		
		assertEquals(4, mesa.getNumPecas());
		assertEquals(5, mesa.getNumNaDireita());
		assertEquals(5, mesa.getNumNaEsquerda());
	}
	
	@Test
	void testJogadaInvalida() throws Exception {
		mesa.jogaNaDireita(new Peca(2, 1));
		// 2:1

		try {
			mesa.jogaNaDireita(new Peca(3, 3));
			fail("Jogada impossível");
		} catch (JogadaInvalidaException e) {
			// esperado
		}
		
		assertEquals(1, mesa.getNumPecas());
		assertEquals(2, mesa.getNumNaEsquerda());
		assertEquals(1, mesa.getNumNaDireita());
	}

	@Test
	void testPosicaoDaPrimeiraPeca() throws Exception {
		mesa.jogaNaDireita(new Peca(2, 1));

		assertEquals(2, mesa.getNumNaEsquerda());
		assertEquals(1, mesa.getNumNaDireita());

		mesa = new Mesa();

		mesa.jogaNaDireita(new Peca(1, 2));
		assertEquals(1, mesa.getNumNaEsquerda());
		assertEquals(2, mesa.getNumNaDireita());

		mesa = new Mesa();

		mesa.jogaNaEsquerda(new Peca(1, 2));
		assertEquals(1, mesa.getNumNaEsquerda());
		assertEquals(2, mesa.getNumNaDireita());
	}

}
