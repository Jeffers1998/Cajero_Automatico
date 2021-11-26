package main.java.com.jda;

public class DispensadorDinero {
	private int cantidadDinero;
	
	private static DispensadorDinero instance = new DispensadorDinero();
	private DispensadorDinero() {
		cantidadDinero = 500; //Cantidad inicial
	}
	
	public static DispensadorDinero getInstance() {
		return instance;
	}

	public int getCantidadDinero() {
		return cantidadDinero;
	}

	public void setCantidadDinero(int cantidadDinero) {
		this.cantidadDinero = cantidadDinero;
	}
}
