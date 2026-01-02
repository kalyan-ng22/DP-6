// Time Complexity : O(n^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : At each index position of the string, we can try to expand left and right pointers if the characters are equal and capture
// the longest palindrome. This logic works for odd length palindrome but for even we need to check if consecutive characters are equal and
// then perform this logic.

class Solution {
    public String longestPalindrome(String s) {
        int[] res = new int[2];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            extend(s, i, i, res); //odd length palindrome check
            if (i != n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                extend(s, i, i + 1, res); //even length palindrome check
            }
        }
        int start = res[0];
        int end = res[1];
        return s.substring(start, end + 1);
    }

    private void extend(String s, int l, int r, int[] res) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) { //is palindrome
            l--; //move left and right pointers
            r++;
        }
        l++; //move back to previous position when above condition is failed
        r--;
        if (res[1] - res[0] < r - l) {
            res[0] = l; //max left position
            res[1] = r; //max right position
        }
    }
}