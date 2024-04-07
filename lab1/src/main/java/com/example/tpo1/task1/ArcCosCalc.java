package com.example.tpo1.task1;

public class ArcCosCalc {

    public static double mArcSin(double x0){
        double x = x0;
        if(x0 < 0){x =- x0;}
        double y = x;
        int n = 1;
        double sn = x;
        while (!(sn < 1E-7)) {
            sn = sn * (2 + 1.0 / n) * 0.5 * x * x;
            y = y + sn / (2 * n + 1) / (2 * n + 1);
            n = n + 1;
        }
        if(x0 < 0){y = -y;}
        return y;
    }

    public static Double calc(double x){
        if (x < -1 || x > 1){
            throw new IllegalArgumentException();
        } else if (x == 1) {
            return 0.0;
        } else if (x == -1){
            return Math.PI;
        }
        return Math.PI/2 - mArcSin(x);
    }
}


