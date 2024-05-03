package com.example.lab2.primitives;

import java.math.BigDecimal;
import java.util.function.Function;

import static com.example.lab2.Common.MC;

public class Cos {
    private final Function<BigDecimal, BigDecimal> sin;

    public Cos(Function<BigDecimal, BigDecimal> sin) {
        this.sin = sin;
    }

    public BigDecimal calcCos(BigDecimal x) {
        return sin.apply(x.add(new BigDecimal(Math.PI / 2))).round(MC);
    }
}
