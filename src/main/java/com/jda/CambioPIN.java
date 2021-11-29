package com.jda;

public class CambioPIN extends Transaccion{
    private Pantalla pantalla;
    private Teclado teclado;
    private final BaseDeDatos baseDatos;
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
        pantalla.mostrarMensaje("Por favor escriba su nuevo PIN");
        int nuevoPIN = Integer.parseInt(teclado.getEntrada());

        if ( validarPin(nuevoPIN)){
            baseDatos.cambiarPIN(numeroCuenta, nuevoPIN);
            pantalla.mostrarMensaje("**** Su PIN ha cambiado Exitosamente ****");
        }else {
            pantalla.mostrarMensaje("El PIN ingresado no puede ser aceptado, recuerde\n" +
                    "- Usar solo 4 dígitos\n" +
                    "- No usar patrones comunes como 1234 o 1111\n" +
                    "- No ingresar el mismo PIN que ya utiliza\n");
        }
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

    public boolean validarPin(int pin){ // puede ser una refactorización
        if (!baseDatos.compararPin(numeroCuenta, pin)) {
            return !tienePatronComun(pin) && obtenerLongitud(pin) >= 4;
        }
        return false;
    }

    public int generarPin(){
        return generadorPIN.generar();
    }
}
