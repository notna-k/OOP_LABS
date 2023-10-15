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

    private void setZeros(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.body.get(i).add(0.0);
            }
        }
    }





}
