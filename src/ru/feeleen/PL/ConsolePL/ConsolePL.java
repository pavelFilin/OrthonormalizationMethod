package ru.feeleen.PL.ConsolePL;

import ru.feeleen.BLL.Orthonormalization;

public class ConsolePL implements Runnable {
    private Orthonormalization orthonormalization;

    public ConsolePL() {
        this.orthonormalization = new Orthonormalization();
    }

    @Override
    public void run() {
        Double[][] matrix = new Double[][]{
                {0.4, 0.3, -0.2, 0.2},
                {0.6, -0.5, 0.3, 2.5},
                {0.3, 0.2, 0.5, 11.0}
        };

        orthonormalization.findX(matrix);
    }
}
