import java.util.Scanner;

public class Teclado {
	private static Teclado instance = new Teclado();
	private Scanner sc;
	
	public static Teclado getInstance() {
		return instance;
	}
	
	private Teclado() {
		sc = new Scanner(System.in);
	}
	
	public String getEntrada() {
		return sc.next();
	}
}
