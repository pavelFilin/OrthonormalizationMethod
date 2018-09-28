package ru.feeleen.BLL.helper.Matrix;

public class MatrixHelper {
    public static Double[][] transpose(Double[][] matrix) {
        Double[][] result = new Double[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = new Double[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public static Double[][] multiply(Double[][] a, Double[][] b) {
        Double[][] result = new Double[a.length][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Double[b.length];
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = 0d;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int k = 0; k < b.length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static Double[][] invertMatrix(Double[][] matrix) {
        Double[][] result = new Double[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

            }
        }
    }

    public static double findDeterminant(Double[][] matrix) {

    }
}
