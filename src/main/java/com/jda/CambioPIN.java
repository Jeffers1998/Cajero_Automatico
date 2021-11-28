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
        return -1;
    }

    public boolean tienePatronComun(int pin){
        return true;
    }

    public boolean validarPin(int pin){
        return false;
    }

    public int generarPin(){
        return -1;
    }
}
