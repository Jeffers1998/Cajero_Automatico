import com.jda.CambioPIN;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class CambioPINParametrosLongTest {

    CambioPIN cambioPin;
    int pin, expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{12,2});
        objects.add(new Object[]{147158,6});
        objects.add(new Object[]{10721,5});
        objects.add(new Object[]{1791,4});
        objects.add(new Object[]{1384,4});
        objects.add(new Object[]{17289,5});
        return objects;
    }

    public CambioPINParametrosLongTest(int pin, int expected) {
        this.pin = pin;
        this.expected = expected;
    }


    @Test
    public void given_parameters_and_return_long () {
        cambioPin = new CambioPIN(1);
        int actual = cambioPin.obtenerLongitud(pin);
        assertEquals(expected, actual);
    }

}