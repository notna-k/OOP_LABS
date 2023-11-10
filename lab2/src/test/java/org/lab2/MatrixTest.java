package org.lab2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.lab2.Matrix.Matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixTest {


    @Test
    void emptyMatrixTest(){
        Matrix matrix = new Matrix();

        Assertions.assertTrue(matrix.equals(new Double[0][0]));
    }

    @Test
    void definedSizeMatrixTest(){
        Matrix matrix = new Matrix(3,3);
        double[][] expectedBody = {
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0}
        };

        Assertions.assertTrue(matrix.equals(matrix));
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


        int actualColumns = matrix.getColumns();
        int actualRows = matrix.getRows();


        Assertions.assertTrue(matrix.equals(matrixBody));
        Assertions.assertEquals(givenColumns, actualColumns);
        Assertions.assertEquals(givenRows, actualRows);
    }

    @Test
    void setMatrixTest(){
        double[][] matrixBody = {
                {0.1, 0.23, 223.2, 23.0},
                {12.2, 23.1, 34.2, 0.001}
        };

        Matrix matrix = new Matrix();
        matrix.setMatrix(matrixBody);

        int givenRows = matrixBody.length;
        int givenColumns = matrixBody[0].length;

        int actualColumns = matrix.getColumns();
        int actualRows = matrix.getRows();


        Assertions.assertTrue(matrix.equals(matrixBody));
        Assertions.assertEquals(givenColumns, actualColumns);
        Assertions.assertEquals(givenRows, actualRows);
    }

    @Test
    void setMatrixValuesTest(){
        Matrix matrix = new Matrix(3,4);
        matrix.setValue(1,4, 2232.3235);

        double[][] expectedBody = {
                {0.0, 0.0, 0.0, 2232.3235},
                {0.0, 0.0, 0.0, 0.0},
                {0.0, 0.0, 0.0, 0.0}
        };

        Assertions.assertTrue(matrix.equals(expectedBody));

    }

    @Test
    void getRowTest(){
        Matrix matrix = new Matrix(2,3);

        double[] expectedRow = {0.0, 0.0, 0.0};

        String expectedBodyStr = Arrays.toString(expectedRow);
        String actualBodyStr = Arrays.toString(matrix.getRow(1));
        Assertions.assertEquals(expectedBodyStr, actualBodyStr);
    }

    @Test
    void getColumnTest(){
        Matrix matrix = new Matrix(2,3);

        double[] expectedColumn = {0.0, 0.0};

        String expectedBodyStr = Arrays.toString(expectedColumn);
        String actualBodyStr = Arrays.toString(matrix.getColumn(1));
        Assertions.assertEquals(expectedBodyStr, actualBodyStr);
    }

    @Test
    void getDimensityTest(){
        Matrix matrix = new Matrix(2,3);
        int dim[] = matrix.getDimensity();
        Assertions.assertEquals(2, dim[0]);
        Assertions.assertEquals(3, dim[1]);
    }

    @Test
    void hashCodeTest(){
        Matrix matrix1 = new Matrix(3,4);
        matrix1.setValue(1,4, 2232.3235);
        matrix1.setValue(3,2, 323.32);

        Matrix matrix2 = new Matrix(3,4);
        matrix2.setValue(1,4, 2232.3235);
        matrix2.setValue(3,2, 323.32);

        boolean cond1 = matrix1.equals(matrix2);
        boolean cond2 = matrix1.hashCode() == matrix2.hashCode();
        Assertions.assertTrue(cond1);
        Assertions.assertTrue(cond2);
    }






}
