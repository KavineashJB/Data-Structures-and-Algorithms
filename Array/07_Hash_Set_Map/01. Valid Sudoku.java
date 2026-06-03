// 36. Valid Sudoku

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
 

// Example 1:


// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
// Example 2:

// Input: board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

// Constraints:
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.


// Problem Link: https://leetcode.com/problems/valid-sudoku/
import java.util.*;
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            Set<Character> row=new HashSet<>();
            Set<Character> col=new HashSet<>();
            Set<Character> box=new HashSet<>();

            for(int j=0;j<m;j++){

                // row check
                if(board[i][j]!='.'){
                    if(!row.add(board[i][j])) return false;
                }

                // column check
                if(board[j][i]!='.'){
                    if(!col.add(board[j][i])) return false;
                }

                // box check - formula
                int r=3*(i/3) + j/3;
                int c=3*(i%3) + j%3;

                if(board[r][c]!='.'){
                    if(!box.add(board[r][c])) return false;
                }
            }
        }
        return true;
    }
}