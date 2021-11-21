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
	
	/**
	 * 
	 * @param cantidad La cantidad de dinero que se quiere retirar
	 * @return true si es que hay suficiente dinero y false en caso contrario
	 */
	public boolean haySuficienteDineroDisponible(double cantidad) {
		return cantidad <= cantidadDinero;
	}
}
