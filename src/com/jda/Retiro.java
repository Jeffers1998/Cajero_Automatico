package com.jda;

public class Retiro extends Transaccion{

	private final DispensadorDinero dispensador;
	private final Teclado teclado;
	private final Pantalla pantalla;
	private final BaseDeDatos baseDatos;

	public Retiro(int numeroCuenta) {
		super(numeroCuenta);
		dispensador = DispensadorDinero.getInstance();
		teclado = Teclado.getInstance();
		pantalla = Pantalla.getInstance();
		baseDatos = BaseDeDatos.getInstance();
	}

	@Override
	public void realizar() {
		int retiro1 = 10;
		int retiro2 = 25;
		int retiro3 = 65;
		int retiro4 = 100;
		pantalla.mostrarMensaje("Seleccionar Monto \n"
				+ " a. " + retiro1 + "\n"
				+ " b. " + retiro2 + "\n"
				+ " c. " + retiro3 + "\n"
				+ " d. " + retiro4 + "\n");
		double montoRetiro;
		switch(teclado.getEntrada()) {
			case "a":
				montoRetiro = retiro1;
				break;
			case "b":
				montoRetiro = retiro2;
				break;
			case "c":
				montoRetiro = retiro3;
				break;
			case "d":
				montoRetiro = retiro4;
				break;
			default:
				montoRetiro = 0;
		}

		if(montoRetiro <= dispensador.getCantidadDinero()){
			baseDatos.retirarDinero(numeroCuenta, montoRetiro);
			dispensador.setCantidadDinero((int) (dispensador.getCantidadDinero() - montoRetiro));
		}

		pantalla.mostrarMensaje("Retiro Exitoso: \n"
				+ "Id Cuenta: " + numeroCuenta + "\n"
				+ "Retiro: " + montoRetiro + "\n"
				+ "Saldo Diponible: " + baseDatos.getDineroDisponible(numeroCuenta) + "\n"
		        + "Saldo Total: " + baseDatos.getSaldoTotal(numeroCuenta));
	}

}
