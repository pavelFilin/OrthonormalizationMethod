package ru.feeleen.BLL.helper.Vector;

public class Vector {
    private Double[] vector;

    public Vector(Double[] vector) {
        this.vector = vector;
    }

    public static Double dotProduct(Vector a, Vector b) {
        if (a.length() != b.length()) {
            throw new IllegalArgumentException("A length is not equipment b");
        }

        Double product = 0d;
        for (int i = 0; i < a.length(); i++) {
            product += a.get(i) * b.get(i);
        }

        return product;
    }

    public Double get(int i) {
        return vector[i];
    }

    public int length() {
        return vector.length;
    }

    public Double dotProduct(Vector a) {
        if (a.length() != vector.length) {
            throw new IllegalArgumentException("A length is not equipment currant vector");
        }

        Double product = 0d;
        for (int i = 0; i < a.length(); i++) {
            product += a.get(i) * vector[i];
        }

        return product;
    }

}
