package com.example.lab2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static com.example.lab2.BaseCalc.*;
import static org.junit.jupiter.api.Assertions.*;

public class BaseCalcIntegrationTests {

    @ParameterizedTest
    @ValueSource(doubles = {(-3 * (Math.PI/2)), -Math.PI, 0, 0.1, -0.5, -0.75, -1.0 })
    public void testCalcCosIntegration(double x) {
        assertEquals(Math.cos(x), calcCos(BigDecimal.valueOf(x), BaseCalc::calcSin).doubleValue(), ACCURACY);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 0, -0.5, -0.75, -1.0 })
    public void testCalcSec(double x) {
        double expected = 1 / Math.cos(x);
        double actual = calcSec(new BigDecimal(x), BaseCalc::calcCos, BaseCalc::calcSin);
        assertEquals(expected, actual, ACCURACY);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI / 2, Math.PI / 2, 3 * Math.PI / 2, -5 * Math.PI / 2 })
    public void testCalcSecNans(double x) {
        assertEquals(Double.NaN, calcSec(BigDecimal.valueOf(x), BaseCalc::calcCos, BaseCalc::calcSin));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.1, 1 / Math.E, 0.5, 1, Math.E, Math.E * Math.E})
    public void testValues(double x) {
        assertEquals(Math.log(x), calcLn(BigDecimal.valueOf(x)).doubleValue(), ACCURACY);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, 0, -0.2})
    public void testNullsLn(double x) {
        assertNull(calcLn(BigDecimal.valueOf(x)));
    }

    @ParameterizedTest(name = "testPositiveSmall")
    @ValueSource(doubles = {0.1, 10, 100, 1000})
    public void testPositiveSmall(double x) {
        assertEquals(Math.log10(x), calcLog(BigDecimal.valueOf(x), BigDecimal.TEN, BaseCalc::calcLn).doubleValue(), LOG_ACCURACY);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -2, 0, 1})
    public void testThrows(double base) {
        assertThrows(IllegalArgumentException.class, () ->
            calcLog(BigDecimal.TEN, BigDecimal.valueOf(base), BaseCalc::calcLn)
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -2, -500, -0.0001, 0})
    public void testNulls(double x) {
        assertNull(calcLog(BigDecimal.valueOf(x), BigDecimal.valueOf(2), BaseCalc::calcLn));
        assertNull(calcLog(BigDecimal.valueOf(x), BigDecimal.valueOf(5), BaseCalc::calcLn));
    }

}
