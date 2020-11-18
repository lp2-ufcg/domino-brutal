package ufcg.ccc.domino;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ufcg.ccc.domino.Jogada.TipoJogada;
import ufcg.ccc.domino.estrategia.EstrategiaDeJogo;
import ufcg.ccc.domino.estrategia.EstrategiaInvalidaException;
import ufcg.ccc.domino.estrategia.JogaPrimeiraPossivel;
import ufcg.ccc.domino.estrategia.VisaoDaMesa;

class JogadorTest {

	List<Peca> mao1 = List.of(new Peca(0, 2), new Peca(0, 3));

	@Test
	void testGetNumPecas() {
		Jogador jogador = new Jogador("j", new JogaPrimeiraPossivel(), mao1);
		assertEquals(2, jogador.getNumPecas());
	}

	
	@Test
	void testRemovePeca() {
		Jogador jogador = new Jogador("j", new JogaPrimeiraPossivel(), mao1);
		jogador.removeDaMao(mao1.get(0));
		assertEquals(1, jogador.getNumPecas());
	}
	
	@Test
	void testEstrategiaComBug() throws Exception {
		EstrategiaDeJogo errada = new EstrategiaDeJogo() {
			@Override
			public Jogada decideJogada(VisaoDaMesa mesa, List<Peca> mao) {
				return new Jogada(new Peca(6, 6), TipoJogada.NA_ESQUERDA);
			}
		};
		
		Jogador jogador = new Jogador("j", errada, mao1);
		
		try {
			jogador.decideJogada(new Mesa());
			fail("Deve jogar exceção em caso de decisão impossível da estratégia");
		} catch (EstrategiaInvalidaException e) {
			// esperada
		}
	}

}
