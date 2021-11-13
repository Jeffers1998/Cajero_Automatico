
public class Cuenta {
	private int numeroCuenta;
	private int pin;
	private double saldoDisponible;
	private double saldoTotal;
	
	public Cuenta(int numeroCuenta, int pin, double saldoDisponible, double saldoTotal) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.pin = pin;
		this.saldoDisponible = saldoDisponible;
		this.saldoTotal = saldoTotal;
	}
	
	/**
	 * 
	 * @param pin El PIN que se quiere comprobar para la cuenta correspondiente
	 * @return true si el pin es valido y false en caso contrario
	 */
	public boolean validarPin(int pin) {
		//TODO
		return false;
	}
	
	public void retirarDinero(double cantidad) {
		//TODO Disminuir la cantidad de dinero pasada como parametro al saldo disponible y al total.
	}
	
	public double getSaldoDisponible() {
		//TODO
		return 0;
	}
	
	public double getSaldoTotal() {
		//TODO
		return 0;
	}
}
