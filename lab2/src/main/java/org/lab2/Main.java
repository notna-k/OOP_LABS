package org.lab2;

import org.lab2.Matrix.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rows number:");
        int rows = scanner.nextInt();
        System.out.println("Columns number:");
        int columns = scanner.nextInt();

        Matrix matrix = new Matrix(rows, columns);

        System.out.println("Enter every element of matrix:\n");


        for(int i = 0; i < rows; i++){
            for (int j = 0; j < columns;  j++){
                System.out.printf("Row %d Column %d:", i+1, j+1);
                double value = scanner.nextDouble();
                matrix.setValue(i+1, j+1, value);
            }
        }

        matrix.printMatrix(5);

    }
}