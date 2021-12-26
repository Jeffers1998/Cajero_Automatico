public class Pantalla {
	private static Pantalla instance = new Pantalla();
	
	private Pantalla() {}
	
	public static Pantalla getInstance() {
		return instance;
	}
	
	public void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
