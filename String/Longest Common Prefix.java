/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        int n = strs.length;
        String str1 = strs[0];
        String str2 = strs[n-1];

        int len = Math.min(str1.length(), str2.length());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
            }
            else break;
        }

        if(sb.length() == 0) return "";
        return sb.toString();
    }
}
