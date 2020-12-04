package algorithm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Threads(1)
public class BinarySearchRecursive {
    private BinarySearchRecursive binarySearchRecursive;
    private int[] arr;

    public int search(int[] arr, int target) {
        int mid = (arr.length - 1) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            if (mid <= 0) return -1;
            int index = mid - 1;
            int[] tmp = subArray(arr, 0, index);
            return search(tmp, target);
        } else {
            if (mid >= (arr.length - 1)) return -1;
            int index = mid + 1;
            int[] tmp = subArray(arr, index, arr.length - 1);
            int result = search(tmp, target);
            if (result < 0) return result;
            return result + mid + 1;
        }
    }

    private int[] subArray(int[] arr, int left, int right) {
        int len = right - left + 1;
        int[] tmp = new int[len];
        for (int i = left, m = 0; i <=  right; i++, m++) {
            tmp[m] = arr[i];
        }
        return tmp;
    }

    @Setup(Level.Invocation)
    public void setup() {
        binarySearchRecursive = new BinarySearchRecursive();
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
        binarySearchRecursive.search(arr, 1);
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(BinarySearchRecursive.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
