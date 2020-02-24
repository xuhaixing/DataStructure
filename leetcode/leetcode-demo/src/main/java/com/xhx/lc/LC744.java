package com.xhx.lc;

public class LC744 {
    public static void main(String[] args) {
        char g = new LC744().nextGreatestLetter(new char[]{'e', 'e', 'e','n'}, 'g');
        System.out.println(g);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        if(target < letters[l] || target >= letters[r]){
            return letters[l];
        }

        while(l <= r){
            int mid = l + (r-l)/2;
            if(letters[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return l < letters.length?letters[l]:letters[0];
    }
}
