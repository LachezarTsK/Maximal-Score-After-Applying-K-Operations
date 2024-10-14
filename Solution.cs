
using System;
using System.Collections.Generic;

public class Solution
{
    private static readonly int DIVISOR_TO_OBTAIN_NEW_VALUE = 3;

    public long MaxKelements(int[] input, int numberOfOperations)
    {
        PriorityQueue<int, int> maxHeap = new PriorityQueue<int, int>
            (Comparer<int>.Create((x, y) => y - x));

        foreach (int value in input)
        {
            maxHeap.Enqueue(value, value);
        }

        long maxScore = 0;
        while (numberOfOperations > 0)
        {
            int currentMaxValue = maxHeap.Dequeue();
            int newValue = (int)Math.Ceiling((double)currentMaxValue / DIVISOR_TO_OBTAIN_NEW_VALUE);

            maxScore += currentMaxValue;
            maxHeap.Enqueue(newValue, newValue);
            --numberOfOperations;
        }
        return maxScore;
    }
}
