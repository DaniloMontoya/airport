package co.com.ceiba.airport.domain;

import org.junit.Assert;

import java.util.function.Supplier;

import static org.junit.Assert.fail;

public class BaseTest {

    private static final String PERO_FUE_LANZADA = " Pero fue lanzada ";
    private static final String SE_ESPERABA_LA_EXCEPCION = "Se esperaba la excepcion ";

    public static <T> void assertThrows(Supplier<T> supplier, Class<? extends Exception> exception, String message) {
        try {
            supplier.get();
            fail();
        } catch (Exception e) {
            Assert.assertTrue(SE_ESPERABA_LA_EXCEPCION + exception.getCanonicalName() + PERO_FUE_LANZADA
                    + e.getClass().getCanonicalName(), exception.isInstance(e));
            Assert.assertTrue(e.getMessage().contains(message));
        }
    }
}
