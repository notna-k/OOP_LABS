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

    @Test
    void onesMatrixTest(){
        int dimensity = 3;

        Double[][] expectedBody = {
                {1.0, 0.0, 0.0},
                {0.0, 1.0, 0.0},
                {0.0, 0.0, 1.0}
        };

        IMMatrix expectedMatrix = new IMMatrix(expectedBody);
        IMMatrix actualMatrix = IMMatrix.createOnesMatrix(dimensity);

        Assertions.assertTrue(actualMatrix.equals(expectedMatrix));

    }
    @Test
    void randomRowMatrixTest(){
        IMMatrix matrix = IMMatrix.randomRowMatrix(4);
        System.out.println("Random matrix row: ");
        matrix.printMatrix();
    }

    @Test
    void randomColumnMatrixTest(){
        IMMatrix matrix = IMMatrix.randomColumnMatrix(3, -20, 1);
        System.out.println("Random matrix column: ");
        matrix.printMatrix();
    }

    @Test
    void upperTriangularMatrixTest() {
        Double[][] body = {
                {1.0, 1.0, 2.0},
                {2.0, 0.0, 1.0},
                {1.0, 2.0, 1.0}
        };
        Double[][] expectedBody = {
                {1.0, 1.0, 2.0},
                {0.0, -2.0, -3.0},
                {0.0, 0.0, -2.5}
        };

        IMMatrix matrix = new IMMatrix(body);
        IMMatrix actual = matrix.convertToUpperTriangular();
        IMMatrix expected = new IMMatrix(expectedBody);
        Assertions.assertTrue(expected.equals(actual));
    }

    @Test
    void inverseMatrixTest() {
        Double[][] body = {
                {1.0, 1.0, 2.0},
                {2.0, 0.0, 1.0},
                {1.0, 2.0, 1.0}
        };
        Double[][] expectedBody = {
                {-0.4, 0.6, 0.2},
                {-0.2, -0.2, 0.6},
                {0.8, -0.2, -0.4}
        };
        IMMatrix matrix = new IMMatrix(body);
        IMMatrix expectedMatrix = new IMMatrix(expectedBody);
        IMMatrix inversed = matrix.inverseMatrix();

        // Check dimensions
        Assertions.assertEquals(expectedMatrix.getRows(), inversed.getRows());
        Assertions.assertEquals(expectedMatrix.getColumns(), inversed.getColumns());

        // Check element-wise similarity within a tolerance
        double tolerance = 1e-6;
        for (int i = 0; i < expectedMatrix.getRows(); i++) {
            for (int j = 0; j < expectedMatrix.getColumns(); j++) {
                double diff = Math.abs(expectedMatrix.getElement(i, j) - inversed.getElement(i, j));
                Assertions.assertTrue(diff < tolerance, "Values differ at row " + i + ", column " + j + ": Expected " +
                        expectedMatrix.getElement(i, j) + " but got " + inversed.getElement(i, j));
            }
        }
    }

}
