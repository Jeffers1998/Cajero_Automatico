import com.jda.BaseDeDatos;
import com.jda.CambioPIN;
import com.jda.GeneradorPIN;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CambioPINTest {

    @Test
    public void validarPin() {
        int numeroCuenta = 1;
        int pinValidar = 1234;

        BaseDeDatos baseDatos = Mockito.mock(BaseDeDatos.class);
        Mockito.when(baseDatos.compararPin(numeroCuenta, pinValidar)).thenReturn(true);
        CambioPIN cambioPIN = new CambioPIN(numeroCuenta, baseDatos, null);
        boolean actual = cambioPIN.validarPin(pinValidar);
        assertFalse(actual);
    }

    @Test
    public void generarPin() {
        GeneradorPIN generadorPin = Mockito.mock(GeneradorPIN.class);
        int expected = 1178;
        Mockito.when(generadorPin.generar()).thenReturn(expected);
        CambioPIN cambioPIN = new CambioPIN(1, null, generadorPin);
        int actual = cambioPIN.generarPin();
        assertEquals(expected, actual);
    }
}