
public class Retiro extends Transaccion{

	private DispensadorDinero dispensador;
	private Teclado teclado;
	private Pantalla pantalla;
	private BaseDeDatos baseDatos;
	
	public Retiro(int numeroCuenta) {
		super(numeroCuenta);
		dispensador = DispensadorDinero.getInstance();
		teclado = Teclado.getInstance();
		pantalla = pantalla.getInstance();
		baseDatos = baseDatos.getInstance();
	}

	@Override
	public void realizar() {
		// TODO Solicitar mediante las clases Pantalla y Teclado el monto a retirar y realizar el retiro mediante la clase BaseDeDatos. Finalmente solicitar al dispensador que expulse el dinero
		
	}

}
