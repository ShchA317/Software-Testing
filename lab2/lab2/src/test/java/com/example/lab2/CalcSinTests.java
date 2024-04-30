package com.example.lab2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static com.example.lab2.BaseCalc.ACCURACY;
import static com.example.lab2.BaseCalc.calcSin;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcSinTests {

    @ParameterizedTest
    @ValueSource(doubles = {(-3 * (Math.PI/2)), -Math.PI, 0, 0.1, -1, -0.5, -0.75, -1.0 })
    public void testCalcSin(double x) {
        assertEquals(Math.sin(x), calcSin(BigDecimal.valueOf(x)).doubleValue(), ACCURACY);
    }
}
