package org.lab2.Matrix;

import org.lab2.Main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Matrix {
    private int rows;
    private int columns;
    private ArrayList<ArrayList<Double>> body;


    public Matrix(){
        this.body = new ArrayList<>();
    }
    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        this.body = new ArrayList<>(rows);
        for(int i = 0; i < rows; i++){
            this.body.add(new ArrayList<>(columns));
        }
        setZeros();
    }

    public Matrix(double[][] matrix){
        this.columns = matrix[0].length;
        this.rows = matrix.length;
        ArrayList<ArrayList<Double>> arrayList = new ArrayList<>();
        for (double[] row : matrix) {
            ArrayList<Double> arrayListRow = new ArrayList<>();
            for (double value : row) {
                arrayListRow.add(value);
            }
            arrayList.add(arrayListRow);
        }
        this.body = arrayList;
    }

    public int getColumns() {
        return this.columns;
    }
    public int getRows(){
        return this.rows;
    }

    public Object[] getBody() {
        return this.body.toArray();
    }

    public void setValue(int row, int column, double value){
        if (row < 0 || row > this.rows || column < 0 || column > this.columns) {
            throw new IndexOutOfBoundsException("Invalid row or column index!");
        }
        this.body.get(row-1).set(column-1, value);
    }
    public void setMatrix(double[][] matrix){
        this.columns = matrix[0].length;
        this.rows = matrix.length;
        ArrayList<ArrayList<Double>> arrayList = new ArrayList<>();
        for (double[] row : matrix) {
            ArrayList<Double> arrayListRow = new ArrayList<>();
            for (double value : row) {
                arrayListRow.add(value);
            }
            arrayList.add(arrayListRow);
        }
        this.body = arrayList;
    }

    public int[] getDimensity(){
        int[] dim = new int[2];
        dim[0] = this.rows;
        dim[1] = this.columns;
        return dim;
    }



    public void printMatrix(int precisionAfterComma) {
        String patternString = "";
        for(int i = 0; i < precisionAfterComma; i++) patternString = patternString.concat("#");

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
                String roundedNumber = decimalFormat.format(this.body.get(i).get(j));
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

    public void printMatrix(){
        int precisionAfterComma = 3;
        printMatrix(3);
    }




    public double getElement(int row, int column){
        return this.body.get(row).get(column);
    }

    public double[] getRow(int row){
        row -= 1;
        ArrayList<Double> matrixRow = this.body.get(row);
        double[] array = new double[matrixRow.size()];
        for(int i = 0; i < matrixRow.size(); i++){
            array[i] = matrixRow.get(i);
        }
        return array;
    }

    public double[] getColumn(int column){
        column -= 1;
        ArrayList<Double> matrixColumn = new ArrayList<>();

        for(ArrayList<Double> row : this.body){
            matrixColumn.add(row.get(column));
        }

        double[] array = new double[matrixColumn.size()];
        for(int i = 0; i < matrixColumn.size(); i++){
            array[i] = matrixColumn.get(i);
        }
        return array;
    }


    private int getMaxLen(int precisionAfterComma){
        int maxLen = 0;

        String patternString = "";
        for(int i = 0; i < precisionAfterComma; i++) patternString = patternString.concat("#");

        //defining rounding
        DecimalFormat decimalFormat = new DecimalFormat("#." + patternString);

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                String roundedNumber = decimalFormat.format(this.body.get(i).get(j));
                if (roundedNumber.length() > maxLen) maxLen = roundedNumber.length();
            }
        }
        return maxLen;
    }



    private void setZeros(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.body.get(i).add(0.0);
            }
        }
    }





}
