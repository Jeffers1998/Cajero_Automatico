import com.jda.GeneradorPIN;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
public class GeneradorPINTest {

    @Test
    public void generar_int_four_numbers() {
        GeneradorPIN generadorPin = new GeneradorPIN();
        int actual = generadorPin.generar();
        assertThat(actual, new BaseMatcher<Integer>() {
            @Override
            public boolean matches(Object o) {
                int numero = (int) o;
                int cifras = 0;
                while(numero != 0){
                    numero = numero/10;
                    cifras++;
                }

                return cifras == 4;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("El pin generado debe tener cuatro cifras");
            }
        });
    }
}