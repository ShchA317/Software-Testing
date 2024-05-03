package com.example.lab2;

import com.example.lab2.primitives.*;

import java.io.IOException;
import java.math.BigDecimal;

public class Lab2 {
    public static void main(String[] args) throws IOException {
        Sin sin = new Sin();
        CsvWriter.write("sin-result.csv", sin::calcSin, BigDecimal.valueOf(-1), BigDecimal.valueOf(1), BigDecimal.valueOf(0.1) );

        Cos cos = new Cos(sin::calcSin);
        CsvWriter.write("cos-result.csv", cos::calcCos, BigDecimal.valueOf(-1), BigDecimal.valueOf(1), BigDecimal.valueOf(0.1) );

        Sec sec = new Sec(cos::calcCos);
        CsvWriter.write("sec-result.csv", x -> BigDecimal.valueOf(sec.calcSec(x)), BigDecimal.valueOf(-1), BigDecimal.valueOf(1), BigDecimal.valueOf(0.1) );

        Tan tan = new Tan(sin::calcSin, cos::calcCos);
        CsvWriter.write("tan-result.csv", tan::calcTan, BigDecimal.valueOf(-1), BigDecimal.valueOf(1), BigDecimal.valueOf(0.1) );

        Ln ln = new Ln();
        CsvWriter.write("ln-result.csv", ln::calcLn, BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(0.1) );

        Log log = new Log(ln::calcLn);
        CsvWriter.write("log-result.csv", x -> log.calcLog(x, 10), BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(0.1) );

        MySystemOfFunctions mySystemOfFunctions = new MySystemOfFunctions(sec::calcSec, tan::calcTan, ln::calcLn, log::calcLog);
        CsvWriter.write("mySystem-result.csv", mySystemOfFunctions, BigDecimal.valueOf(-10), BigDecimal.valueOf(10), BigDecimal.valueOf(0.5) );
    }
}
