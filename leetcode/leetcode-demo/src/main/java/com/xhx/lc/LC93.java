package com.xhx.lc;

import java.util.ArrayList;
import java.util.List;

public class LC93 {

    public static void main(String[] args) {
        List<String> strings = new LC93().restoreIpAddresses("0000");
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {

        StringBuffer sb = new StringBuffer();
        List<String> results = new ArrayList<>();
        doRestore(s, sb, results, 0, 0);

        return results;
    }

    /**
     * @param s
     * @param sb
     * @param results
     * @param p       组合到第几段ip了
     * @param q       搜索到原字符串的第几个下标
     */
    private void doRestore(String s, StringBuffer sb, List<String> results, int p, int q) {
        if (p == 4 || q >= s.length()) {
            if (p == 4 && q == s.length()) {
                results.add(sb.toString());
            }
            return;
        }
        int i = 0;
        if (s.length() == 12) {
            i = 2;
        }else if(s.length() == 11){
            i = 1;
        }
        for (; i < 3; i++) {
            if (q + i >= s.length()) {
                break;
            }
            char c = s.charAt(q);
            if (c == '0' && i != 0) {
                break;
            }

            String substring = s.substring(q, q + i + 1);
            if (Integer.valueOf(substring) <= 255) {
                if (q != 0) {
                    substring = "." + substring;
                }
                sb.append(substring);
                doRestore(s, sb, results, p + 1, q + i + 1);
                sb.delete(sb.length() - substring.length(), sb.length());
            }

        }

    }
}
