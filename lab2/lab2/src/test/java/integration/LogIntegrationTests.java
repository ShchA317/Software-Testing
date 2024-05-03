package integration;

import com.example.lab2.primitives.Ln;
import com.example.lab2.primitives.Log;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogIntegrationTests {

    @ParameterizedTest
    @CsvSource({"5,1", "25,2"})
    public void calcCosTest(double x, double y){
        Ln ln = new Ln();
        Log log = new Log(ln::calcLn);

        assertEquals(y, log.calcLog(BigDecimal.valueOf(x), 5).doubleValue(), 0.0001);
    }
}
