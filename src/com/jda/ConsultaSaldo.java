package com.jda;

public class ConsultaSaldo extends Transaccion{

	private BaseDeDatos baseDatos;
	private Pantalla pantalla;
	
	public ConsultaSaldo(int numeroCuenta) {
		super(numeroCuenta);
		baseDatos = BaseDeDatos.getInstance();
		pantalla = Pantalla.getInstance();
	}

	@Override
	public void realizar() {
		double saldoDisponible = baseDatos.getDineroDisponible(numeroCuenta);
		pantalla.mostrarMensaje("id: " + numeroCuenta + "\n" 
								+ "Saldo Disponible: " + saldoDisponible);
	}

}
