package org.ulpgc.production;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.Random;

public class MatrixMultiplication2 {

    static RealMatrix a; // Matriz A
    static RealMatrix b; // Matriz B
    static RealMatrix c; // Matriz de resultados

    public void initializeMatrices(int size) {
        Random random = new Random();

        // Generar matrices de datos
        double[][] dataA = new double[size][size];
        double[][] dataB = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dataA[i][j] = random.nextDouble();
                dataB[i][j] = random.nextDouble();
            }
        }

        // Crear matrices como RealMatrix
        a = MatrixUtils.createRealMatrix(dataA);
        b = MatrixUtils.createRealMatrix(dataB);
        c = MatrixUtils.createRealMatrix(new double[size][size]); // Matriz inicializada a ceros
    }

    public int multiplyMatrices() {
        c = a.multiply(b); // Multiplicación vectorizada
        return 0;
    }
}