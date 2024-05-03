package integration;

import com.example.lab2.primitives.Cos;
import com.example.lab2.primitives.Sin;
import com.example.lab2.primitives.Tan;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TanIntegrationTests {

    @ParameterizedTest
    @CsvSource({"0.0, 0.0", "1.0, 1.0", "2.0, 2.0"})
    public void calcIntegrationSinTest(double x, double y){
        Sin sin = new Sin();
        Tan tan = new Tan(sin::calcSin, e -> BigDecimal.valueOf(1));

        assertEquals(y, tan.calcTan(BigDecimal.valueOf(x)).doubleValue(), 0.001);
    }

    @ParameterizedTest
    @ValueSource( doubles = {1.0, 2.0, 3.0})
    public void calcIntegrationCosTest(double x){
        Sin sin = new Sin();
        Cos cos = new Cos(sin::calcSin);
        Tan tan = new Tan(e -> BigDecimal.valueOf(1), cos::calcCos);

        assertEquals(sin.calcSin(BigDecimal.valueOf(x)).doubleValue(), tan.calcTan(BigDecimal.valueOf(x)).doubleValue(), 0.001);
    }

    @ParameterizedTest
    @CsvSource({"0.0, 0.0", "1.0, 1.557", "2.0, -2.185"})
    public void calcTanTest(double x, double y){
        Sin sin = new Sin();
        Cos cos = new Cos(sin::calcSin);
        Tan tan = new Tan(sin::calcSin, cos::calcCos);

        assertEquals(y, tan.calcTan(BigDecimal.valueOf(x)).doubleValue(), 0.001);
    }
}
