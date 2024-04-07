package com.example.tpo1;

import com.example.tpo1.task1.ArcCosCalc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArcCosCalcTests {

    @Test
    void invalidRangeTest() {
        assertThrows(IllegalArgumentException.class, () -> ArcCosCalc.calc(-1.00001));
        assertThrows(IllegalArgumentException.class, () -> ArcCosCalc.calc(1.000001));
    }

    @ParameterizedTest
    @MethodSource("xyPair")
    void validRangeTest(double x, double y){
        assertEquals(String.format("%.5f", ArcCosCalc.calc(x)), String.format("%.5f", y));
    }

    static Stream<Arguments> xyPair() {
        return Stream.of(
                Arguments.of(-1, Math.PI),
                Arguments.of(-0.5, 2 * Math.PI/3),
                Arguments.of(0, Math.PI/2),
                Arguments.of(0.5, Math.PI/3),
                Arguments.of(0.8, 0.643501),
                Arguments.of(1, 0)
        );
    }
}
