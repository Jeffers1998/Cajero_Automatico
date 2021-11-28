import com.jda.Transaccion;
import com.jda.TransaccionInvalidaException;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransaccionTest {

    @Test(expected = TransaccionInvalidaException.class)
    public void crearTransaccion() {
        Transaccion.crearTransaccion(-1, 1);
    }
}