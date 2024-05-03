package com.example.lab2.module;

import com.example.lab2.primitives.Sin;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcSinModuleTests {

    @ParameterizedTest
    @ValueSource(doubles = {(-3 * (Math.PI/2)), -Math.PI, 0, 0.1, -1, -0.5, -0.75, -1.0 })
    public void testCalcSin(double x) {
        Sin sin = new Sin();
        assertEquals(Math.sin(x), sin.calcSin(BigDecimal.valueOf(x)).doubleValue(), 0.0000001);
    }
}
