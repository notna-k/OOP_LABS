package org.lab2;

import org.junit.jupiter.api.Test;
import org.lab2.Matrix.GMatrix;

public class GMatrixTest {
    @Test
    void addGmatrixTest(){
        String[][] body = {
                {"la", "al"},
                {"oy", "f"},
        };
        String[][] body2 = {
                {"la", "al"},
                {"oy", "f"},
        };
        String[][] expected = {
                {"lala", "alal"},
                {"oyoy", "ff"},
        };
        GMatrix matrix = new GMatrix(body);
        GMatrix matrix2 = new GMatrix(body2);
        GMatrix matrix3 = new GMatrix(expected);
        matrix.add(matrix2);
        matrix.printMatrix();
        matrix3.printMatrix();

    }
}
