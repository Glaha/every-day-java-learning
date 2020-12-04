package algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTests {

    @Test
    public void given20WhenRecursiveThenReturn6765() {

        Fibonacci fibonacci = new Fibonacci();
        int number = fibonacci.get(20);
        Assertions.assertEquals(6765, number);

        FibonacciDPRecursive fibonacciDPRecursive = new FibonacciDPRecursive(20);
        number = fibonacciDPRecursive.get(20);
        Assertions.assertEquals(6765, number);

        FibonacciDPNonRecursive fibonacciDPNonRecursive = new FibonacciDPNonRecursive(20);
        number = fibonacciDPRecursive.get(20);
        Assertions.assertEquals(6765, number);
    }
}
