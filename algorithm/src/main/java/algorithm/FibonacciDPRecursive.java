package algorithm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

//solve by dp
@State(Scope.Thread)
@Threads(1)
public class FibonacciDPRecursive {

    private int[] dp;

    public FibonacciDPRecursive() {}

    public FibonacciDPRecursive(int n) {
        dp = new int[n + 1];
    }

    public int get(int i) {
        int result = 0;
        if (dp[i] != 0) return dp[i];
        if (i == 1) result = 1;
        else if (i > 1) result = get(i - 1) + get(i - 2);
        dp[i] = result;
        return dp[i];
    }

    @Benchmark
    @Measurement(iterations = 5, batchSize = 1000000)
    @Warmup(iterations = 1,batchSize = 10000)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void test() {
        FibonacciDPRecursive fibonacciDPRecursive = new FibonacciDPRecursive(100);
        fibonacciDPRecursive.get(100); // when big , quicker than non dp
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(FibonacciDPRecursive.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
