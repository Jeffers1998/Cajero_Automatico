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
			if(!seEscogioSalir(transaccionEscogida)) {
				Transaccion transaccionActual = Transaccion.crearTransaccion(transaccionEscogida, numeroCuentaActual);
				transaccionActual.realizar();
			}else
				break;
		}
	}
	
	private boolean seEscogioSalir(int transaccionEscogida) {
		return transaccionEscogida == -1;
	}
	
	private void solicitarAutenticacion() {
		try {
			pantalla.mostrarMensaje("Por favor, ingrese su numero de cuenta: ");
			int numeroCuenta = Integer.parseInt(teclado.getEntrada());
			pantalla.mostrarMensaje("Ingrese su PIN");
			int pin = Integer.parseInt(teclado.getEntrada());
			usuarioAutenticado = baseDatos.autenticarUsuario(numeroCuenta, pin);
			
			if(usuarioAutenticado)
				numeroCuentaActual = numeroCuenta;
			else
				pantalla.mostrarMensaje("Usuario o PIN incorrectos");
			
		}catch(NumberFormatException e) {
			pantalla.mostrarMensaje("No se ha ingresado un n�mero");
		}
	}
	
	private int solicitarTransaccion() {
		pantalla.mostrarMensaje("Seleccione una opcion:\na. Realizar un retiro\nb. Consultar cuenta");
		String entrada = teclado.getEntrada();
		
		switch(entrada) {
		case "a":
			return Transaccion.RETIRO;
		case "b":
			return Transaccion.CONSULTA_SALDO;
		}
		
		return -1;
	}
	
}
