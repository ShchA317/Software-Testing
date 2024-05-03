package com.example.lab2.module;

import com.example.lab2.primitives.Cos;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcCosModuleTests {

    @Test
    public void calcCosEqSinTest(){
        Function<BigDecimal, BigDecimal> mockedSin = (e) -> BigDecimal.ZERO;
        Cos cos = new Cos(mockedSin);

        assertEquals(cos.calcCos(BigDecimal.ONE), mockedSin.apply(BigDecimal.ONE));
    }

    @Test
    public void calcCosTest(){
        Function<BigDecimal, BigDecimal> mockedSin = (e) -> e;
        Cos cos = new Cos(mockedSin);

        assertEquals(cos.calcCos(BigDecimal.ZERO).doubleValue(), Math.PI / 2, 0.00000001);
    }
}
