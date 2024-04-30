package com.example.lab2;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.function.BiFunction;
import java.util.function.Function;

public class BaseCalc {
    public final static double ACCURACY = 0.000000001;
    public final static double LOG_ACCURACY = 0.000001;
    public final static double ACCURACY_FOR_PRIMITIVES = 0.0000000001;
    public final static MathContext MC_ACCURACY_FOR_PRIMITIVES = new MathContext(10);

    public static BigDecimal calcSin(BigDecimal x) {
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal prev;
        int i = 0;

        do {
            prev = sum;
            sum = sum.add(BigDecimal.valueOf(minusOnePower(i)).multiply(prod(x, 2 * i + 1)));
            ++i;
        } while (BigDecimal.valueOf(ACCURACY_FOR_PRIMITIVES).compareTo(prev.subtract(sum).abs()) <= 0);

        return sum.round(MC_ACCURACY_FOR_PRIMITIVES);
    }

    private static BigDecimal prod(BigDecimal x, int n) {
        BigDecimal buf = BigDecimal.ONE.setScale(10, RoundingMode.HALF_EVEN);

        for (int i = 1; i <= n; i++) {
            buf = buf.multiply(x.divide(BigDecimal.valueOf(i), MathContext.DECIMAL128));
        }

        return buf;
    }

    public static BigDecimal calcCos(BigDecimal x, Function<BigDecimal, BigDecimal> sin) {
        return sin.apply(x.add(new BigDecimal(Math.PI / 2))).round(MC_ACCURACY_FOR_PRIMITIVES);
    }

    public static Double calcSec(BigDecimal x, BiFunction<BigDecimal, Function<BigDecimal, BigDecimal>, BigDecimal> cos, Function<BigDecimal, BigDecimal> sin) {
        BigDecimal term1 = cos.apply(x, sin);
        if (term1.doubleValue() < ACCURACY_FOR_PRIMITIVES) {
            return Double.NaN;
        }
        return new BigDecimal("1.0").setScale(10, RoundingMode.HALF_EVEN).divide(term1, RoundingMode.HALF_EVEN).doubleValue();
    }

    private static int minusOnePower(int n) {
        return (int) Math.pow(-1, n);
    }

    public static BigDecimal calcLn(BigDecimal x) {
        if (x.compareTo(BigDecimal.ZERO) <= 0)
            return null;

        BigDecimal current = BigDecimal.ZERO;
        BigDecimal prev;
        int iter = 1;

        int MAX_ITERATIONS = 500000;
        if (x.subtract(BigDecimal.ONE).abs().compareTo(BigDecimal.ONE) <= 0) {
            do {
                prev = current;
                BigDecimal term = BigDecimal.valueOf(Math.pow(-1, iter - 1))
                        .multiply(BigDecimal.valueOf(Math.pow(x.subtract(BigDecimal.ONE).doubleValue(), iter)))
                        .divide(BigDecimal.valueOf(iter), MathContext.DECIMAL128);
                current = current.add(term);
                iter++;
            } while (
                    BigDecimal.valueOf(ACCURACY_FOR_PRIMITIVES).compareTo(current.subtract(prev).abs()) <= 0
                            && iter < MAX_ITERATIONS
            );
        } else {
            do {
                prev = current;
                BigDecimal term = BigDecimal.valueOf(Math.pow(-1, iter - 1))
                        .multiply(BigDecimal.valueOf(Math.pow(x.subtract(BigDecimal.ONE).doubleValue(), -iter)))
                        .divide(BigDecimal.valueOf(iter), MathContext.DECIMAL128);
                current = current.add(term);
                iter++;
            } while (BigDecimal.valueOf(ACCURACY_FOR_PRIMITIVES).compareTo(current.subtract(prev).abs()) <= 0 && iter < MAX_ITERATIONS);

            current = current.add(calcLn(x.subtract(BigDecimal.ONE)));
        }

        return current;
    }

    public static BigDecimal calcLog(BigDecimal x, BigDecimal base, Function<BigDecimal, BigDecimal> ln) {
        if(base.doubleValue() <= 1.0) throw new IllegalArgumentException();

        BigDecimal term1 = ln.apply(base);
        if (term1 == null)
            return null;
        BigDecimal term2 = calcLn(x);
        if (term2 == null)
            return null;

        return term2.setScale(10, RoundingMode.HALF_EVEN).divide(term1.setScale(10, RoundingMode.HALF_EVEN), RoundingMode.HALF_EVEN);
    }
}
