// Remove Duplicates Sorted Array

// You are given a sorted array arr[] containing positive integers. Your task is to remove all duplicate elements from this array such that each element appears only once. Return an array containing these distinct elements in the same order as they appeared.
// Examples :

// Input: arr[] = [2, 2, 2, 2, 2]
// Output: [2]
// Explanation: After removing all the duplicates only one instance of 2 will remain i.e. [2] so modified array will contains 2 at first position and you should return array containing [2] after modifying the array.
// Input: arr[] = [1, 2, 4]
// Output: [1, 2, 4]
// Explation:  As the array does not contain any duplicates so you should return [1, 2, 4].
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 106

// Expected Complexities
// Time Complexity: O(n)
// Auxiliary Space: O(1)

// Problem Link: https://www.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1
import java.util.*;
// TC: O(2n)
// SC: O(k) ->k distinct elements
class Solution1 {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        int replace=-1, distinct=1, prev=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++){
            if(prev==arr[i]){
                arr[i]=replace;
            } else {
                distinct++;
                prev=arr[i];
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]!=replace) res.add(arr[i]);
        }
        return res;
    }
}
// TC: O(n+k) ->k distinct elements
// SC: O(k)
class Solution2 {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        int i=0;
        int n=arr.length;
        for(int j=0;j<n;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        
        for(int x=0;x<=i;x++) res.add(arr[x]);
        
        return res;
    }
}

