// Find the number of islands

// Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

// Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

// Examples:

// Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], 
//                 ['W', 'L', 'W', 'W', 'L'], 
//                 ['L', 'W', 'W', 'L', 'L'], 
//                 ['W', 'W', 'W', 'W', 'W'], 
//                 ['L', 'W', 'L', 'L', 'W']]
// Output: 4
// Explanation:
// The image below shows all the 4 islands in the grid.
 
// Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], 
//                 ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
// Output: 2
// Expanation:
// The image below shows 2 islands in the grid.
 
// Constraints:
// 1 ≤ n, m ≤ 500
// grid[i][j] = {'L', 'W'}

// Expected Complexities
// Time Complexity: O(n * m)
// Auxiliary Space: O(n * m)

// Problem Link: https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

class Solution {
    public void bfs(int x, int y, boolean[][] vis, char[][] grid, Queue<int[]> q){
        q.offer(new int[]{x,y});
        vis[x][y]=true;
        int n=grid.length;
        int m=grid[0].length;
        
        while(!q.isEmpty()){
            int[] pair=q.poll();
            int i=pair[0];
            int j=pair[1];
            
            // // up
            // if(i>0 && !vis[i-1][j] && grid[i-1][j]=='L') {
            //     q.offer(new int[]{i-1,j});
            //     vis[i-1][j]=true;
            // }
            // // down
            // if(i<grid.length-1 && !vis[i+1][j] && grid[i+1][j]=='L'){
            //     q.offer(new int[]{i+1,j});
            //     vis[i+1][j]=true;
            // }

            // // left
            // if(j>0 && !vis[i][j-1] && grid[i][j-1]=='L'){
            //     q.offer(new int[]{i,j-1});
            //     vis[i][j-1]=true;
            // }

            // // right
            // if(j<grid[0].length-1  && !vis[i][j+1] && grid[i][j+1]=='L'){
            //     q.offer(new int[]{i,j+1});
            //     vis[i][j+1]=true;
            // }
            
            // // top-left
            // if(i>0 && j>0  && !vis[i-1][j-1] && grid[i-1][j-1]=='L'){
            //     q.offer(new int[]{i-1,j-1});
            //     vis[i-1][j-1]=true;
            // }
            
            // // top-right
            // if(i>0 && j<grid[0].length-1  && !vis[i-1][j+1] && grid[i-1][j+1]=='L'){
            //     q.offer(new int[]{i-1,j+1});
            //     vis[i-1][j+1]=true;
            // }
            
            // // bottom-left
            // if(i<grid.length-1 && j>0  && !vis[i+1][j-1] && grid[i+1][j-1]=='L'){
            //     q.offer(new int[]{i+1,j-1});
            //     vis[i+1][j-1]=true;
            // }
            
            // // bottom-right
            // if(i<grid.length-1 && j<grid[0].length-1  && !vis[i+1][j+1] && grid[i+1][j+1]=='L'){
            //     q.offer(new int[]{i+1,j+1});
            //     vis[i+1][j+1]=true;
            // }
            
            
            
            // Shortcut: Everything is from -1 to +1
            for(int del_i=-1;del_i<=1; del_i++){
                for(int del_j=-1;del_j<=1;del_j++){
                    int nei_row=i+del_i;
                    int nei_col=j+del_j;
                    
                    if(nei_row>=0 && nei_row<n && nei_col>=0 && nei_col<m && !vis[nei_row][nei_col] && grid[nei_row][nei_col]=='L'){
                        vis[nei_row][nei_col]=true;
                        q.offer(new int[]{nei_row,nei_col});
                    }
                }
            }
        }
    }
    
    public int countIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        int c=0;
        for(int i=0; i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='L' && !vis[i][j]){
                    bfs(i,j,vis,grid,q);
                    c++;
                }
            }
        }
        return c;
        
    }
}