
public abstract class Transaccion {
	//Variables estaticas usadas como opciones para el metodo crearTransaccion
	public static int RETIRO = 0; 
	public static int CONSULTA_SALDO = 1;
	
	private int numeroCuenta; //El numero de cuenta en el cual se va a hacer la transaccion
	
	
	public Transaccion(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public abstract void realizar();

	/**
	 * 
	 * @param tipo El tipo de transaccion a crear. Usar las variables estaticas de la clase Transaccion
	 * @return La instancia de la clase Transaccion
	 */
	public static Transaccion crearTransaccion(int tipo, int numeroCuenta) {
		//TODO Devolver una instancia de las clases hijas en base al tipo de transaccion pasado como parametro.
		return null;
	}
	
}
