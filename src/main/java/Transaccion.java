public abstract class Transaccion {
	//Variables estaticas usadas como opciones para el metodo crearTransaccion
	public static final  int RETIRO = 0;
	public static final int CONSULTA_SALDO = 1;
	public static final int DEPOSITO = 2;
	public static final int CAMBIARPIN = 3;
	
	public int numeroCuenta;
	
	
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
		Transaccion myTransaccion;
		switch (tipo) {
			case RETIRO:
				myTransaccion = new Retiro(numeroCuenta);
				break;
			case CONSULTA_SALDO:
				myTransaccion = new ConsultaSaldo(numeroCuenta);
				break;
			case DEPOSITO:
				myTransaccion = new Deposito(numeroCuenta);
				break;
			case CAMBIARPIN:
				myTransaccion = new CambioPIN(numeroCuenta);
				break;
			default:
				throw new TransaccionInvalidaException();
		}
		return myTransaccion;
	}
	
}
