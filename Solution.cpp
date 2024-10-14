
#include <cmath>
#include <vector>
using namespace std;

/*
The code will run faster with ios::sync_with_stdio(0).
However, this should not be used in production code and interactive problems.
In this particular problem, it is ok to apply ios::sync_with_stdio(0).

Many of the top-ranked C++ solutions for time on leetcode apply this trick,
so, for a fairer assessment of the time percentile of my code
you could outcomment the lambda expression below for a faster run.
*/

/*
const static auto speedup = [] {
    ios::sync_with_stdio(0);
    return nullptr;
}();
*/

class Solution {

    static const int DIVISOR_TO_OBTAIN_NEW_VALUE = 3;

public:
    long long maxKelements(const vector<int>& input, int numberOfOperations) const {
        priority_queue<int> maxHeap(input.begin(), input.end());

        long long maxScore = 0;
        while (numberOfOperations > 0) {
            int currentMaxValue = maxHeap.top();
            int newValue = ceil(static_cast<double>(currentMaxValue) / DIVISOR_TO_OBTAIN_NEW_VALUE);

            maxScore += currentMaxValue;
            maxHeap.pop();
            maxHeap.push(newValue);
            --numberOfOperations;
        }
        return maxScore;
    }
};
