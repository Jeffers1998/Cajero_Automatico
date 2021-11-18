package com.jda;

public abstract class Transaccion {
	//Variables estaticas usadas como opciones para el metodo crearTransaccion
	public static final  int RETIRO = 0; 
	public static final int CONSULTA_SALDO = 1;
	
	public int numeroCuenta; //El numero de cuenta en el cual se va a hacer la transaccion, Ariel: lo cambie a p�blico porque lo necesitaba en retiro y en consultar saldo
	
	
	public Transaccion(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public abstract void realizar();

	/**
	 * 
	 * @param tipo El tipo de transaccion a crear. Usar las variables estaticas de la clase Transaccion
	 * @return La instancia de la clase Transaccion
	 */
	public static Transaccion crearTransaccion(int tipo, int numeroCuenta) { // Ariel: no deber�a recibir numeroCuenta si ya lo tengo en el constructor 
		Transaccion myTransaccion = null; // Ariel: no estoy seguro de esto pero solo estamos en el flujo b�sico
		switch (tipo) {
			case RETIRO: 
				myTransaccion = new Retiro(numeroCuenta);  
				break;
			case CONSULTA_SALDO:
				myTransaccion = new ConsultaSaldo(numeroCuenta);
		
		}
		return myTransaccion;
	}
	
}
