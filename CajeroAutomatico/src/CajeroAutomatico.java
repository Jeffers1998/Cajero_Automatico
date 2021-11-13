
public class CajeroAutomatico {
	private boolean usuarioAutenticado;
	
	private Pantalla pantalla;
	private Teclado teclado;
	private DispensadorDinero dispensador;
	
	private BaseDeDatos baseDatos;
	private int numeroCuentaActual;
	public CajeroAutomatico() {
		usuarioAutenticado = false;
		
		pantalla = Pantalla.getInstance();
		teclado = Teclado.getInstance();
		dispensador = DispensadorDinero.getInstance();
		
		baseDatos = BaseDeDatos.getInstance();
	}
	
	public void iniciar() {
		while(!usuarioAutenticado)
			numeroCuentaActual = solicitarAutenticacion();
			
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
		//TODO
		return false;
	}
	
	private int  solicitarAutenticacion() {
		//TODO
		return 0;
	}
	
	private int solicitarTransaccion() {
		//TODO
		return 0;
	}
	
}
