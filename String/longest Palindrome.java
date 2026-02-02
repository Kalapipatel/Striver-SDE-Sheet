/*
Given a string s, return the longest palindromic substring in s.
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 
Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }

        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++){
            int odd = expand(s, i, i);
            int even = expand(s, i, i+1);
            int max_len = Math.max(odd, even);

            if(max_len > end - start){
                start = i - (max_len - 1) / 2;
                end = i + max_len / 2;
            }
        }

        return s.substring(start, end+1);

    }

    private  int expand(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;
    }
}


/*
Algorithm Overview:
Initialize start and end variables to keep track of the starting and ending indices of the longest palindromic substring.
Iterate through each character of the input string s.
For each character, expand around it by calling the expand_around_center function with two different center possibilities: (i) the current character as 
the center (odd length palindrome), and (ii) the current character and the next character as the center (even length palindrome).
Compare the lengths of the two expanded palindromes and update start and end if a longer palindrome is found.
Finally, return the longest palindromic substring by slicing the input string s based on the start and end indices.
Detailed Explanation:
Check if the input string s is empty. If it is, return an empty string, as there can be no palindromic substring in an empty string.

Define a helper function expand_around_center that takes three arguments: the input string s, and two indices left and right. This function is responsible 
for expanding the palindrome around the center indices and returns the length of the palindrome.

Initialize start and end variables to 0. These variables will be used to keep track of the indices of the longest palindromic substring found so far.

Iterate through each character of the input string s using a for loop.

Inside the loop, call the expand_around_center function twice: once with i as the center for an odd length palindrome and once with i and i + 1 as the center
for an even length palindrome.

Calculate the length of the palindrome for both cases (odd and even) and store them in the odd and even variables.

Calculate the maximum of the lengths of the two palindromes and store it in the max_len variable.

Check if the max_len is greater than the length of the current longest palindromic substring (end - start). If it is, update the start and end variables to 
include the new longest palindromic substring. The new start is set to i - (max_len - 1) // 2, and the new end is set to i + max_len // 2.

Continue the loop until all characters in the input string have been processed.

After the loop, return the longest palindromic substring by slicing the input string s using the start and end indices. This substring is inclusive of the characters at the start and end indices.

Complexity
Time complexity: O(n 
2
 )
"n" is the length of the input string "s." This is because the code uses nested loops. The outer loop runs for each character in the string, and the inner 
loop, expand_around_center, can potentially run for the entire length of the string in the worst case, leading to a quadratic time complexity.

Space complexity: O(1)
the code uses a constant amount of extra space for variables like "start," "end," "left," "right," and function parameters. The space used does not depend on
the size of the input string.
*/
