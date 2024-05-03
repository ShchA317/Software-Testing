package integration;

import com.example.lab2.primitives.Cos;
import com.example.lab2.primitives.Sin;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CosIntegrationTests {

    @ParameterizedTest
    @CsvSource({"0.0, 1.0", "1.5707963, 0.0", "3.1415926, -1", "-3.1415926, -1", "1.5707963, 0.0"})
    public void calcCosTest(double x, double y){
        Sin sin = new Sin();
        Cos cos = new Cos(sin::calcSin);

        assertEquals(y, cos.calcCos(BigDecimal.valueOf(x)).doubleValue(), 0.0001);
    }
}
