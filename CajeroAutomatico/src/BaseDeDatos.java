
public class BaseDeDatos {
	private static BaseDeDatos instance = new BaseDeDatos();
	
	public static BaseDeDatos getInstance() {
		return instance;
	}
	
	private Cuenta[] cuentas;
	
	private BaseDeDatos() {
		cuentas = new Cuenta[3];
		cuentas[0] = new Cuenta(1, 1234, 200, 300);
	}
	/**
	 * 
	 * @param numeroCuenta El numero de cuenta a validar
	 * @param pin El pin correspondiente al numero de cuenta
	 * @return true si es que el usuario y PIN son válidos y false en caso contrario. 
	 */
	public boolean autenticarUsuario(int numeroCuenta, int pin) {
		//TODO Comunicarse con una de las cuentas del arreglo cuetnas mediante el metodo validarPin
		return false;
	}
	
	/**
	 * 
	 * @param numeroCuenta
	 * @return Devuelve el dinero disponible de la cuenta que tiene el numero proporcionado
	 */
	public double getDineroDisponible(int numeroCuenta) {
		//TODO Usar el metodo getSaldoDisponible de la clase Cuenta
		return 0;
	}
	
	
	public double getSaldoTotal(int numeroCuenta) {
		//TODO  Usar el metodo getSaldoTotal de la clase Cuenta
		return 0;
	}
	
	public void retirarDinero(int numeroCuenta, int cantidad) {
		//TODO Usar el metodo retirar dinero de la clase Cuenta
	}
	
}
