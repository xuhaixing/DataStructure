package com.xhx.lc;

import java.util.*;
import java.util.stream.Collectors;

public class LC451 {

    public static void main(String[] args) {
        String result = new LC451().frequencySort("2a554442f544asfasssffffasss");
        System.out.println(result);
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        PriorityQueue<Node> nodes = new PriorityQueue<>((a,b)->b.count-a.count);
        map.forEach((k,v)->{
            nodes.add(new Node(k,v));
        });

        StringBuilder sb = new StringBuilder();
        while (!nodes.isEmpty()){
            Node node = nodes.poll();
            for(int i = 0; i < node.count; i++){
                sb.append(node.ch);
            }
        }
        return sb.toString();
    }
    static class Node{
        char ch;
        int count;
        public Node(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }
}
