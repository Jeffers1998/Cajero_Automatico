
public class CajeroAutomatico {
	private boolean usuarioAutenticado;
	
	private Pantalla pantalla;
	private Teclado teclado;
	private DispensadorDinero dispensador;
	
	private BaseDeDatos baseDatos;
	
	public CajeroAutomatico() {
		pantalla = Pantalla.getInstance();
		teclado = Teclado.getInstance();
		dispensador = DispensadorDinero.getInstance();
		
		baseDatos = BaseDeDatos.getInstance();
	}
	public void iniciar() {
		
	}
	
}
