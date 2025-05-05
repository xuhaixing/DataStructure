package com.xhx.lc;

import java.util.ArrayList;
import java.util.List;

public class LC17 {

    public static void main(String[] args) {
        List<String> results = new LC17().letterCombinations("89");
        System.out.println(results);
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = digits.toCharArray();
        dfs(chars, 0);
        return resultList;
    }


    List<String> resultList = new ArrayList<>();
    StringBuffer sb = new StringBuffer();

    private void dfs(char[] chars, int i) {
        if (i == chars.length) {
            resultList.add(sb.toString());
            return;
        }
        int tem = chars[i] - '0';
        //7 和 9 字母多一个
        char ch = (char) ((tem - 2) * 3 + 'a');
        int count = tem == 7 || tem == 9 ? 4 : 3;
        if(tem  > 7){
            ch +=1;
        }
        for (int j = 0; j < count; j++) {
            char ch2 = (char) (ch + j);
            sb.append(ch2);
            dfs(chars, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
