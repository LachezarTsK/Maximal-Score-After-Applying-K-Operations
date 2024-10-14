
// const {PriorityQueue} = require('@datastructures-js/priority-queue');
/*
 PriorityQueue is internally included in the solution file on leetcode.
 So, when running the code on leetcode it should stay commented out. 
 It is mentioned here as a comment, just for information about 
 which external library is applied for this data structure.
 */

function maxKelements(input: number[], numberOfOperations: number): number {
    const DIVISOR_TO_OBTAIN_NEW_VALUE = 3;
    const maxHeap = new MaxPriorityQueue({ compare: (x, y) => y - x });
    for (let value of input) {
        maxHeap.enqueue(value);
    }

    let maxScore = 0;
    while (numberOfOperations > 0) {
        const currentMaxValue = maxHeap.dequeue();
        const newValue = Math.ceil(currentMaxValue / DIVISOR_TO_OBTAIN_NEW_VALUE);

        maxScore += currentMaxValue;
        maxHeap.enqueue(newValue);
        --numberOfOperations;
    }
    return maxScore;
};
