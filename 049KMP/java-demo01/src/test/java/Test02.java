import org.junit.Test;

import java.util.Arrays;

/**
 * next[0] = -1 版本
 */
public class Test02 {


    @Test
    public void test02() {
        boolean contains = kmp("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
        System.out.println(contains);
    }


    public boolean kmp(String source, String pattern) {
        int[] next = getNext(pattern);

        for (int i = 0, j = 0; i < source.length(); i++) {
            while (j > 0 && source.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            if (source.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            if (j == pattern.length()) {
                return true;
            }
        }
        return false;
    }


    @Test
    public void test01() {
        String pattern = "ababaa"; //[-1, 0, 0, 1, 2, 3]
        int[] next = getNext(pattern);
        System.out.println(Arrays.toString(next));
        int[] next2 = getNext2(pattern);
        System.out.println(Arrays.toString(next2));
    }


    /**
     * 构造next数组
     *
     * @param pattern
     * @return
     */
    public int[] getNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        //i一直向前走，不回退.    不匹配时，j回退
        for (int i = 1, j = 0; i < pattern.length() - 1; ) {
            //后缀不相同的情况，这种情况放在前面
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j];
            }
            //后缀相同，这种情况放在后main
            if (j >= 0 && pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }
            i++;
            //赋值next[i]
            next[i] = j;
        }
        return next;
    }

    public int[] getNext2(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1; next[1] = 0;
        int i = 1, j = 0;
        while (i < pattern.length() - 1) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

}
