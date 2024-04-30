package com.example.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static com.example.lab2.BaseCalc.calcCos;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcCosModuleTests {

    private BigDecimal calcSinMock(BigDecimal x){
        return
                switch (x.intValue()) {
                    case 1 -> BigDecimal.valueOf(0.8414709848);
                    case 2 -> BigDecimal.valueOf(0.90929742682);
                    case -1 -> BigDecimal.valueOf(-0.8414709848);
                    case -4 -> BigDecimal.valueOf(0.7568024953);
                    default -> throw new IllegalArgumentException("this is mock. it is stupid");
        };
    }

    @Test
    public void calcCosTest(){
        assertEquals(0.54030230586, calcCos(BigDecimal.valueOf(1), this::calcSinMock));
    }
}
