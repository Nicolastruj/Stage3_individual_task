package org.ulpgc.test;

import org.openjdk.jmh.annotations.*;
import org.ulpgc.production.MatrixMultiplication;
import org.ulpgc.production.MatrixMultiplication2;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 10, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.MILLISECONDS)
@Fork(5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class MyBenchmarks {
    @Param({"8", "16", "32", "64", "128", "256", "512", "1024"})
    int n;

    MatrixMultiplication matrixMultiplier = new MatrixMultiplication();
    MatrixMultiplication2 matrixMultiplier2 = new MatrixMultiplication2();

    @Setup(Level.Trial)
    public void setup() {
        matrixMultiplier.initializeMatrices(n);
        matrixMultiplier2.initializeMatrices(n);
    }
    @Benchmark
    public void testMethod1() {
        matrixMultiplier.myFunction(n);
    }
    @Benchmark
    public void testMethod2() {
        matrixMultiplier.myFunctionWithThreads(n);
    }
    @Benchmark
    public void testMethod3(){
        matrixMultiplier2.multiplyMatrices();
    }
}
