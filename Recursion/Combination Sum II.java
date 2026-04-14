/*
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.


Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/

class Solution {
    public void fun(int arr[], int k, int idx, List<List<Integer>> ans, List<Integer> list){
        System.out.println("fun call for fun(" + idx + ", " + k + ")" );
        if(k == 0){
            ans.add(new ArrayList<>(list));
            System.out.println("list is added");
            System.out.println();
            return;
        }

        for(int i=idx; i<arr.length; i++){
          System.out.println("for i = " + i);
            if(i > idx && arr[i-1] == arr[i]){
                System.out.println("iteration is skipped for idx=" + idx +" and k=" + k);
                continue;
            }

            if(arr[i] > k) break;

            list.add(arr[i]);
            System.out.println(arr[i] + " is added to the list");
            fun(arr, k-arr[i], i+1, ans, list);
            System.out.println(list.get(list.size() - 1) + " is removed from list");
            list.remove(list.size() - 1);
            System.out.println();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();
        fun(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }
}
