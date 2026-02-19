/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
Example 1:
Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:
Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.
*/

class Solution {
    public TreeNode fun(int nums[], int s, int e){
        if(s > e) return null;

        int mid = (s + e)/2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = fun(nums, s, mid-1);
        root.right = fun(nums, mid+1, e);

        return root;

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = fun(nums, 0, n-1);

        return root;
    }
}
