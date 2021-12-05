package com.xhx.lc;

import java.util.*;

public class LC127 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");
        int count = new LC127().ladderLength(beginWord, endWord, wordList);
        System.out.println(count);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean flag = false;
        for (String s : wordList) {
            if(s.equals(endWord)){
                flag =  true;
                break;
            }
        }
        if(!flag){
            return 0;
        }

        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 1;
        Set<String> strSet = new HashSet<>();
        strSet.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String node = queue.poll();
                if(node.equals(endWord)){
                    return count;
                }
                for (String str : wordList) {
                    if(strSet.contains(str)){
                        continue;
                    }
                    int changes = changeNums(node, str);
                    if(changes == 1){
                        queue.add(str);
                        strSet.add(str);
                    }
                }
            }
            count++;
        }
        return 0;
    }

    public int changeNums(String str1, String str2) {
        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
