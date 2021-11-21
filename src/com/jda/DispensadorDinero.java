package com.jda;

public class DispensadorDinero {
	private int cantidadDinero;
	
	private static DispensadorDinero instance = new DispensadorDinero();
	private DispensadorDinero() {
		cantidadDinero = 500; //Cantidad inicial
	}
	
	public static DispensadorDinero getInstance() {
		return instance;
	}
	/**
	 * 
	 * @param cantidad La cantidad de dinero a expulsar
	 */
	public void expulsarDinero(double cantidad) {
		cantidadDinero -= cantidad;
	}

	public int getCantidadDinero() {
		return cantidadDinero;
	}
}
