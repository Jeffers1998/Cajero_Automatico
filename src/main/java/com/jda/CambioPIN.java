package com.jda;

public class CambioPIN extends Transaccion{
    private Pantalla pantalla;
    private Teclado teclado;
    private BaseDeDatos baseDatos;
    private GeneradorPIN generadorPIN;

    public CambioPIN(int numeroCuenta) {
        super(numeroCuenta);
        pantalla = Pantalla.getInstance();
        teclado = Teclado.getInstance();
        baseDatos = BaseDeDatos.getInstance();
    }

    public CambioPIN(int numeroCuenta, BaseDeDatos baseDatos, GeneradorPIN generadorPIN) {
        super(numeroCuenta);
        this.baseDatos = baseDatos;
        this.generadorPIN = generadorPIN;
    }

    @Override
    public void realizar() {

    }

    public int obtenerLongitud(int pin){
        String nuevoPin = pin+"";
        return nuevoPin.length();
    }

    public boolean tienePatronComun(int pin){
        
        String pinString = String.valueOf(pin);
        String[] pinArray = pinString.split("(?<=.)");

        int[] valores = new int[pinArray.length];

        for(int i = 0; i < valores.length; i++){
            valores[i] = Integer.parseInt(pinArray[i]);
        }

        for(int i = 2; i < valores.length; i++) {
            if (valores[i - 2] == valores[i] && valores[i - 1] == valores[i]) {
                return true;
            }
        }
        for(int i = 2; i < valores.length; i++) {
            if ( (valores[i] == valores[i - 1] + 1 && valores[i - 1] + 1 == valores[i - 2] + 2)
            || (valores[i] == valores[i-1] - 1 && valores[i - 1] == valores[i - 2] - 2)) {
                return true;
            }
        }
        return false;
    }

    public boolean validarPin(int pin){
        if (!baseDatos.compararPin(numeroCuenta, pin)) {
            if (!tienePatronComun(pin) && obtenerLongitud(pin) >= 4) {
                return true;
            }
        }
        return false;
    }

    public int generarPin(){
        return generadorPIN.generar();
    }
}
