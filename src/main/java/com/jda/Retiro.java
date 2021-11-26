package com.jda;

public class Retiro extends Transaccion{

	private final DispensadorDinero dispensador;
	private final Teclado teclado;
	private final Pantalla pantalla;
	private final BaseDeDatos baseDatos;
	private final int retiro1;
	private final int retiro2;
	private final int retiro3;
	private final int retiro4;

	public Retiro(int numeroCuenta) {
		super(numeroCuenta);
		dispensador = DispensadorDinero.getInstance();
		teclado = Teclado.getInstance();
		pantalla = Pantalla.getInstance();
		baseDatos = BaseDeDatos.getInstance();
		retiro1 = 10;
		retiro2 = 25;
		retiro3 = 65;
		retiro4 = 100;
	}

	@Override
	public void realizar() {
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
