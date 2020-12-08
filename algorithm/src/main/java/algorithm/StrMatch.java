
package algorithm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Threads(1)
public class StrMatch {

    public int match(String targetStr, String patternStr) {

        if (targetStr.length() < patternStr.length()) return -1;

        for (int i = 0, p = 0; i < targetStr.length(); ) {
            for (int j = 0; j < patternStr.length(); ) {
                if (targetStr.charAt(i) == patternStr.charAt(j)) {
                    i++;
                    j++;
                } else {
                    p++;
                    i = p;
                    j = 0;
                }
            }
            return p;
        }
        return -1;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 5, batchSize = 1000000)
    @Warmup(iterations = 1,batchSize = 1000)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void test() {
        StrMatch strMatch = new StrMatch();
        int index = strMatch.match("ababababca", "abababca");
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(StrMatch.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
