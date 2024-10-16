package DailyProblems.Oct24;

/* Problem Statement ->
A string s is called happy if it satisfies the following conditions:
s only contains the letters 'a', 'b', and 'c'.
s does not contain any of "aaa", "bbb", or "ccc" as a substring.
s contains at most an occurrences of the letter 'a'.
s contains at most b occurrences of the letter 'b'.
s contains at most c occurrences of the letter 'c'.
Given three integers a, b, and c, return the longest possible happy string.
If there are multiple longest happy strings, return any of them.
If there is no such string, return the empty string "".
A substring is a contiguous sequence of characters within a string.

Example 1
Input: a = 1, b = 1, c = 7
Output: "ccaccbcc"
Explanation: "ccbccacc" would also be a correct answer.

Example 2:
Input: a = 7, b = 1, c = 0
Output: "aabaa"
Explanation: It is the only correct answer in this case.

Constraints:
0 <= a, b, c <= 100
a + b + c > 0
 */

import java.util.PriorityQueue;

public class LongestHappyString {
    public static void main(String[] args) {
        int a = 1, b = 1, c = 7;
        String res = optimisedApproach(a, b, c);
        System.out.println("Output : " + res);
    }

    private static String generateHappyString(int a, int b, int c) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.count - x.count);
        if (a > 0) maxHeap.offer(new Pair(a, 'a'));
        if (b > 0) maxHeap.offer(new Pair(b, 'b'));
        if (c > 0) maxHeap.offer(new Pair(c, 'c'));

        StringBuilder output = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            int count = pair.count;
            char character = pair.character;
            if (output.length() >= 2
                    && output.charAt(output.length() - 1) == character
                    && output.charAt(output.length() - 2) == character) {
                if (maxHeap.isEmpty()) break;
                Pair secondHighest = maxHeap.poll();
                output.append(secondHighest.character);
                if (secondHighest.count - 1 > 0) {
                    maxHeap.offer(new Pair(secondHighest.count - 1, secondHighest.character));
                }
            } else {
                count--;
                output.append(character);
            }

            if (count > 0) {
                maxHeap.offer(new Pair(count, character));
            }
        }
        return output.toString();
    }

    private static String optimisedApproach(int a, int b, int c) {
        StringBuilder output = new StringBuilder();
        int countA = 0, countB = 0, countC = 0;
        int totalIterations = a + b + c;

        for (int i = 0; i < totalIterations; i++) {
            if ((a >= b && a >= c && countA != 2) || (a > 0 && countB == 2) || (a > 0 && countC == 2)) {
                output.append('a');
                a--;
                countA++;
                countB = countC = 0;
            } else if ((b >= a && b >= c && countB != 2) || (countA == 2 && b > 0) || (countC == 2 && b > 0)) {
                output.append('b');
                b--;
                countB++;
                countA = countC = 0;
            } else if ((c >= a && c >= b && countC != 2) || (countA == 2 && c > 0) || (countB == 2 && c > 0)) {
                output.append('c');
                c--;
                countC++;
                countB = countA = 0;
            }
        }
        return output.toString();
    }

    static class Pair {
        int count;
        char character;

        Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }
}
