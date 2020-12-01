package com.xhx;

import java.util.ArrayDeque;
import java.util.Map;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 *
 * 栈
 */
public class LC20 {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = Map.of(')','(',  '}','{', ']',  '[');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty()){
                if(stack.getLast().equals(map.get(c))){
                    stack.removeLast();
                }else {
                    stack.addLast(c);
                }
            }else {
                stack.addLast(c);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

}
