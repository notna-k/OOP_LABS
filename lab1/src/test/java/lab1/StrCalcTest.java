package lab1;

import static org.junit.jupiter.api.Assertions.*;
import Calculator.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class StrCalcTest {
    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    void addition(){
        //"have-not-to-work" block
        try {
            assertEquals(Integer.MIN_VALUE, stringCalculator.add("//[;]\n-123;23;4;1"));

        } catch(Exception e){
            System.out.println(e);
        }

        try {
            assertEquals(100, stringCalculator.add("//[0][space]\n25075space0"));

        } catch(Exception e){
            System.out.println(e);
        }




        assertEquals(0, stringCalculator.add(""));
        assertEquals(1, stringCalculator.add("1"));
        assertEquals(3, stringCalculator.add("1,2"));
        assertEquals(161, stringCalculator.add("1,2,3,55,100"));
        assertEquals(81, stringCalculator.add("21,4\n33,23"));
        assertEquals(40, stringCalculator.add("23\n17"));

        assertEquals(10, stringCalculator.add("//[;]\n1;2;3;4"));
        assertEquals(20, stringCalculator.add("//[/]\n5/5/10"));


        assertEquals(200, stringCalculator.add("//[;]\n55;105;10000;40"));


        assertEquals(30, stringCalculator.add("//[j][;][,]\n1j2j3;4,5,5;10"));
        assertEquals(330, stringCalculator.add("//[m][;][,][j]\n1j2j3;4,5,5;10m100m200"));

        assertEquals(125, stringCalculator.add("//[space][jj][;]\n1;2jj3space4;5jj10space100"));






    }
}