package Contest_1;

// Q1. Lexicographical Numbers

// Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

// You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

// Example 1:
// Input: n = 13
// Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]

// Example 2:
// Input: n = 2
// Output: [1,2]

// Constraints:
// 1 <= n <= 5 * 104

// Problem Link: https://leetcode.com/contest/warm-up-contest/problems/lexicographical-numbers/
import java.util.*;

class Solution {
    private void dfs(int currNum, int n, List<Integer> res) {
        if (currNum > n)
            return;

        res.add(currNum);
        for (int i = 0; i <= 9; i++) {
            dfs((currNum * 10) + i, n, res);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        // Why TC:O(n), SC:O(1)
        // SC:O(1) -> since the n<=5*10^4, the tree height increased by *10 each time.
        // so 1, 10, 100, 1000, 10000. So the max depth of tree is 5. So stack takes 5
        // space, which is constant. Hence the O(1).
        // TC:O(n) -> It saw all the nums between 1 to n.
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, res);
        }
        return res;
    }
}