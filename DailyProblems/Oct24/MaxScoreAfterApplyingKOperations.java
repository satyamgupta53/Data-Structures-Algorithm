package DailyProblems.Oct24;

/* Problem Description ->
You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.

In one operation:
choose an index i such that 0 <= i < nums.length,
increase your score by nums[i], and
replace nums[i] with ceil(nums[i] / 3).
Return the maximum possible score you can attain after applying exactly k operations.

The ceiling function ceil(val) is the least integer greater than or equal to val.

Example 1:
Input: nums = [10,10,10,10,10], k = 5
Output: 50
Explanation: Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.

Example 2:
Input: nums = [1,10,3,3,3], k = 3
Output: 17
Explanation: You can do the following operations:
Operation 1: Select i = 1, so nums becomes [1,4,3,3,3]. Your score increases by 10.
Operation 2: Select i = 1, so nums becomes [1,2,3,3,3]. Your score increases by 4.
Operation 3: Select i = 2, so nums becomes [1,1,1,3,3]. Your score increases by 3.
The final score is 10 + 4 + 3 = 17.

Constraints:
1 <= nums.length, k <= 105
1 <= nums[i] <= 109
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxScoreAfterApplyingKOperations {
    public static void main(String[] args) {
        int[] nums = {1, 10, 3, 3, 3};
        int k = 3;
        System.out.println("Output : " + maxKelements(nums, k));
    }

    // time complexity: klogn(inserting k times) + nlogn(inserting n elements)
    public static long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        Arrays.stream(nums).forEach(maxHeap::add);

        while (k-- > 0) {
            int temp = 0;
            if (maxHeap.peek() != null) {
                temp = maxHeap.poll();
                score += temp;
                maxHeap.add((int) Math.ceil(temp / 3.0));
            } else {
                System.out.println("Null pointer exception.");
                break;
            }
        }
        return score;
    }

    /* Notes ->
    Use minimum functions in your code as possible -
    Ceil -> (num+2/3)
    Comparator.reverseOrder() -> ((a,b) -> b-a)
    No error handling required, use offer() & poll()
    initialise temp outside loop (takes more time to initialise every time)
    Arrays.stream(nums).forEach(maxHeap::add) -> for(int num : nums) maxHeap.offer(num);
     */
}
