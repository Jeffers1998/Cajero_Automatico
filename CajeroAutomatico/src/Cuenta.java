
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
		return this.pin == pin;
	}
	
	public void retirarDinero(double cantidad) {
		this.saldoDisponible = this.saldoDisponible - cantidad;
	}
	
	public double getSaldoDisponible() {
		return saldoDisponible;
	}
	
	public double getSaldoTotal() {
		return saldoTotal;
	}
	// añadi este método para que se pudiera solicitar el número de cuenta desde la base de datos ya q pusieron private
	public int getNumCuenta() {
		return numeroCuenta;
	}
}
