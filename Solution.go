
package main

import (
    "container/heap"
    "fmt"
    "math"
)

const DIVISOR_TO_OBTAIN_NEW_VALUE = 3

func maxKelements(input []int, numberOfOperations int) int64 {
    maxHeap := make(PriorityQueue, 0)
    for _, value := range input {
        heap.Push(&maxHeap, value)
    }

    var maxScore int64 = 0
    for numberOfOperations > 0 {
        currentMaxValue := heap.Pop(&maxHeap).(int)
        newValue := int(math.Ceil((float64(currentMaxValue) / DIVISOR_TO_OBTAIN_NEW_VALUE)))

        maxScore += int64(currentMaxValue)
        heap.Push(&maxHeap, newValue)
        numberOfOperations--
    }
    return maxScore
}

type PriorityQueue []int

func (pq PriorityQueue) Len() int {
    return len(pq)
}

func (pq PriorityQueue) Less(first int, second int) bool {
    return pq[first] > pq[second]
}

func (pq PriorityQueue) Swap(first int, second int) {
    pq[first], pq[second] = pq[second], pq[first]
}

func (pq *PriorityQueue) Push(value any) {
    *pq = append(*pq, value.(int))
}

func (pq *PriorityQueue) Pop() any {
    value := (*pq)[pq.Len() - 1]
    *pq = (*pq)[0 : pq.Len() - 1]
    return value
}
