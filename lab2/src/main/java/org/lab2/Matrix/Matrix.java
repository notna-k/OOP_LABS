


package org.lab2.Matrix;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Matrix implements MatrixInterface {
    private int rows;
    private int columns;
    private Double[][] body;

    private final int prime = 31;

    public Matrix() {
        this.body = new Double[0][0];
    }

    public Matrix(IMMatrix immatrix){
        this.body = immatrix.getBody();
        this.columns = immatrix.getColumns();
        this.rows = immatrix.getRows();
    }

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.body = new Double[rows][columns];
        setZeros();
    }

    public Matrix(Double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.body = new Double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.body[i][j] = matrix[i][j];
            }
        }
    }

    public Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.body = new Double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.body[i][j] = matrix[i][j];
            }
        }
    }

    public int getColumns() {
        return this.columns;
    }

    public int getRows() {
        return this.rows;
    }

    public Double[][] getBody() {
        return this.body;
    }


    public void setValue(int row, int column, Double value) {
        if (row < 0 || row > this.rows || column < 0 || column > this.columns) {
            throw new IndexOutOfBoundsException("Invalid row or column index!");
        }
        this.body[row - 1][column - 1] = value;
    }

    public void setMatrix(Double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.body = new Double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.body[i][j] = matrix[i][j];
            }
        }
    }

    public void setMatrix(double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.body = new Double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.body[i][j] = matrix[i][j];
            }
        }
    }

    public int[] getDimensity() {
        int[] dim = new int[2];
        dim[0] = this.rows;
        dim[1] = this.columns;
        return dim;
    }

    public void printMatrix(int precisionAfterComma) {
        String patternString = "";
        for (int i = 0; i < precisionAfterComma; i++) patternString = patternString.concat("#");

        DecimalFormat decimalFormat = new DecimalFormat("#." + patternString);
        int maxLen = getMaxLen(precisionAfterComma);

        for (int g = 0; g < this.columns; g++) {
            System.out.print("+");
            for (int h = 0; h < maxLen + 2; h++) {
                System.out.print("-");
            }
        }
        System.out.print("+");
        System.out.println();

        for (int i = 0; i < this.rows; i++) {
            System.out.print("| ");
            for (int j = 0; j < this.columns; j++) {
                String roundedNumber = decimalFormat.format(this.body[i][j]);
                String formattedNumber = String.format("%" + maxLen + "s", roundedNumber);
                System.out.print(formattedNumber + " | ");
            }
            System.out.println();

            for (int g = 0; g < this.columns; g++) {
                System.out.print("+");
                for (int h = 0; h < maxLen + 2; h++) {
                    System.out.print("-");
                }
            }
            System.out.print("+");
            System.out.println();
        }
    }

    public void printMatrix() {
        int precisionAfterComma = 3;
        printMatrix(3);
    }

    public Double getElement(int row, int column) {
        return this.body[row][column];
    }

    public Double[] getRow(int row) {
        Double[] Row = new Double[this.columns];
        for(int i = 0; i < this.columns; i++){
            Row[i] = this.body[row][i];
        }
        return Row;
    }

    public Double[] getColumn(int row) {
        Double[] Column = new Double[this.rows];
        for (int i = 0; i < this.rows; i++) {
            Column[i] = this.body[i][row];
        }
        return Column;
    }


    public void add(Matrix matrix){
        if (matrix.rows != this.rows || matrix.columns != this.columns) throw new IllegalArgumentException("Matrices demensities don't match");
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                this.body[i][j] += matrix.body[i][j];
            }
        }

    }

    public void multiply(double scalar){
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                this.body[i][j] *= scalar;
            }
        }

    }

    public void multiply(Matrix matrix){
        if(matrix.rows != this.columns) throw new IllegalArgumentException("Matrices demensities don't match");

        Double[][] result = new Double[this.rows][matrix.columns];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                Double sum = 0.0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.body[i][k] * matrix.body[k][j];
                }
                result[i][j] = sum;
            }
        }

        // Update the current matrix with the result
        this.rows = result.length;
        this.columns = result[0].length;
        this.body = result;
    }


    public Matrix transpose() {
        Double[][] transposed = new Double[this.columns][this.rows];

        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                transposed[i][j] = this.body[j][i];
            }
        }

        return new Matrix(transposed);
    }










    public static Matrix createDiagonalMatrix(Double[] vector) {
        int size = vector.length;
        Double[][] diagonalMatrix = new Double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diagonalMatrix[i][j] = (i == j) ? vector[i] : 0.0;
            }
        }

        return new Matrix(diagonalMatrix);
    }

    public static Matrix createOnesMatrix(int dimensity){
        Double[] vector = new Double[dimensity];
        for(int i = 0; i < dimensity; i++){
            vector[i] = 1.0;
        }
        return createDiagonalMatrix(vector);
    }

















    @Override
    public boolean equals(Object obj) {
        try {
            Matrix matrix = (Matrix) obj;

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (!this.body[i][j].equals(matrix.getBody()[i][j])) {
                        return false;
                    }
                }
            }

            return true;
        } catch (ClassCastException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
            return false;
        }
    }



    @Override
    public int hashCode() {
        int result = 1;

        result = prime * result + columns;
        result = prime * result + rows;
        result = prime * result + ((body == null) ? 0 : calculateBodyHashCode());

        return result;
    }


















    private int calculateBodyHashCode() {
        int bodyHashCode = 1;

        for (Double[] row : body) {
            bodyHashCode = prime * bodyHashCode + Arrays.hashCode(row);
        }

        return bodyHashCode;
    }

    private int getMaxLen(int precisionAfterComma) {
        int maxLen = 0;

        String patternString = "";
        for (int i = 0; i < precisionAfterComma; i++) patternString = patternString.concat("#");

        // defining rounding
        DecimalFormat decimalFormat = new DecimalFormat("#." + patternString);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                String roundedNumber = decimalFormat.format(this.body[i][j]);
                if (roundedNumber.length() > maxLen) maxLen = roundedNumber.length();
            }
        }
        return maxLen;
    }

    private void setZeros() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.body[i][j] = 0.0;
            }
        }
    }
}

