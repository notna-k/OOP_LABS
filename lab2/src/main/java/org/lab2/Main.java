package org.lab2;

import org.lab2.Matrix.Matrix;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Matrix matrix = new Matrix(2,4);
        System.out.println(Arrays.deepToString(matrix.getBody()));
    }
}