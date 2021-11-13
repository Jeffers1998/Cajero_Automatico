
public class ConsultaSaldo extends Transaccion{

	private BaseDeDatos baseDatos;
	private Pantalla pantalla;
	
	public ConsultaSaldo(int numeroCuenta) {
		super(numeroCuenta);
		baseDatos = BaseDeDatos.getInstance();
		pantalla = Pantalla.getInstance();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void realizar() {
		// TODO Consultar con BaseDeDatos cual es el saldo de la cuenta actual (utilizar la variable numeroCuenta)
		
	}

}
