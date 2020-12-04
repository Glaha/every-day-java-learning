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
public class FibonacciDPNonRecursive {

    private int[] dp;

    public FibonacciDPNonRecursive() {}

    public FibonacciDPNonRecursive(int n) {
        dp = new int[n + 1];
    }

    public int get(int n) {
        if (n < 1) return 0;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != 0) return dp[n];
        for (int j = 2; j < n + 1; j++) {
            dp[j] = dp[j - 1] + dp[j - 2];
        }
        return dp[n];
    }

    @Benchmark
    @Measurement(iterations = 5, batchSize = 1000000)
    @Warmup(iterations = 1,batchSize = 10000)
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void test() {
        FibonacciDPNonRecursive fibonacciDPRecursive = new FibonacciDPNonRecursive(100);
        fibonacciDPRecursive.get(100); // quicker than recursive, for there are no too many methods
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(FibonacciDPNonRecursive.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
