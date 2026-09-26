import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    temperatureConverter t = new temperatureConverter();

    @org.junit.jupiter.api.Test
    void fahrenheitToCelsius() {

        assertEquals(37.77777777777778, t.fahrenheitToCelsius(100), "Should be 37.7777777778");
        assertEquals(-12.222222222222221, t.fahrenheitToCelsius(10), "Should be -12");
    }

    @org.junit.jupiter.api.Test
    void celsiusToFahrenheit() {
        assertEquals(104, t.celsiusToFahrenheit(40),"Should be 104");
        assertEquals(-22, t.celsiusToFahrenheit(-30),"Should be -22");
    }

    @org.junit.jupiter.api.Test
    void isExtremeTemperature() {
        assertTrue(t.isExtremeTemperature(-41),"Should return true (-41)");
        assertTrue(t.isExtremeTemperature(51),"Should return true (51)");
        assertFalse(t.isExtremeTemperature(30),"Should return false (30)");
        assertFalse(t.isExtremeTemperature(-12),"Should return false (-12)");
    }
}