package com.example.lab2.module;

import com.example.lab2.primitives.Sec;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcSecModuleTests {

    private static final double delta = 0.0000001;

    @Test
    public void calcSecOneTest(){
        Function<BigDecimal, BigDecimal> mockedCos = (e) -> BigDecimal.ONE;
        Sec sec = new Sec(mockedCos);

        assertEquals(sec.calcSec(BigDecimal.ZERO), 1.0, delta);
    }

    @Test
    public void calcSecNanTest(){
        Function<BigDecimal, BigDecimal> mockedCos = (e) -> BigDecimal.ZERO;
        Sec sec = new Sec(mockedCos);

        assertEquals(sec.calcSec(BigDecimal.ONE), Double.NaN, delta);
    }

    @Test
    public void calcSecTest(){
        Function<BigDecimal, BigDecimal> mockedCos = (e) -> BigDecimal.TEN;
        Sec sec = new Sec(mockedCos);

        assertEquals(sec.calcSec(BigDecimal.ZERO), 0.10, delta);
    }
}
