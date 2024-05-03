package com.example.lab2.primitives;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

import static com.example.lab2.Common.ACCURACY;

public class Sec {
    private final Function<BigDecimal, BigDecimal> cos;

    public Sec(Function<BigDecimal, BigDecimal> cos) {
        this.cos = cos;
    }

    public Double calcSec(BigDecimal x) {
        BigDecimal term1 = cos.apply(x);
        if (term1.doubleValue() < ACCURACY) {
            return Double.NaN;
        }
        return new BigDecimal("1.0").setScale(10, RoundingMode.HALF_EVEN).divide(term1, RoundingMode.HALF_EVEN).doubleValue();
    }
}
