package org.lab2;

import org.lab2.Matrix.Matrix;

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
                while(true) {
                    try {
                        System.out.printf("Row %d Column %d:", i + 1, j + 1);
                        double value = scanner.nextDouble();
                        scanner.nextLine();
                        matrix.setValue(i + 1, j + 1, value);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input!");
                        scanner.nextLine();
                    }
                }
            }
        }

        matrix.printMatrix(5);

        System.out.println("Enter the column or row you want to print like 'column 3' or 'row 2': ");
        String commandAndVal = scanner.nextLine();
        String command = commandAndVal.split(" ")[0].toLowerCase();
        int value = Integer.parseInt(commandAndVal.split(" ")[1]);

        try {
            if (command.equals("column")) {
                double[] column = matrix.getColumn(value);
                System.out.println(Arrays.toString(column));

            } else if (command.equals("row")) {
                double[] row = matrix.getRow(value);
                System.out.println(Arrays.toString(row));
            } else System.out.println("Invalid input");

        } catch(Exception e){
            System.out.println("Invalid input");
        }


    }
}