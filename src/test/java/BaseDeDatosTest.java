import com.jda.BaseDeDatos;
import com.jda.CajeroAutomatico;
import com.jda.Cuenta;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class BaseDeDatosTest {
    private int numeroCuenta;
    private int dineroEsperado;

    BaseDeDatos baseDeDatos;

    @Test(timeout = 1)
    public void time_out_compararPin() {
        BaseDeDatos baseDatos = BaseDeDatos.getInstance();
        boolean actual = baseDatos.compararPin(1, 1234);
        assertTrue(actual);
    }

    @Parameterized.Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {1, 200},
                {2, 500},
                {3, 1000}
        });
    }

    public BaseDeDatosTest(int numeroCuenta, int dineroEsperado) {
        baseDeDatos = BaseDeDatos.getInstance();
        this.numeroCuenta = numeroCuenta;
        this.dineroEsperado = dineroEsperado;
    }

    @org.junit.Test
    public void get_int_SaldoTotal_with_numCount() {
        Cuenta cuentaMock = Mockito.mock(Cuenta.class);
        double expected = 100.0;
        Mockito.when(cuentaMock.getSaldoTotal()).thenReturn(expected);
        Mockito.when(cuentaMock.getNumCuenta()).thenReturn(1);
        BaseDeDatos baseDatos = new BaseDeDatos(new Cuenta[]{cuentaMock});
        double actual = baseDatos.getSaldoTotal(1);
        assertEquals(expected, actual, 0);

    }

    @org.junit.Test
    public void get_int_DineroDisponible_with_numCount() {
        double dineroObtenido = baseDeDatos.getDineroDisponible(numeroCuenta);
        assertEquals(dineroEsperado, dineroObtenido, 0);
    }

    @Test(timeout = 50)
    public void dataBase_assert_change_PIN(){
        BaseDeDatos baseDeDatos = BaseDeDatos.getInstance();
        boolean actual = baseDeDatos.cambiarPIN(1, 1359);
        assertTrue(actual);
    }

}