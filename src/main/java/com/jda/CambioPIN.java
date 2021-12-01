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
        int nuevoPIN;
        boolean pinCambiado;
        pantalla.mostrarMensaje("a. Ingresar PIN\n" +
                                "b. Generar PIN automáticamente\n" +
                                " --- Presione cualquier otra tecla para volver a el menú de opciones ---");
        String eleccion = teclado.getEntrada();
        switch (eleccion){
            case "a":
                pantalla.mostrarMensaje("Por favor escriba su nuevo PIN");
                nuevoPIN = Integer.parseInt(teclado.getEntrada());
                if ( validarPin(nuevoPIN)){
                    pinCambiado = baseDatos.cambiarPIN(numeroCuenta, nuevoPIN);
                    if (pinCambiado) {
                        pantalla.mostrarMensaje("**** Su PIN ha cambiado Exitosamente ****");
                    } else {
                        pantalla.mostrarMensaje("Error en la base de datos, no se ha completado cambio PIN");
                    }

                }else {
                    pantalla.mostrarMensaje("El PIN ingresado no puede ser aceptado, recuerde\n" +
                            "- Usar solo 4 dígitos\n" +
                            "- No usar patrones comunes como 1234 o 1111\n" +
                            "- No ingresar el mismo PIN que ya utiliza\n");
                }
                break;
            case "b":
                nuevoPIN = generadorPIN.generar();
                pinCambiado = baseDatos.cambiarPIN(numeroCuenta, nuevoPIN);
                if (pinCambiado) {
                    pantalla.mostrarMensaje("Su nuevo PIN es: " + nuevoPIN);
                } else {
                    pantalla.mostrarMensaje("Error en la base de datos no se ha completado cambio PIN");
                }

                break;
            default:
                break;
        }



    }

    public int obtenerLongitud(int pin){
        String nuevoPin = pin+"";
        return nuevoPin.length();
    }

    public boolean tienePatronComun(int pin){
        
        String pinString = String.valueOf(pin);
        String[] pinArray = pinString.split("(?<=.)");
        int[] miPinArray = getArrayInt(pinArray);

        for(int i = 2; i < miPinArray.length; i++) {
            if ( isTresNumeroSeguidoIguales(miPinArray,i)) {
                return true;
            }
        }
        for(int i = 2; i < miPinArray.length; i++) {
            if ( tresNumSecuenciaAscendente(miPinArray,i) || tresNumSecuenciaDescendente(miPinArray,i)) {
                return true;
            }
        }
        return false;
    }
    private boolean isTresNumeroSeguidoIguales(int miPinArray[], int index ) {
        boolean esIgualUltimo = miPinArray[index - 2] == miPinArray[index];
        boolean esIgualPenultimo = miPinArray[index - 1] == miPinArray[index];
        return esIgualUltimo && esIgualPenultimo;
    }
    private boolean tresNumSecuenciaDescendente(int array[], int index){
        boolean precedeUltimo = array[index] == array[index-1] - 1;
        boolean ultimoPrecedePenultimo = array[index - 1] == array[index-2] - 2;
        return precedeUltimo && ultimoPrecedePenultimo;
    }
    private boolean tresNumSecuenciaAscendente(int array[], int index){
        boolean esSecuenciaDelUltimo = array[index] == array[index - 1] + 1;
        boolean esSecuenciaDelPenultimo = array[index - 1] + 1 == array[index - 2] + 2;
        return esSecuenciaDelUltimo && esSecuenciaDelPenultimo;
    }
    private int [] getArrayInt(String[] pinArray){
        int[] valores = new int[pinArray.length];
        for(int i = 0; i < valores.length; i++){
            valores[i] = Integer.parseInt(pinArray[i]);
        }
        return valores;
    } 

    public boolean validarPin(int pin){
        if (!baseDatos.compararPin(numeroCuenta, pin)) {
            return !tienePatronComun(pin) && obtenerLongitud(pin) == 4;
        }
        return false;
    }

    public int generarPin(){
        return generadorPIN.generar();
    }
}
