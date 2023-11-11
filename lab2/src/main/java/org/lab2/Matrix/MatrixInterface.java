package org.lab2.Matrix;

public interface MatrixInterface {

    int getColumns();
    int getRows();

    int[] getDimensity();
    void printMatrix(int precisionAfterComma);
    void printMatrix();
    Double getElement(int row, int column);
    Double[] getRow(int row);
    Double[] getColumn(int column);
    boolean equals(Object obj);
    int hashCode();

}
