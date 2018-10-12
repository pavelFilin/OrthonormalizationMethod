package ru.feeleen.PL.ConsolePL;

import ru.feeleen.BLL.Orthonormalization;

public class ConsolePL implements Runnable {
    private Orthonormalization orthonormalization;

    public ConsolePL() {
        this.orthonormalization = new Orthonormalization();
    }

    public void run() {
        Double[][] matrix = new Double[][]{
                {0.4, 0.3, -0.2, 2.0},
                {0.6, -0.5, 0.3, 2.5},
                {0.3, 0.2, 0.5, 11.0}
        };

        matrix = new Double[][]{
                {0.450, 0.030, -0.01, 0.020, -0.111, 2.491},
                {0.020, 0.375, -0.01, 0.010, 0.000, 1.275},
                {0.000, 0.0700, 0.440, 0.000, 0.113, -0.738},
                {-0.03, 0.015, -0.02, 0.41, -0.084, 0.429},
                {0.020, 1.000, 0.000, 0.000, 0.290, -0.16},
        };

        printMatrix(matrix);

        Double[][] x = orthonormalization.findX(matrix);
        System.out.println("X=");
        printMatrix(x);

        double[] x2 = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            x2[i] = x[i][0];
        }

        double[] residual =getResidual(matrix, x2);
        System.out.println("невязка");
        double residualOne = 0;
        for (int i = 0; i < x.length; i++) {
            System.out.println("x" + i + " " + residual[i]);
            residualOne += Math.abs(residual[i]);
        }
        System.out.println("невязка = " + residualOne);

    }

    private void printMatrix(Double[][] matrix) {
        for (Double[] y : matrix) {
            for (Double x : y) {
                System.out.print(x+ " ");
            }
            System.out.println();
        }
    }

    private double[] getResidual(Double[][] matrix, double[] x) {
        double[] residual = new double[x.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                residual[i] += matrix[i][j] * x[j];
            }
            residual[i] -= matrix[i][matrix[0].length-1];
        }

        return residual;
    }
}
