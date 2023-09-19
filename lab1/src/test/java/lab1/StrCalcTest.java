package lab1;

import static org.junit.jupiter.api.Assertions.*;
import Calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class StrCalcTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    void addition(){
        assertEquals(0, stringCalculator.add(""));
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(3, stringCalculator.add("1,2"));
    }
}