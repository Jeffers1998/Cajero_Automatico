import org.junit.Test;

public class TransaccionTest {

    @Test(expected = TransaccionInvalidaException.class)
    public void crearTransaccion_throw_exception_when_transaction_not_found()
    {
        Transaccion.crearTransaccion(-1, 1);
    }
}