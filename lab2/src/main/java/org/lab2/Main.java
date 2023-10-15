package org.lab2;

import org.lab2.Matrix.Matrix;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(3,4);
        matrix.matrix.get(1).set(3, 2323.3232323);
        matrix.printMatrix();

    }
}