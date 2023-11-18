package org.lab2.Matrix;

import java.text.DecimalFormat;

public class GMatrix<T> {
    private T[][] body;
    private int rows;
    private int columns;

    private String type;

    public void checkType(T obj) {
        if (obj instanceof Integer) {
            this.type = "Integer";
        } else if (obj instanceof Double) {
            this.type = "Double";
        } else if (obj instanceof String) {
            this.type = "String";
        } throw new IllegalArgumentException("Type is nor integer, double, string :((");
    }

    public T[][] getBody() {
        return this.body;
    }
    public GMatrix(T[][] matrix){
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.body = matrix;
    }


    public void printMatrix() {
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.columns; j++){
                System.out.print(this.body[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void add(GMatrix<T> matrix) {
        if (!this.type.equals(matrix.type)) {
            throw new IllegalArgumentException("Matrix types are different and cannot be added.");
        }

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {

                switch(type){
                    case "Integer":
                        this.body[i][j] = (T) Integer.valueOf(((Number) this.body[i][j]).intValue() +
                                ((Number) matrix.body[i][j]).intValue());
                        break;
                    case "Double":
                        this.body[i][j] = (T) Double.valueOf(((Number) this.body[i][j]).doubleValue() +
                                ((Number) matrix.body[i][j]).doubleValue());
                        break;
                    case "String":
                        this.body[i][j] = (T) String.valueOf(((String) this.body[i][j]) +
                                ((String) matrix.body[i][j]));
                        break;
                }

            }
        }
    }


    @Override
    public boolean equals(Object obj) {
        try {
            GMatrix matrix = (GMatrix) obj;

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
}
