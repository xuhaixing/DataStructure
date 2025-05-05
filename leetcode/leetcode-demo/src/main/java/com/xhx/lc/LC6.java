package com.xhx.lc;

public class LC6 {

    public static void main(String[] args) {
        String aa = new LC6().convert("PAYPALISHIRING", 3);
        System.out.println(aa);
    }

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int gap = numRows + numRows - 2; //一个轮回
    /*    int frontSpace;
        int backSpace;*/
        //有几个轮回
        int columns = s.length() / gap;
        columns = s.length() % gap == 0 ? columns : columns + 1;
        for (int i = 0; i < numRows; i++) {
            int start = i;
           /* if (i == 0) {
                frontSpace = numRows - 2;
                backSpace = 0;
            } else if (i == numRows - 1) {
                frontSpace = 0;
                backSpace = numRows - 2;
            } else {
                frontSpace = numRows - 2 - i;
                backSpace = numRows - 2 - frontSpace - 1;
            }*/
            for (int t = 0; t < columns; t++) {
                if (start < s.length()) {
                    //System.out.print(s.charAt(start));
                    sb.append(s.charAt(start));
                }
                /*for (int space = 0; space < frontSpace; space++) {
                    System.out.print(" ");
                }*/

                if(!(i == 0 ||i == numRows - 1)){
                    int  next = start + gap - i*2;
                    if (next < s.length()) {
                        //System.out.print(s.charAt(next));
                        sb.append(s.charAt(next));
                    }
                }
             /*   for (int space = 0; space < backSpace; space++) {
                    System.out.print(" ");
                }*/
                start = start + gap;

            }

           // System.out.println();

        }
        return sb.toString();
    }
}
