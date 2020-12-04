package algorithm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Threads(1)
public class Fibonacci {

    public int get(int i) {
        if (i < 1) return 0;
        if (i == 1) return 1;
        return get(i - 1) + get(i - 2);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 1, batchSize = 10000)
    @Measurement(iterations = 5, batchSize = 1000000)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void test() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.get(100); // when small like 10, quicker than dp
    }

    public static void main(String[] args) throws RunnerException {
        Options build = new OptionsBuilder().include(Fibonacci.class.getSimpleName()).forks(1).build();
        new Runner(build).run();
    }

}
