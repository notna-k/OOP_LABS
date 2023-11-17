package org.lab2.Matrix;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class IMMatrix implements MatrixInterface {
    private final int rows;
    private final int columns;
    private final Double[][] body;

    private final int prime = 31;

    public IMMatrix() {
        this.rows = 0;
        this.columns = 0;
        this.body = new Double[0][0];
    }

    public IMMatrix(Matrix matrix){
        this.body = matrix.getBody();
        this.columns = matrix.getColumns();
        this.rows = matrix.getRows();
    }

    public IMMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.body = new Double[rows][columns];
        setZeros();
    }

    public IMMatrix(Double[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.body = new Double[rows][columns];

        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, this.body[i], 0, columns);
        }
    }

    public IMMatrix(double[][] matrix) {
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
        return Arrays.copyOf(this.body, this.body.length);
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
        return Arrays.copyOf(this.body[row - 1], this.columns);
    }

    public Double[] getColumn(int column) {
        return Arrays.copyOf(this.body[column - 1], this.columns);
    }

    public Double[][] add(IMMatrix matrix){
        if (matrix.rows != this.rows || matrix.columns != this.columns) throw new IllegalArgumentException("Matrices demensities don't match");
        Double[][] newMatrix = this.getBody();
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                newMatrix[i][j] += matrix.body[i][j];
            }
        }
        return newMatrix;

    }

    public Double[][] multiply(double scalar){
        Double[][] newMatrix = this.getBody();
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                newMatrix[i][j] *= scalar;
            }
        }
        return newMatrix;

    }

    public IMMatrix multiply(IMMatrix matrix){
        if(matrix.rows != this.columns) throw new IllegalArgumentException("Matrices demensities don't match");

        Double[][] result = new Double[this.rows][matrix.columns];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < matrix.columns; j++) {
                double sum = 0.0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.body[i][k] * matrix.body[k][j];
                }
                result[i][j] = sum;
            }
        }

        return new IMMatrix(result);
    }












    public static IMMatrix createDiagonalMatrix(Double[] vector) {
        int size = vector.length;
        Double[][] diagonalMatrix = new Double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                diagonalMatrix[i][j] = (i == j) ? vector[i] : 0.0;
            }
        }

        return new IMMatrix(diagonalMatrix);
    }

    public static IMMatrix createOnesMatrix(int dimensity){
        Double[] vector = new Double[dimensity];
        for(int i = 0; i < dimensity; i++){
            vector[i] = 1.0;
        }
        return createDiagonalMatrix(vector);
    }


    public IMMatrix transpose() {
        Double[][] transposed = new Double[this.columns][this.rows];

        for (int i = 0; i < this.columns; i++) {
            for (int j = 0; j < this.rows; j++) {
                transposed[i][j] = this.body[j][i];
            }
        }

        return new IMMatrix(transposed);
    }

    public static IMMatrix randomRowMatrix(int length, double... range) {
        double min = range.length > 0 ? range[0] : -100.0;
        double max = range.length > 1 ? range[1] : 100.0;

        //default values if range doesn't provided

        Random random = new Random();
        Double[][] result = new Double[1][length];

        for (int i = 0; i < length; i++) {
            result[0][i] = min + (max - min) * random.nextDouble();
        }

        return new IMMatrix(result);
    }

    public static IMMatrix randomColumnMatrix(int length, double... range) {
        double min = range.length > 0 ? range[0] : -100.0;
        double max = range.length > 1 ? range[1] : 100.0;

        //default values if range doesn't provided

        Random random = new Random();
        Double[][] result = new Double[length][1];

        for (int i = 0; i < length; i++) {
            result[i][0] = min + (max - min) * random.nextDouble();
        }

        return new IMMatrix(result);
    }

    public IMMatrix convertToUpperTriangular() {
        Double[][] bodyClone = this.body;
        for (int i = 0; i < this.rows - 1; i++) {
            if (bodyClone[i][i] == 0.0) {
                boolean found = false;
                for (int k = i + 1; k < this.rows; k++) {
                    if (bodyClone[k][i] != 0.0) {
                        swapRows(bodyClone, i, k);
                        found = true;
                        break;
                    }
                }
                if (!found) continue;
            }

            for (int j = i + 1; j < this.rows; j++) {
                double factor = bodyClone[j][i] / bodyClone[i][i];
                for (int k = i; k < this.columns; k++) {
                    bodyClone[j][k] -= factor * bodyClone[i][k];
                }
            }
        }
        return new IMMatrix(bodyClone);
    }

    public IMMatrix convertToLowerTriangular() {
        Double[][] bodyClone = this.body;

        for (int i = rows - 1; i > 0; i--) {
            if (bodyClone[i][i] == 0.0) {
                boolean found = false;
                for (int k = i - 1; k >= 0; k--) {
                    if (bodyClone[k][i] != 0.0) {
                        bodyClone = swapRows(bodyClone, i, k);
                        found = true;
                        break;
                    }
                }
                if (!found) continue;
            }

            for (int j = i - 1; j >= 0; j--) {
                double factor = bodyClone[j][i] / bodyClone[i][i];
                for (int k = i; k < this.columns; k++) {
                    bodyClone[j][k] -= factor * bodyClone[i][k];
                }
            }
        }

        return new IMMatrix(bodyClone);
    }

    private Double[][] swapRows(Double[][] matrix, int row1, int row2) {
        Double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
        return matrix;
    }

    public IMMatrix inverseMatrix() {
        if (this.rows != this.columns) {
            throw new IllegalArgumentException("Matrix must be square to find its inverse");
        }

        int n = this.rows;
        Double[][] augmentedMatrix = new Double[n][2 * n];

        // Create the augmented matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                augmentedMatrix[i][j] = this.body[i][j];
                augmentedMatrix[i][j + n] = (i == j) ? 1.0 : 0.0;
            }
        }

        // Gauss-Jordan elimination
        for (int i = 0; i < n; i++) {
            if (augmentedMatrix[i][i] == 0.0) {
                boolean found = false;
                for (int k = i + 1; k < n; k++) {
                    if (augmentedMatrix[k][i] != 0.0) {
                        found = true;
                        augmentedMatrix = swapRows(augmentedMatrix, i, k);
                        break;
                    }
                }
                if (!found) {
                    throw new IllegalArgumentException("Matrix is singular, inverse does not exist");
                }
            }

            double factor = augmentedMatrix[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmentedMatrix[i][j] /= factor;
            }

            for (int k = 0; k < n; k++) {
                if (k != i) {
                    factor = augmentedMatrix[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentedMatrix[k][j] -= factor * augmentedMatrix[i][j];
                    }
                }
            }
        }

        // Extract the inverse matrix
        Double[][] inverse = new Double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(augmentedMatrix[i], n, inverse[i], 0, n);
        }

        return new IMMatrix(inverse);
    }








    public boolean equals(IMMatrix matrix) {
        try {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (!this.body[i][j].equals(matrix.getBody()[i][j])) {
                        return false;
                    }
                }
            }

            return true;
        } catch (ClassCastException | NullPointerException | ArrayIndexOutOfBoundsException e) {
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
