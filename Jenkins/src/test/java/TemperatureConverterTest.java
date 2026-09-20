import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    temperatureConverter t = new temperatureConverter();

    @Test
    void fahrenheitToCelsius() {

        assertEquals(37.77777777777778, t.fahrenheitToCelsius(100), "Should be 37.7777777778");
        assertEquals(-12.222222222222221, t.fahrenheitToCelsius(10), "Should be -12");
    }

    @Test
    void celsiusToFahrenheit() {
        assertEquals(104, t.celsiusToFahrenheit(40),"Should be 104");
        assertEquals(-22, t.celsiusToFahrenheit(-30),"Should be -22");
    }

    @Test
    void kelvinToCelsius(){
        assertEquals(26.850000000000023, t.kelvinToCelsius(300),"Should be 26.85");
        assertEquals(-23.149999999999977, t.kelvinToCelsius(250),"Should be -23.15");
    }

    @Test
    void isExtremeTemperature() {
        assertTrue(t.isExtremeTemperature(-41),"Should return true (-41)");
        assertTrue(t.isExtremeTemperature(51),"Should return true (51)");
        assertFalse(t.isExtremeTemperature(30),"Should return false (30)");
        assertFalse(t.isExtremeTemperature(-12),"Should return false (-12)");
    }
}