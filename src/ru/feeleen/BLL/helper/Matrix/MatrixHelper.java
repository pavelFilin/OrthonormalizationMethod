package ru.feeleen.BLL.helper.Matrix;

import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

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
        if (a[0].length != b.length) {
            new Exception("Число столбцов первой матрицы не равно числу строк второй ");
        }

        Double[][] result = new Double[b.length][];
        for (int i = 0; i < result.length; i++) {
            result[i] = new Double[b[0].length];
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = 0d;
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += (a[i][k] * b[k][j]);
                }

            }
        }

        return result;
    }

    public static Double[][] invertMatrix(Double[][] matrix) {
        Double[][] result = new Double[matrix.length][];

        double[][] matrix2 = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix2[i][j] = matrix[i][j];
            }
        }

        RealMatrix m = MatrixUtils.createRealMatrix(matrix2);
        RealMatrix pInverse = new LUDecomposition(m).getSolver().getInverse();
        for (int i = 0; i < result.length; i++) {
            result[i] = new Double[matrix.length];
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = pInverse.getEntry(i, j);
            }
        }

        return result;
    }

    /*

    public static double findDeterminant(Double[][] matrix) {

    }*/
}
