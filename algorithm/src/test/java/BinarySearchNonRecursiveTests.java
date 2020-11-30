
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchNonRecursiveTests {

    @Test
    public void givenSortedIntArrWhenSearchByNonRecursiveThenReturnTarget() {
        BinarySearchNonRecursive binarySearchNonRecursive = new BinarySearchNonRecursive();
        int[] arr = {1, 34, 54, 67, 84, 94, 103, 124};
        int index = binarySearchNonRecursive.search(arr, 1);
        Assertions.assertEquals(0, index);

        index = binarySearchNonRecursive.search(arr, 124);
        Assertions.assertEquals(7, index);

        index = binarySearchNonRecursive.search(arr, 54);
        Assertions.assertEquals(2, index);

        index = binarySearchNonRecursive.search(arr, 103);
        Assertions.assertEquals(6, index);

        index = binarySearchNonRecursive.search(arr, 99);
        Assertions.assertEquals(-1, index);
    }

    @Test
    public void givenSortedIntArrWhenSearchByRecursiveThenReturnTarget() {
        BinarySearchRecursive binarySearchRecursive = new BinarySearchRecursive();
        int[] arr = {1, 34, 54, 67, 84, 94, 103, 124};
        int index = binarySearchRecursive.search(arr, 1);
        Assertions.assertEquals(0, index);

        index = binarySearchRecursive.search(arr, 124);
        Assertions.assertEquals(7, index);

        index = binarySearchRecursive.search(arr, 54);
        Assertions.assertEquals(2, index);

        index = binarySearchRecursive.search(arr, 103);
        Assertions.assertEquals(6, index);

        index = binarySearchRecursive.search(arr, 99);
        Assertions.assertEquals(-1, index);
    }
}
