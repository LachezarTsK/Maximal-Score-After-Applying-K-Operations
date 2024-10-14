
import java.util.PriorityQueue
import kotlin.math.ceil

class Solution {

    private companion object {
        const val DIVISOR_TO_OBTAIN_NEW_VALUE = 3
    }

    fun maxKelements(input: IntArray, numberOfOperations: Int): Long {
        var numberOfOperations = numberOfOperations
        val maxHeap = PriorityQueue<Int>() { x, y -> y - x }
        for (value in input) {
            maxHeap.add(value)
        }

        var maxScore: Long = 0
        while (numberOfOperations > 0) {
            val currentMaxValue = maxHeap.poll()
            val newValue = ceil(currentMaxValue.toDouble() / DIVISOR_TO_OBTAIN_NEW_VALUE).toInt()

            maxScore += currentMaxValue
            maxHeap.add(newValue)
            --numberOfOperations
        }
        return maxScore
    }
}
