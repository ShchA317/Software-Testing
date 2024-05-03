package system;

import com.example.lab2.*;
import com.example.lab2.primitives.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MySystemOfFunctionsTests {
    MySystemOfFunctions mySystemOfFunctions;

    @BeforeEach
    public void init(){
        Sin sin = new Sin();
        Cos cos = new Cos(sin::calcSin);
        Sec sec = new Sec(cos::calcCos);
        Tan tan = new Tan(sin::calcSin, cos::calcCos);
        Ln ln = new Ln();
        Log log = new Log(ln::calcLn);

        mySystemOfFunctions = new MySystemOfFunctions(sec::calcSec, tan::calcTan, ln::calcLn, log::calcLog);
    }

    @Test
    public void test(){
        assertEquals(mySystemOfFunctions.apply(BigDecimal.valueOf(-5)).doubleValue(), 1.0, 0.1);
    }
}
