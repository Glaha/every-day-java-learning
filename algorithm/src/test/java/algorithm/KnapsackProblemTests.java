package algorithm;

import algorithm.KnapsackProblem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KnapsackProblemTests {

    @Test
    public void givenWeightsAndValuesAndPackageTotalWeightWhenCalculateMaxValuesThenReturnAnswer() {
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        knapsackProblem.setGoodSize(5);
        knapsackProblem.setWeights(new int[]{2,2,6,5,4});
        knapsackProblem.setValues(new int[]{6,3,5,4,6});

        knapsackProblem.setPackageWeight(10);
        int maxValue = knapsackProblem.calMaxValue();
        Assertions.assertEquals(15, maxValue);

        knapsackProblem.setPackageWeight(7);
        maxValue = knapsackProblem.calMaxValue();
        Assertions.assertEquals(12, maxValue);

        knapsackProblem.setPackageWeight(3);
        maxValue = knapsackProblem.calMaxValue();
        Assertions.assertEquals(6, maxValue);
    }

}
