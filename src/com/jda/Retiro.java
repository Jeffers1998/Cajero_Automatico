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
		double cantidad;
		switch(teclado.getEntrada()) {
			case "a":
				cantidad = retiro1;
				break;
			case "b":
				cantidad = retiro2;
				break;
			case "c":
				cantidad = retiro3;
				break;
			case "d":
				cantidad = retiro4;
				break;
			default:
				cantidad = 0;
		}
		baseDatos.retirarDinero(numeroCuenta, cantidad);
		dispensador.expulsarDinero(cantidad);
		pantalla.mostrarMensaje("Retiro Exitoso: \n"
				+ "Id Cuenta: " + numeroCuenta + "\n"
				+ "Retiro: " + cantidad + "\n"
				+ "Saldo Diponible: " + baseDatos.getDineroDisponible(numeroCuenta) + "\n"
		        + "Saldo Total: " + baseDatos.getSaldoTotal(numeroCuenta));
	}

}
