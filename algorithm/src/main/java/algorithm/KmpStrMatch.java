package algorithm;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Threads(1)
public class KmpStrMatch {

    private Integer[] next;
    private String patternStr;

    public KmpStrMatch() {}

    public KmpStrMatch(String patternStr) {
        next = new Integer[patternStr.length()];
        this.patternStr = patternStr;
    }

    public int match(String targetStr) {

        if (targetStr.length() < patternStr.length()) return -1;

        for (int i = 0, p = 0; i < targetStr.length(); ) {
            for (int j = 0; j < patternStr.length(); ) {
                if (targetStr.charAt(i) == patternStr.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next(patternStr.substring(0,j), j - 1);
                    p = i - j;
                }
            }
            return p;
        }
        return -1;
    }

    public int next(String str, int index) {
        if (next[index] != null) {
            return next[index];
        }

        for (int i = str.length() - 2; i > 0; i--) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(str.length() - i);
            if (prefix.equals(suffix)) {
                next[index] = prefix.length();
                return next[index];
            }
        }
        return 0;
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 5, batchSize = 1000000)
    @Warmup(iterations = 1,batchSize = 1000)
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    public void test() {
        KmpStrMatch strMatch = new KmpStrMatch("abababca");
        int index = strMatch.match("ababababca");
    }

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(KmpStrMatch.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }
}
