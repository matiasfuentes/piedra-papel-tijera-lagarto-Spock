package edu.tallerweb.pptls;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mano {
	private Forma forma;

	public Forma getForma(){
		return this.forma;
	}

	public void setForma(Forma forma){
		this.forma = forma;
	}

	private static final Map<Integer, List<Integer>> juego = new HashMap<Integer, List<Integer>>() {
		{
			put(Forma.PIEDRA.getValor(), Arrays.asList(Forma.LAGARTO.getValor(), Forma.TIJERA.getValor()));
			put(Forma.SPOCK.getValor(), Arrays.asList(Forma.PIEDRA.getValor(), Forma.TIJERA.getValor()));
			put(Forma.PAPEL.getValor(), Arrays.asList(Forma.PIEDRA.getValor(), Forma.SPOCK.getValor()));
			put(Forma.LAGARTO.getValor(), Arrays.asList(Forma.SPOCK.getValor(), Forma.PAPEL.getValor()));
			put(Forma.TIJERA.getValor(), Arrays.asList(Forma.PAPEL.getValor(), Forma.LAGARTO.getValor()));
		}
	};

	public Mano(final Forma forma) {
		this.forma = forma;
	}

	public Resultado jugarCon(final Mano otra) {
		if (juego.get(this.forma.getValor()).contains(otra.forma.getValor())) {
			return Resultado.GANA;
		} else if (this.forma.getValor() == otra.forma.getValor()) {
			return Resultado.EMPATA;
		}

		return Resultado.PIERDE;
	}

}
