// 1109. Corporate Flight Bookings

// There are n flights that are labeled from 1 to n.
// You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.
// Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.

// Example 1:

// Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
// Output: [10,55,45,25,25]
// Explanation:
// Flight labels:        1   2   3   4   5
// Booking 1 reserved:  10  10
// Booking 2 reserved:      20  20
// Booking 3 reserved:      25  25  25  25
// Total seats:         10  55  45  25  25
// Hence, answer = [10,55,45,25,25]
// Example 2:

// Input: bookings = [[1,2,10],[2,2,15]], n = 2
// Output: [10,25]
// Explanation:
// Flight labels:        1   2
// Booking 1 reserved:  10  10
// Booking 2 reserved:      15
// Total seats:         10  25
// Hence, answer = [10,25]

// Constraints:

// 1 <= n <= 2 * 104
// 1 <= bookings.length <= 2 * 104
// bookings[i].length == 3
// 1 <= firsti <= lasti <= n
// 1 <= seatsi <= 104

class Solution {
    // Overall Space Complexity - O(N) => for the ans array
    // Overall Time Complexity - O(M + N) => where M is book.length and N is number of flights
    // Technique Used - Difference Array & Prefix Sum
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int m = bookings.length;

        // Using Difference Array Technique
        // TC - O(m) -> bookings.length
        for (int i = 0; i < m; i++) {
            int f = bookings[i][0] - 1;
            int l = bookings[i][1];

            ans[f] += bookings[i][2];
            if (l != n)
                ans[l] += (-bookings[i][2]);
        }

        // prefix sum
        // TC: O(n)
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + ans[i];
        }

        return ans;
    }
}