package com.example.lab2;

import java.math.BigDecimal;
import java.util.function.BiFunction;
import java.util.function.Function;

import static com.example.lab2.Common.ACCURACY;
import static com.example.lab2.Common.MC;

public class MySystemOfFunctions implements Function<BigDecimal, BigDecimal> {
    private final Function<BigDecimal, Double> sec;
    private final Function<BigDecimal, BigDecimal> tan;
    private final Function<BigDecimal, BigDecimal> ln;
    private final BiFunction<BigDecimal, Integer, BigDecimal> log;

    public MySystemOfFunctions(
            Function<BigDecimal, Double> sec,
            Function<BigDecimal, BigDecimal> tan,
            Function<BigDecimal, BigDecimal> ln,
            BiFunction<BigDecimal, Integer, BigDecimal> log){
        this.sec = sec;
        this.tan = tan;
        this.ln = ln;
        this.log = log;
    }

    @Override
    public BigDecimal apply(BigDecimal x) {

        if (x.doubleValue() <= 0){
            Double apply = sec.apply(x);
            if (apply.isNaN()) return null;
            var tanRes = tan.apply(x);
            if (tanRes.abs().doubleValue() < ACCURACY) return null;
            return BigDecimal.valueOf(apply)
                    .divide(tanRes, MC);
        } else {
            var lnRes = ln.apply(x);
            if(lnRes.abs().doubleValue() < ACCURACY){
                return null;
            }
            return ln.apply(x).pow(6).add(log.apply(x,5))
                    .divide(lnRes, MC)
                    .multiply(ln.apply(x));
        }
    }
}
