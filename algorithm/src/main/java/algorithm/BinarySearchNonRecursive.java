package algorithm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Threads(1)
public class BinarySearchNonRecursive {

    private BinarySearchNonRecursive binarySearchNonRecursive;
    private int[] arr;

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    @Setup(Level.Invocation)
    public void setup() {
        binarySearchNonRecursive = new BinarySearchNonRecursive();
        arr = new int[50];
        for (int i = 0; i < 50; i++) {
            arr[i] = i;
        }
    }

    @Measurement(iterations = 5, batchSize = 1000000)
    @Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
    @BenchmarkMode(value = Mode.AverageTime)
    @OutputTimeUnit(value = TimeUnit.MICROSECONDS)
    @Benchmark
    public void test() {
        binarySearchNonRecursive.search(arr, 1);
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(BinarySearchNonRecursive.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
