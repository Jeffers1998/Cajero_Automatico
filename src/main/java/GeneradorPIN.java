import java.util.Random;

public class GeneradorPIN {
    private Random random;
    private int numeroDigitos;
    public GeneradorPIN(){
        random = new Random();
        numeroDigitos = 4;
    }

    public int generar(){
        int[] arregloPin = new int[numeroDigitos];
        arregloPin[0] = random.nextInt(10);
        for(int i = 1; i < arregloPin.length; i++){
            int nuevoDigito = 0;
            int digitoPrevio = arregloPin[i - 1];
            while(nuevoDigito == digitoPrevio || sonNumerosSeguidos(nuevoDigito, digitoPrevio)){
                nuevoDigito = random.nextInt(10);
            }

            arregloPin[i] = nuevoDigito;
        }

        return juntarNumeros(arregloPin);
    }

    private boolean sonNumerosSeguidos(int num1, int num2){
        return Math.abs(num1 - num2) == 1;
    }

    private int juntarNumeros(int ...numeros){
        String cadenaNumeros = "";

        for(int digito : numeros)
            cadenaNumeros += Integer.toString(digito);

        return Integer.parseInt(cadenaNumeros);
    }



}
