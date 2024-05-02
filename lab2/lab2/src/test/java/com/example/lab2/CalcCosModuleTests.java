package com.example.lab2;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.example.lab2.BaseCalc.calcCos;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcCosModuleTests {

    @Test
    public void calcCosTest(){
        assertEquals(BigDecimal.ZERO, calcCos(BigDecimal.valueOf(1), (e) -> BigDecimal.ZERO));
    }
}
