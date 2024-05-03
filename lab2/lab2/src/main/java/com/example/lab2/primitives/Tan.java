package com.example.lab2.primitives;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

public class Tan {

    private final Function<BigDecimal, BigDecimal> calcSin;
    private final Function<BigDecimal, BigDecimal> calcCos;

    public Tan(Function<BigDecimal, BigDecimal> calcSin, Function<BigDecimal, BigDecimal> calcCos) {
        this.calcSin = calcSin;
        this.calcCos = calcCos;
    }

    public BigDecimal calcTan(BigDecimal x){
        return calcSin.apply(x).divide(calcCos.apply(x), RoundingMode.CEILING);
    }
}
