package com.practice.google.arraysAndStrings;

/*
3. Longest Substring Without Repeating Characters
Medium

Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        //The approach here is to store each visited character and its index into a map. When the character is seen again,
        // move the pointer to the highest index where it is seen at.

        int len = s.length();
        int j=0;
        int res = 0;
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                j = Math.max(map.get(c),j);
            }
            res = Math.max(res, i-j+1);
            map.put(c,i+1);
        }
        return res;
    }
}
