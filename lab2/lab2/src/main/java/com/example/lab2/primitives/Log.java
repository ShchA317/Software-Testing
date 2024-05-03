package com.example.lab2.primitives;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;


public class Log {

    private final Function<BigDecimal, BigDecimal> calcLn;

    public Log(Function<BigDecimal, BigDecimal> calcLn) {
        this.calcLn = calcLn;
    }

    public BigDecimal calcLog(BigDecimal x, Integer base) {
        if(base.doubleValue() <= 1.0) throw new IllegalArgumentException();

        BigDecimal term1 = calcLn.apply(BigDecimal.valueOf(base));
        if (term1 == null)
            return null;
        BigDecimal term2 = calcLn.apply(x);
        if (term2 == null)
            return null;

        return term2.setScale(10, RoundingMode.HALF_EVEN).divide(term1.setScale(10, RoundingMode.HALF_EVEN), RoundingMode.HALF_EVEN);
    }
}
