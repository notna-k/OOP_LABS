package org.lab2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.lab2.Matrix.IMMatrix;
import org.lab2.Matrix.Matrix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MatrixTest {


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
        Double[][] matrixBody = {
                {0.1, 0.23, 223.2, 23.0},
                {12.2, 23.1, 34.2, 0.001}
        };

        Matrix matrix = new Matrix(matrixBody);

        int givenRows = matrixBody.length;
        int givenColumns = matrixBody[0].length;


        int actualColumns = matrix.getColumns();
        int actualRows = matrix.getRows();


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
        Matrix expectedMatrix = new Matrix(expectedBody);

        Assertions.assertTrue(matrix.equals(expectedMatrix));

    }

    @Test
    void getRowTest(){
        Matrix matrix = new Matrix(2,3);

        Double[] expectedRow = {0.0, 0.0, 0.0};

        String expectedBodyStr = Arrays.toString(expectedRow);
        String actualBodyStr = Arrays.toString(matrix.getRow(1));
        Assertions.assertEquals(expectedBodyStr, actualBodyStr);
    }

    @Test
    void getColumnTest(){
        Matrix matrix = new Matrix(2,3);

        Double[] expectedColumn = {0.0, 0.0};

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

    @Test
    void addMatrixTest(){
        Double[][] matrixBody = {
                {100.0, 23.0, 223.0, 23.0},
                {12.2, 23.1, 340.0, 0.001}
        };

        Double[][] expectedMatrix2Body = {
                {-900.0, 23.0, -777.0, 23.0},
                {12.2, 23.1, -660.0, 0.001}
        };


        Matrix matrix = new Matrix(matrixBody);
        Matrix matrix2 = new Matrix(2,4);
        Matrix expectedMatrix =  new Matrix(expectedMatrix2Body);

        matrix2.setValue(1, 3, -1000.0);
        matrix2.setValue(2, 3, -1000.0);
        matrix2.setValue(1, 1, -1000.0);




        matrix.add(matrix2);
        Assertions.assertTrue(matrix.equals(expectedMatrix));

    }

    @Test
    void multiplyOnScalarTest(){
        Double[][] matrixBody = {
                {100.0, 23.0, 223.0, 23.0},
                {12.2, 23.1, 340.0, 0.001}
        };

        Double[][] expectedMatrixBody = {
                {200.0, 46.0, 446.0, 46.0},
                {24.4, 46.2, 680.0, 0.002}
        };
        Matrix matrix = new Matrix(matrixBody);
        Matrix expectedMatrix = new Matrix(expectedMatrixBody);

        matrix.multiply(2);
        Assertions.assertTrue(matrix.equals(expectedMatrix));
    }

    @Test
    void multiplyOnMatrixTest(){
        Double[][] matrixBody = {
                {20.0, 13.0},
                {30.0, 4.0},
        };
        Double[][] matrix2Body = {
                {3.0},
                {5.0}
        };

        Double[][] expectedBody = {
                {125.0},
                {110.0},
        };

        Matrix matrix = new Matrix(matrixBody);
        Matrix matrix2 = new Matrix(matrix2Body);

        Matrix expectedMatrix = new Matrix(expectedBody);

        matrix.multiply(matrix2);

        Assertions.assertTrue(matrix.equals(expectedMatrix));

    }
    @Test
    void transposeMatrixTest(){
        Double[][] matrixBody = {
                {20.0, 13.0},
                {30.0, 4.0},
        };
        Double[][] transposedMatrixBody = {
                {20.0, 30.0},
                {13.0, 4.0},
        };

        Matrix matrix = new Matrix(matrixBody);
        Matrix transposedMatrix = new Matrix(transposedMatrixBody);
        Matrix actualTransposedMatrix = matrix.transpose();

        Assertions.assertTrue(actualTransposedMatrix.equals(transposedMatrix));
    }



}
