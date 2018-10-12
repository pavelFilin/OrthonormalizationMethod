package ru.feeleen.BLL;

import ru.feeleen.BLL.helper.Matrix.MatrixHelper;

public class Orthonormalization {
    public Double[][] findX(Double[][] matrix) {
        Double[][] rMassive = new Double[matrix.length][];
        for (int i = 0; i < rMassive.length; i++) {
            rMassive[i] = new Double[rMassive.length];
        }

        Double[][] lamdaMassive = new Double[matrix.length][];
        for (int i = 0; i < lamdaMassive.length; i++) {
            lamdaMassive[i] = new Double[matrix.length];
            for (int j = 0; j < lamdaMassive[0].length; j++) {
                if (i == j) {
                    lamdaMassive[i][j] = 1.0;
                } else {
                    lamdaMassive[i][j] = 0.0;
                }
            }

        }

        for (int i = 0; i < matrix.length; i++) {
            rMassive[i][0] = matrix[i][0];
        }

        for (int i = 1; i < rMassive.length; i++) {
            Double[] temp = new Double[rMassive.length];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = 0.0;
            }
            for (int j = 0; j < i; j++) {
                double scolar_ar = 0d;
                double scolar_rr = 0d;
                Double[] proj = new Double[rMassive.length];
                for (int k = 0; k < rMassive[0].length; k++) {
                    scolar_ar += matrix[k][i] * rMassive[k][j];
                    scolar_rr += rMassive[k][j] * rMassive[k][j];
                }

                double lamda = scolar_ar / scolar_rr;
                lamdaMassive[j][i] = lamda;
                for (int k = 0; k < rMassive.length; k++) {
                    proj[k] = lamda * rMassive[k][j];
                }

                for (int k = 0; k < temp.length; k++) {
                    temp[k] += proj[k];
                }
            }

            for (int j = 0; j < rMassive.length; j++) {
                rMassive[j][i] = matrix[j][i] - temp[j];
            }
        }

        Double[][] rTransposed = MatrixHelper.transpose(rMassive);
        Double[][] D = MatrixHelper.multiply(rTransposed, rMassive);
        Double[][] DInvert = MatrixHelper.invertMatrix(D);
        Double[][] TInvert = MatrixHelper.invertMatrix(lamdaMassive);
        Double[][] b = new Double[matrix.length][];


        for (int i = 0; i < matrix.length; i++) {
            b[i] = new Double[1];
            b[i][0] = matrix[i][matrix[0].length-1];
        }

        Double[][] result = MatrixHelper.multiply(TInvert, DInvert);
        Double[][] RB = MatrixHelper.multiply(rTransposed, b);
        result = MatrixHelper.multiply(result, RB);

        return result;
    }
}