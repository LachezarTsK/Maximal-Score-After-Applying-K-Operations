
import java.util.PriorityQueue;

public class Solution {

    private static final int DIVISOR_TO_OBTAIN_NEW_VALUE = 3;

    public long maxKelements(int[] input, int numberOfOperations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        for (int value : input) {
            maxHeap.add(value);
        }

        long maxScore = 0;
        while (numberOfOperations > 0) {
            int currentMaxValue = maxHeap.poll();
            int newValue = Math.ceilDiv(currentMaxValue, DIVISOR_TO_OBTAIN_NEW_VALUE);

            maxScore += currentMaxValue;
            maxHeap.add(newValue);
            --numberOfOperations;
        }
        return maxScore;
    }
}
