package com.example.lab2.primitives;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static com.example.lab2.Common.ACCURACY;
import static com.example.lab2.Common.MC;

public class Sin {
    public BigDecimal calcSin(BigDecimal x) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal prev;
        int i = 0;

        do {
            prev = sum;
            sum = sum.add(BigDecimal.valueOf(minusOnePower(i)).multiply(prod(x, 2 * i + 1)));
            ++i;
        } while (BigDecimal.valueOf(ACCURACY).compareTo(prev.subtract(sum).abs()) <= 0);

        return sum.round(MC);
    }

    private BigDecimal prod(BigDecimal x, int n) {
        BigDecimal buf = BigDecimal.ONE.setScale(10, RoundingMode.HALF_EVEN);

        for (int i = 1; i <= n; i++) {
            buf = buf.multiply(x.divide(BigDecimal.valueOf(i), MathContext.DECIMAL128));
        }

        return buf;
    }

    private int minusOnePower(int n) {
        return (int) Math.pow(-1, n);
    }
}
