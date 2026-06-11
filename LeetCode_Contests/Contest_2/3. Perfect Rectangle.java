package Contest_2;

// Q3. Perfect Rectangle

// Given an array rectangles where rectangles[i] = [xi, yi, ai, bi] represents an axis-aligned rectangle. The bottom-left point of the rectangle is (xi, yi) and the top-right point of it is (ai, bi).
// Return true if all the rectangles together form an exact cover of a rectangular region.

// Example 1:
// Input: rectangles = [[1,1,3,3],[3,1,4,2],[3,2,4,4],[1,3,2,4],[2,3,3,4]]
// Output: true
// Explanation: All 5 rectangles together form an exact cover of a rectangular region.

// Example 2:
// Input: rectangles = [[1,1,2,3],[1,3,2,4],[3,1,4,2],[3,2,4,4]]
// Output: false
// Explanation: Because there is a gap between the two rectangular regions.

// Example 3:
// Input: rectangles = [[1,1,3,3],[3,1,4,2],[1,3,2,4],[2,2,4,4]]
// Output: false
// Explanation: Because two of the rectangles overlap with each other.

// Constraints:
// 1 <= rectangles.length <= 2 * 104
// rectangles[i].length == 4
// -105 <= xi < ai <= 105
// -105 <= yi < bi <= 105

// Problem Link: https://leetcode.com/contest/leetcode-weekly-contest-2/problems/perfect-rectangle/description/
import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rect) {
        Set<String> set = new HashSet<>();
        int area = 0;
        int minX, minY, maxX, maxY;
        minX = minY = Integer.MAX_VALUE;
        maxX = maxY = Integer.MIN_VALUE;

        for (int[] r : rect) {
            minX = Math.min(minX, r[0]);
            minY = Math.min(minY, r[1]);
            maxX = Math.max(maxX, r[2]);
            maxY = Math.max(maxY, r[3]);

            area += (r[2] - r[0]) * (r[3] - r[1]);

            String[] corners = {
                    r[0] + "," + r[1],
                    r[0] + "," + r[3],
                    r[2] + "," + r[1],
                    r[2] + "," + r[3]
            };

            for (String c : corners) {
                if (!set.add(c))
                    set.remove(c);
            }
        }

        int totArea = (maxX - minX) * (maxY - minY);
        if (totArea != area || set.size() != 4)
            return false;

        return set.contains(minX + "," + minY) &&
                set.contains(minX + "," + maxY) &&
                set.contains(maxX + "," + minY) &&
                set.contains(maxX + "," + maxY);
    }
}