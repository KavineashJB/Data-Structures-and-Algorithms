// Floor in BST

// Given a root binary search tree and an integer x. your task is to find the greatest value node of the BST which is smaller than or equal to x.
// Note: when x is smaller than the smallest node of BST then returns -1.

// Examples:

// Input:
//                     2
//                      \
//                       81
//                     /    \
//                  42       87
//                    \       \
//                     66      90
//                    /
//                  45
// x = 87
// Output: 87
// Explanation: 87 is present in tree so floor will be 87.

// Input:
//                           6
//                            \
//                             8
//                           /   \
//                         7       9
// x = 11
// Output: 9

// Input:
//                           6
//                            \
//                             8
//                           /   \
//                         7       9
// x = 5
// Output: -1
// Constraint:
// 1 ≤ Number of nodes ≤ 105
// 1 ≤ x, Value of Node ≤ 106

// Expected Complexities
// Time Complexity: O(h)
// Auxiliary Space: O(h)


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution_Floor {
    
    public int findFloor(Node root, int x) {
        Node curr=root;
        int mini=-1;
        while(curr!=null){
            if(x==curr.data) return x;
            else if(x<curr.data) {
                curr=curr.left;
            } else {
                mini=curr.data;
                curr=curr.right;
            }
        }
        
        return mini;
    }
}

// Ceil in BST

// You are given a root binary search tree and an integer x . Your task is to find the Ceil of x in the tree.
// Note: Ceil(x) is a number that is either equal to x or is immediately greater than x.
// If Ceil could not be found, return -1.

// Examples:

// Input: root = [5, 1, 7, N, 2, N, N, N, 3], x = 3

// Output: 3
// Explanation: We find 3 in BST, so ceil of 3 is 3.
// Input: root = [10, 5, 11, 4, 7, N, N, N, N, N, 8], x = 6

// Output: 7
// Explanation: We find 7 in BST, so ceil of 6 is 7.
// Constraints:
// 1  ≤ Number of nodes  ≤ 105
// 1  ≤ Value of nodes ≤ 105

// Expected Complexities
// Time Complexity: O(log n)
// Auxiliary Space: O(1)


class Solution_Ceil {
    int findCeil(Node root, int x) {
        Node curr=root;
        int maxi=-1;
        while(curr!=null){
            if(x==curr.data) return x;
            else if(x<curr.data){
                maxi=curr.data;
                curr=curr.left;
            } else {
                curr=curr.right;
            }
        }
        return maxi;
    }
}
