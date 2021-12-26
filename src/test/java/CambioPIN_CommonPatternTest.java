import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class CambioPIN_CommonPatternTest {

    CambioPIN cambioPin;
    int pin;
    boolean expected;

    @Parameterized.Parameters
    public static Iterable<Object[]> parameters() {
        List<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{12345,true});
        objects.add(new Object[]{11111,true});
        objects.add(new Object[]{1555,true});
        objects.add(new Object[]{21745,false});
        objects.add(new Object[]{1384,false});
        objects.add(new Object[]{17289,false});
        return objects;
    }

    public CambioPIN_CommonPatternTest (int pin , boolean expected) {
        this.pin = pin;
        this.expected = expected;
    }

    @Test
    public void given_parameters_and_return_boolean () {
        cambioPin = new CambioPIN(1);
        boolean actual = cambioPin.tienePatronComun(pin);
        assertEquals(expected, actual);
    }

}