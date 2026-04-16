/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/


class Solution {
    public void swap(int i, int j, int arr[]){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public void fun(int idx, int arr[], List<List<Integer>> ans){
        if(idx == arr.length){
            List<Integer> list = new ArrayList<>();

            for(int x : arr) list.add(x);
            ans.add(list);
            return;
        }

        for(int i=idx; i<arr.length; i++){
            swap(i, idx, arr);
            fun(idx+1, arr, ans);
            swap(i, idx, arr);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        fun(0, nums, ans);
        return ans;
    }
}
