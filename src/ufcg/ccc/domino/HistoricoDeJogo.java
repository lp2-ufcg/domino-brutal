package ufcg.ccc.domino;

import java.util.LinkedList;
import java.util.List;

/**
 * Guarda o histórico de um jogo, para usarmos em interfaces.
 *
 */
public class HistoricoDeJogo {

	private List<SituacaoNoJogo> rodadas;
	private Jogador jogador1;
	private Jogador jogador2;
	private boolean empate;
	private String vencedor;

	/**
	 * Cria um novo histórico.
	 * 
	 * @param jogador1 Um jogador.
	 * @param jogador2 O outro.
	 */
	public HistoricoDeJogo(Jogador jogador1, Jogador jogador2) {
		this.rodadas = new LinkedList<SituacaoNoJogo>();
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.empate = false;
		this.vencedor = null;
	}

	public void addRodada(Jogada ultimaJogadaJ1, Jogada ultimaJogadaJ2, Mesa mesa) {
		this.rodadas.add(new SituacaoNoJogo(jogador1, ultimaJogadaJ1, jogador2, ultimaJogadaJ2, jogador1.getMao(),
				jogador2.getMao(), mesa.getPecasNaMesa()));
	}

	public void setResultadoEmpate() {
		this.empate = true;
		this.vencedor = null;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
		this.empate = false;
	}

	public boolean isEmpate() {
		return empate;
	}

	public String getVencedor() {
		return vencedor;
	}
	
	@Override
	public String toString() {
		String o = "==\n== Novo Jogo \n==";
		for (int i = 0; i < rodadas.size(); i++) {
			o += "\nRodada " + i + "\n" + rodadas.get(i).toString();
		}
		
		o += "\n--RESULTADO: " + (this.isEmpate() ? "EMPATE\n" : ("VITÓRIA DE " + getVencedor()) + "\n");
		return o;
	}

	private class SituacaoNoJogo {
		private Jogada jogadaJ1;
		private Jogada jogadaJ2;
		private List<Peca> maoJ1;
		private List<Peca> maoJ2;
		private List<Peca> mesa;
		private Jogador jogador1;
		private Jogador jogador2;

		public SituacaoNoJogo(Jogador j1, Jogada jogadaJ1, Jogador j2, Jogada jogadaJ2, List<Peca> maoJ1,
				List<Peca> maoJ2, List<Peca> naMesa) {
			this.jogador1 = j1;
			this.jogadaJ1 = jogadaJ1;
			this.jogador2 = j2;
			this.jogadaJ2 = jogadaJ2;
			this.maoJ1 = maoJ1;
			this.maoJ2 = maoJ2;
			this.mesa = naMesa;
		}

		@Override
		public String toString() {
			return "  " + this.jogador1.getNome() + " : " + jogadaJ1.toString() + ", mão: "
					+ maoJ1.toString() + "\n  " + this.jogador2.getNome() + " : " + jogadaJ2.toString() + ", mão: "
					+ maoJ2.toString() + "\n  " + 
					"MESA: " + mesa.toString();
		}
	}
}
