
public class Retiro extends Transaccion{

	private DispensadorDinero dispensador;
	private Teclado teclado;
	private Pantalla pantalla;
	private BaseDeDatos baseDatos;
	
	private int retiro1 = 10;
	private int retiro2 = 25;
	private int retiro3 = 65;
	private int retiro4 = 100;
	
	public Retiro(int numeroCuenta) {
		super(numeroCuenta);
		dispensador = DispensadorDinero.getInstance();
		teclado = Teclado.getInstance();
		pantalla = Pantalla.getInstance();
		baseDatos = BaseDeDatos.getInstance();
		baseDatos = null;
	}

	@Override
	public void realizar() {
		pantalla.mostrarMensaje("Seleccionar Monto \n"
				+ " a. " + retiro1 + "\n"
				+ " b. " + retiro2 + "\n"
				+ " c. " + retiro3 + "\n"
				+ " d. " + retiro4 + "\n");
		double cantidad = 0;
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
		}
		
		baseDatos.retirarDinero(numeroCuenta, cantidad);
		dispensador.expulsarDinero(cantidad);
		pantalla.mostrarMensaje("Retiro Exitoso: \n"
				+ "Id Cuenta: " + numeroCuenta + "\n"
				+ "Retiro: " + cantidad + "\n"
				+ "Actual: " + baseDatos.getDineroDisponible(numeroCuenta));
	}

}
