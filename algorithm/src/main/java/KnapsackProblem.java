public class KnapsackProblem {

    private int goodSize;
    private int[] weights;
    private int[] values;
    private int packageWeight;

    private int[][] maxValues;

    public void setGoodSize(int i) {
        this.goodSize = i;
    }

    public void setWeights(int[] ints) {
        this.weights = ints;
    }

    public void setValues(int[] ints) {
        this.values = ints;
    }

    public void setPackageWeight(int i) {
        this.packageWeight = i;
    }

    public int calMaxValue() {
        maxValues = new int[goodSize][packageWeight + 1];

        // first row
        for (int i = 0 , j = 0; j < packageWeight + 1; j++) {
            if (weights[i] > j) {
                maxValues[i][j] = 0;
            } else {
                maxValues[i][j] = values[i];
            }
        }

        for (int i = 1; i < goodSize; i++) {
            for (int j = 0; j < packageWeight + 1; j++) {
                if (weights[i] > j) {
                    maxValues[i][j] = maxValues[i - 1][j];
                } else {
                    maxValues[i][j] = Math.max(maxValues[i - 1][j - weights[i]] + values[i], maxValues[i - 1][j]);
                }
            }
        }

        return maxValues[goodSize - 1][packageWeight];
    }
}
