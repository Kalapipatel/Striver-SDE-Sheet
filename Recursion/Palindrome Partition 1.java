/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.


Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters.
*/

class Solution {
    public void fun(int idx, String s, List<List<String>> ans, List<String> list){
        if(idx == s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i=idx; i<s.length(); i++){
            if(isPalindrome(s, idx, i)){
                list.add(s.substring(idx, i+1));
                fun(i+1, s, ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    boolean isPalindrome(String str, int s, int e){
        while(s <= e){
            if(str.charAt(s++) != str.charAt(e--)) return false;
        }
        return true;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        fun(0, s, ans, list);
        return ans;
    }
}
