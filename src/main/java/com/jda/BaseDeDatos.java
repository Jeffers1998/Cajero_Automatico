package com.jda;

public class BaseDeDatos {
	private static final BaseDeDatos instance = new BaseDeDatos();
	
	public static BaseDeDatos getInstance() {
		return instance;
	}
	
	private final Cuenta[] cuentas;
	
	private BaseDeDatos() {
		cuentas = new Cuenta[3];
		cuentas[0] = new Cuenta(1, 1234, 200, 300);
		cuentas[1] = new Cuenta(2, 5678, 500, 600);
		cuentas[2] = new Cuenta(3, 4321, 1000, 1100);
	}

	public BaseDeDatos(Cuenta[] cuentas){
		this.cuentas = cuentas;
	}
	/**
	 * 
	 * @param numeroCuenta El numero de cuenta a validar
	 * @param pin El pin correspondiente al numero de cuenta
	 * @return true si es que el usuario y PIN son v�lidos y false en caso contrario. 
	 */
	public boolean autenticarUsuario(int numeroCuenta, int pin) {
		if (buscarCuenta(numeroCuenta) != null) {
			return buscarCuenta(numeroCuenta).validarPin(pin);
		}
		return false;
	}
	
	/**
	 * 
	 * @param numeroCuenta
	 * @return Devuelve el dinero disponible de la cuenta que tiene el numero proporcionado
	 */
	public double getDineroDisponible(int numeroCuenta) {
		if (buscarCuenta(numeroCuenta) != null) {
			return buscarCuenta(numeroCuenta).getSaldoDisponible();
		}
		return -1;
	}
	
	public double getSaldoTotal(int numeroCuenta) {
		if (buscarCuenta(numeroCuenta) != null) {
			return buscarCuenta(numeroCuenta).getSaldoTotal();
		}
		return -1;
	}
	
	public void retirarDinero(int numeroCuenta, double cantidad) {
		if (buscarCuenta(numeroCuenta) != null) {
			buscarCuenta(numeroCuenta).retirarDinero(cantidad);
		}
	}
	public void depositarDinero(int numeroCuenta, double cantidad ) {
		if (buscarCuenta(numeroCuenta) != null) {
			buscarCuenta(numeroCuenta).depositarDinero(cantidad);
		}
	}

	private Cuenta buscarCuenta(int numeroCuenta){
		Cuenta cuenta;
		for(Cuenta miCuenta: cuentas) {
			if (miCuenta.getNumCuenta() == numeroCuenta) {
				cuenta = miCuenta;
				return cuenta;
			}
		}

		cuenta = null;
		return cuenta;
	}
	
}
