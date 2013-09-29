package edu.tallerweb.pptls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa una de las Manos involucradas en el juego
 */
public class Mano {
	Forma forma;
	
	private static final Map<Integer, List<Integer>> juego = new HashMap<Integer,List<Integer>>(){
		{
			put(0, Arrays.asList(3,4));
			put(1, Arrays.asList(0,4));
			put(2, Arrays.asList(0,1));
			put(3, Arrays.asList(1,2));
			put(4, Arrays.asList(2,3));
		}
	};
	
	public Mano(final Forma forma) {
		this.forma = forma;
	}

	public Resultado jugarCon(final Mano otra) {
		if (juego.get(this.forma.getValor()).contains(otra.forma.getValor())){
			return Resultado.GANA;
		}
		else if (this.forma.getValor() == otra.forma.getValor()){
			return Resultado.EMPATA;
		}
		
		return Resultado.PIERDE;
	}

}
