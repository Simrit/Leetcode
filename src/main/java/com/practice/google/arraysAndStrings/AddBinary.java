package com.practice.google.arraysAndStrings;
/*
67. Add Binary
Easy

Given two binary strings a and b, return their sum as a binary string.



Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.
 */
public class AddBinary {
    public static void main(String [] args){
        addBinary("11","1");
    }
    public static String addBinary(String a, String b) {
        int la = a.length();
        int lb = b.length();
        char [] ans = new char[la];
        int carry = 0;
        if(la<lb)
            addBinary(b,a);

        for(int i=lb-1 ; i>=0; i--){
            char ai = a.charAt(i);
            char bi = b.charAt(i);
            if(ai=='0' && bi=='0' && carry==0){
                ans[i] = '0';
                carry=0;
            }
            else if(ai=='0' && bi=='0' && carry==1){
                ans[i] ='1';
                carry=0;
            }
            else if(ai=='0' && bi=='1' && carry==0){
                ans[i] ='1';
                carry=0;
            }
            else if(ai=='0' && bi=='1' && carry==1){
                ans[i] ='0';
                carry=1;

            }
            else if(ai=='1' && bi=='0' && carry==0){
                ans[i] ='1';
                carry=0;
            }
            else if(ai=='1' && bi=='0' && carry==1){
                ans[i] ='0';
                carry=1;
            }
            else if(ai=='1' && bi=='1' && carry==0){
                ans[i] ='0';
                carry=1;
            }
            else{
                ans[i] ='1';
                carry=1;
            }
        }
        for(int i=lb; i>=0;i--){
            char ai = a.charAt(i);
            if(ai=='0' && carry==0){
                ans[i] = '0';
                carry=0;
            }
            else if(ai=='0' && carry==1){
                ans[i] ='1';
                carry=0;
            }
            else if(ai=='1' && carry==0){
                ans[i] ='1';
                carry=0;
            }
            else if(ai=='1' && carry==1){
                ans[i] ='0';
                carry=1;

            }
        }
        if(carry==1)
            return new StringBuilder('1').append(String.valueOf(ans)).toString();
        else return String.valueOf(ans);
    }
}
