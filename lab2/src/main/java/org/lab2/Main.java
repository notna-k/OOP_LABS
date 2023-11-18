package org.lab2;

import org.lab2.Matrix.IMMatrix;
import org.lab2.Matrix.Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Matrix temp2 = new Matrix(2,3);
        temp2.randomMatrix(-200, 50);


        Matrix temp = new Matrix(2,3);
        temp.randomMatrix();
        IMMatrix matrix = new IMMatrix(temp2);
        IMMatrix imMatrix = new IMMatrix(temp);

        IMMatrix result = matrix.add(imMatrix);

        temp2.printMatrix();
        temp.printMatrix();

        result.printMatrix();







    }
}