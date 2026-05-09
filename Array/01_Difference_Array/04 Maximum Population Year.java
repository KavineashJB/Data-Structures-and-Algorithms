// 1854. Maximum Population Year

// You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.

// The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.

// Return the earliest year with the maximum population.

 

// Example 1:

// Input: logs = [[1993,1999],[2000,2010]]
// Output: 1993
// Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
// Example 2:

// Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
// Output: 1960
// Explanation: 
// The maximum population is 2, and it had happened in years 1960 and 1970.
// The earlier year between them is 1960.
 

// Constraints:

// 1 <= logs.length <= 100
// 1950 <= birthi < deathi <= 2050

// Problem Link: https://leetcode.com/problems/maximum-population-year/description/

class Solution {
    // Overall Space Complexity - O(1) => Array size is constant (102 elements)
    // Overall Time Complexity - O(N + Y) => Where N is logs.length and Y is the year range (101) both [1950,2050] inclusive
    public int maximumPopulation(int[][] logs) {
        int startYear = 1950; 
        int[] res = new int[102];

        // Using Difference Array Technique
        // TC - O(N)
        for (int[] row : logs) {
            int birth = row[0];
            int death = row[1];

            res[birth - startYear]++;
            res[death - startYear]--;
        }

        int maxLevel = res[0];
        int level = res[0];
        int minYear = startYear;

        // Time - O(Y) => Iterates through the fixed-size year array (101 steps)
        for (int i = 1; i <= 101; i++) {
            level += res[i]; // Cumulative sum gives actual population for the year (instead of calculating Prefix Sum in separate for loop)

            // Using strictly greater (>) ensures we pick the earliest year in a tie
            if (level > maxLevel) {
                minYear = startYear + i;
                maxLevel = level;
            }
        }

        return minYear;
    }
}