package com.xhx.lc;

public class LC680 {
    public static void main(String[] args) {
        String str = "cupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu";
        //str = "ebcbbececabbacecbbcbe";
        str = "pidbliassaqozokmtgahluruufwbjdtayuhbxwoicviygilgzduudzgligyviciowxbhuyatdjbwfuurulhagtmkozoqassailbdip";
        System.out.println(new LC680().validPalindrome(str));
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        boolean flag = true;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            }else {
                flag = isPalindrome(s, i+1, j)||isPalindrome(s, i, j-1);
                break;
            }

        }

        return flag;

    }
    public boolean isPalindrome(String s, int i, int j){
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;

    }
}
