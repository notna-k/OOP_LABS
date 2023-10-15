package org.lab2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.lab2.Matrix.Matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixTest {


    @Test
    void emptyMatrixTest(){
        Matrix matrix = new Matrix();
        String expectedBodyStr = Arrays.deepToString(new double[0][0]);
        String actualBodyStr = Arrays.deepToString(matrix.getBody());
        Assertions.assertEquals(expectedBodyStr, actualBodyStr);
    }

    @Test
    void definedSizeMatrixTest(){
        Matrix matrix = new Matrix(3,3);
        double[][] expectedBody = {
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0}
        };
        String expectedBodyStr = Arrays.deepToString(expectedBody);
        String actualBodyStr = Arrays.deepToString(matrix.getBody());
        Assertions.assertEquals(expectedBodyStr, actualBodyStr);
    }

    @Test
    void copiedMatrixTest(){
        double[][] matrixBody = {
                {0.1, 0.23, 223.2, 23.0},
                {12.2, 23.1, 34.2, 0.001}
        };

        Matrix matrix = new Matrix(matrixBody);

        int givenRows = matrixBody.length;
        int givenColumns = matrixBody[0].length;

        String actualBodyStr = Arrays.deepToString(matrixBody);
        String expectedBodyStr = Arrays.deepToString(matrix.getBody());

        int actualColumns = matrix.getColumns();
        int actualRows = matrix.getRows();


        Assertions.assertEquals(expectedBodyStr, actualBodyStr);
        Assertions.assertEquals(givenColumns, actualColumns);
        Assertions.assertEquals(givenRows, actualRows);
    }



}
