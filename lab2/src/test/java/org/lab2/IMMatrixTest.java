package org.lab2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lab2.Matrix.IMMatrix;
import org.lab2.Matrix.Matrix;

public class IMMatrixTest {

    @Test
    void addMatrixTest(){
        Double[][] matrixBody = {
                {100.0, 23.0, 223.0, 23.0},
                {12.2, 23.1, 340.0, 0.001}
        };
        Double[][] matrix2Body = {
                {-1000.0, 0.0, -1000.0, 0.0},
                {0.0, 0.0, -1000.0, 0.0}
        };

        Double[][] expectedMatrix2Body = {
                {-900.0, 23.0, -777.0, 23.0},
                {12.2, 23.1, -660.0, 0.001}
        };


        IMMatrix matrix = new IMMatrix(matrixBody);
        IMMatrix matrix2 = new IMMatrix(matrix2Body);
        IMMatrix expectedMatrix =  new IMMatrix(expectedMatrix2Body);




        Double[][] sum = matrix.add(matrix2);
        Assertions.assertTrue(matrix.equals(expectedMatrix));



    }

    @Test
    void multiplyMatrixTest(){
        Double[][] matrixBody = {
                {100.0, 23.0, 223.0, 23.0},
                {12.2, 23.1, 340.0, 0.001}
        };

        Double[][] expectedMatrixBody = {
                {200.0, 46.0, 446.0, 46.0},
                {24.4, 46.2, 680.0, 0.002}
        };
        IMMatrix matrix = new IMMatrix(matrixBody);
        IMMatrix expectedMatrix = new IMMatrix(expectedMatrixBody);

        Double[][] res = matrix.multiply(2);
        IMMatrix resMatrix = new IMMatrix(res);

        Assertions.assertTrue(expectedMatrix.equals(resMatrix));
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

        IMMatrix matrix = new IMMatrix(matrixBody);
        IMMatrix matrix2 = new IMMatrix(matrix2Body);

        IMMatrix expectedMatrix = new IMMatrix(expectedBody);

        IMMatrix actual = matrix.multiply(matrix2);


        Assertions.assertTrue(actual.equals(expectedMatrix));

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

        IMMatrix imMatrix = new IMMatrix(matrixBody);
        IMMatrix transposedMatrix = new IMMatrix(transposedMatrixBody);
        IMMatrix actualTransposedMatrix = imMatrix.transpose();

        Assertions.assertTrue(actualTransposedMatrix.equals(transposedMatrix));
    }

    @Test
    void diagonalMatrixTest(){
        Double[] vector = {1.23, 14.5, 0.0};

        Double[][] expectedBody = {
                {1.23, 0.0, 0.0},
                {0.0, 14.5, 0.0},
                {0.0, 0.0, 0.0}
        };

        IMMatrix expectedMatrix = new IMMatrix(expectedBody);
        IMMatrix actualMatrix = IMMatrix.createDiagonalMatrix(vector);

        Assertions.assertTrue(actualMatrix.equals(expectedMatrix));

    }
}
