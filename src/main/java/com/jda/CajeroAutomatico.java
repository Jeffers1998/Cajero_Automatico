package com.jda;

public class CajeroAutomatico {
	private boolean usuarioAutenticado;
	
	private Pantalla pantalla;
	private Teclado teclado;
	private BaseDeDatos baseDatos;
	private int numeroCuentaActual;

	public CajeroAutomatico() {
		usuarioAutenticado = false;
		pantalla = Pantalla.getInstance();
		teclado = Teclado.getInstance();
		baseDatos = BaseDeDatos.getInstance();
	}
	
	public void iniciar() {
		while(!usuarioAutenticado)
			solicitarAutenticacion();
			
		while(true) {
			int transaccionEscogida = solicitarTransaccion();
			if(! (transaccionEscogida == -1)) {
				Transaccion transaccionActual = Transaccion.crearTransaccion(transaccionEscogida, numeroCuentaActual);
				transaccionActual.realizar();
			}else
				break;
		}
	}
	
	private void solicitarAutenticacion() {
		try {
			int numeroCuenta = getNumeroCuenta();
			int pin = getPin();
			usuarioAutenticado = baseDatos.autenticarUsuario(numeroCuenta, pin);
			
			if(usuarioAutenticado)
				numeroCuentaActual = numeroCuenta;
			else
				pantalla.mostrarMensaje("Usuario o PIN incorrectos");
			
		}catch(NumberFormatException e) {
			pantalla.mostrarMensaje("No se ha ingresado un n�mero");
		}
	}

	private int getPin() {
		pantalla.mostrarMensaje("Ingrese su PIN");
		int pin = Integer.parseInt(teclado.getEntrada());
		return pin;
	}

	private int getNumeroCuenta() {
		pantalla.mostrarMensaje("Por favor, ingrese su numero de cuenta: ");
		return Integer.parseInt(teclado.getEntrada());
	}


	private int solicitarTransaccion() {
		pantalla.mostrarMensaje("Seleccione una opcion:\na. Realizar un retiro\nb. Consultar cuenta\nc. Realizar un deposito");
		String entrada = teclado.getEntrada();
		
		switch(entrada) {
		case "a":
			return Transaccion.RETIRO;
		case "b":
			return Transaccion.CONSULTA_SALDO;
			case "c":

		    return Transaccion.DEPOSITO;
		}
		
		return -1;
	}
	
}
