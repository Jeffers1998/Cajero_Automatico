public class Deposito extends Transaccion{

    private final DispensadorDinero dispensador;
    private final Teclado teclado;
    private final Pantalla pantalla;
    private final BaseDeDatos baseDatos;
    private final int deposito1;
    private final int deposito2;
    private final int deposito3;
    private final int deposito4;

    public Deposito(int numeroCuenta) {
        super(numeroCuenta);
        dispensador = DispensadorDinero.getInstance();
        teclado = Teclado.getInstance();
        pantalla = Pantalla.getInstance();
        baseDatos = BaseDeDatos.getInstance();
        deposito1 = 10;
        deposito2 = 25;
        deposito3 = 65;
        deposito4 = 100;
    }

    @Override
    public void realizar() {
        pantalla.mostrarMensaje("Seleccionar Monto \n"
                + " a. " + deposito1 + "\n"
                + " b. " + deposito2 + "\n"
                + " c. " + deposito3 + "\n"
                + " d. " + deposito4 + "\n");
        double montoDeposito;
        switch(teclado.getEntrada()) {
            case "a":
                montoDeposito = deposito1;
                break;
            case "b":
                montoDeposito = deposito2;
                break;
            case "c":
                montoDeposito = deposito3;
                break;
            case "d":
                montoDeposito = deposito4;
                break;
            default:
                montoDeposito = 0;
        }

        if(montoDeposito <= dispensador.getCantidadDinero()){
            baseDatos.depositarDinero(numeroCuenta, montoDeposito);
            dispensador.setCantidadDinero((int) (dispensador.getCantidadDinero() + montoDeposito));
        }

        pantalla.mostrarMensaje("Deposito Exitoso: \n"
                + "Id Cuenta: " + numeroCuenta + "\n"
                + "Deposito: " + montoDeposito + "\n"
                + "Saldo Diponible: " + baseDatos.getDineroDisponible(numeroCuenta) + "\n"
                + "Saldo Total: " + baseDatos.getSaldoTotal(numeroCuenta));
    }

}

