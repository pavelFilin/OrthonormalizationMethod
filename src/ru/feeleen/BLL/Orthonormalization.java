package ru.feeleen.BLL;

public class Orthonormalization {
    public Double[] getX(Double[][] matrix) {
        Double[] columnR = new Double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            columnR[i] = matrix[i][0];
        }

        return new Double[0];
    }
}
