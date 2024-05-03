package com.example.lab2;

import com.example.lab2.primitives.Sin;

import java.io.IOException;
import java.math.BigDecimal;

public class Lab2 {
    public static void main(String[] args) throws IOException {
        Sin sin = new Sin();
        CsvWriter.write("sin-result.csv", sin::calcSin, BigDecimal.valueOf(-1), BigDecimal.valueOf(1), BigDecimal.valueOf(0.1) );
    }
}
