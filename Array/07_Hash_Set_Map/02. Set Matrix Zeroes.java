// 73. Set Matrix Zeroes (or) Zero Stripping

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 

// Constraints:
// m == matrix.length
// n == matrix[0].length
// 1 <= m, n <= 200
// -231 <= matrix[i][j] <= 231 - 1
 

// Follow up:
// A straightforward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?


// Problem Link: https://leetcode.com/problems/set-matrix-zeroes/
class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        // Approach 1:
        // TC: O(n*m)   SC: O(n+m)
        // Set<Integer> zeroRows = new HashSet<>();
        // Set<Integer> zeroCols = new HashSet<>();

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j]==0) {
        //             zeroRows.add(i);
        //             zeroCols.add(j);
        //         }
        //     }
        // }

        // for(int i:zeroRows){
        //     for(int j=0;j<m;j++){
        //         matrix[i][j]=0;
        //     }
        // }

        // for(int j:zeroCols){
        //     for(int i=0;i<n;i++){
        //         matrix[i][j]=0;
        //     }
        // }


        // Approach 2: 
        // TC: O(n*m)   SC:O(1)
        // Technique: make the 1st row and col be the header where the zero-th row and col marked as zeros when respective row and col
        boolean firstRow=false;
        boolean firstCol=false;

        for(int i=0;i<n;i++) {
            if(matrix[i][0]==0) {
                firstCol=true;
                break;
            }
        }
        for(int j=0;j<m;j++) {
            if(matrix[0][j]==0) {
                firstRow=true;
                break;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRow){
            for(int j=0;j<m;j++) {
                matrix[0][j]=0;
            }
        }

        if(firstCol){
            for(int i=0;i<n;i++) {
                matrix[i][0]=0;
            }
        }
    }
}