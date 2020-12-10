package me.alidg;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.Throughput)
public class IntrinsicsBenchmark {

    @Param("12346545756.54634")
    double value;

    @Benchmark
    public double indirect() {
        return Math.log(value); // Calls the StrictMath.log(value) under the hood.
    }

    @Benchmark
    public double direct() {
        return StrictMath.log(value);
    }

    public static void main(String[] args) throws Exception {
        Main.main(args);
    }
}
