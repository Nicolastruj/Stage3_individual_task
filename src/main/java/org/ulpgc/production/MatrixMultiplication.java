package org.ulpgc.production;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MatrixMultiplication {
    static int n;
    static double[][] a;
    static double[][] b;
    static double[][] c;

    public void initializeMatrices(int size) {
        n = size;
        a = new double[n][n];
        b = new double[n][n];
        c = new double[n][n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = random.nextDouble();
                b[i][j] = random.nextDouble();
                c[i][j] = 0;
            }
        }
    }

    public int myFunction(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return 0;
    }

    public int myFunctionWithThreads(int n) {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        for (int i = 0; i < n; i++) {
            int finalI = i;
            executor.submit(() -> {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        c[finalI][j] += a[finalI][k] * b[k][j];
                    }
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        return 0;
    }
}
