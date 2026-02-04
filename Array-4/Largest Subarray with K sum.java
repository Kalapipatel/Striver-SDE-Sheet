/*
Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to 
the given value k. If there is no subarray with sum equal to k, return 0.

Examples:

Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
Output: 6
Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
Output: 5
Explanation: Subarrays with sum = -5 are [-5] and [-5, 8, -14, 2, 4]. The length of the longest subarray with a sum of -5 is 5.
Input: arr[] = [10, -10, 20, 30], k = 5
Output: 0
Explanation: No subarray with sum = 5 is present in arr[].
*/

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int max = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            
            if(sum == k){
                max = i+1;
            }
            
            int diff = sum - k;
            if(map.containsKey(diff)){
                int len = i - map.get(diff);
                max = Math.max(max, len);
            }
            
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        
        return max;
    }
}
