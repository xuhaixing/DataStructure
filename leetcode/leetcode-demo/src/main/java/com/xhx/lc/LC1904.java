package com.xhx.lc;

import org.junit.Test;

/**
 * @description:
 *
 * 1904. 你完成的完整对局数
 * 一款新的在线电子游戏在近期发布，在该电子游戏中，以 刻钟 为周期规划若干时长为 15 分钟 的游戏对局。这意味着，在 HH:00、HH:15、HH:30 和 HH:45 ，将会开始一个新的对局，其中 HH 用一个从 00 到 23 的整数表示。游戏中使用 24 小时制的时钟 ，所以一天中最早的时间是 00:00 ，最晚的时间是 23:59 。
 *
 * 给你两个字符串 startTime 和 finishTime ，均符合 "HH:MM" 格式，分别表示你 进入 和 退出 游戏的确切时间，请计算在整个游戏会话期间，你完成的 完整对局的对局数 。
 *
 * 例如，如果 startTime = "05:20" 且 finishTime = "05:59" ，这意味着你仅仅完成从 05:30 到 05:45 这一个完整对局。而你没有完成从 05:15 到 05:30 的完整对局，因为你是在对局开始后进入的游戏；同时，你也没有完成从 05:45 到 06:00 的完整对局，因为你是在对局结束前退出的游戏。
 * 如果 finishTime 早于 startTime ，这表示你玩了个通宵（也就是从 startTime 到午夜，再从午夜到 finishTime）。
 *
 * 假设你是从 startTime 进入游戏，并在 finishTime 退出游戏，请计算并返回你完成的 完整对局的对局数 。
 *
 *
 * @author: xuhaixing
 * @Date: 2021/12/14 11:08 下午
 */
public class LC1904 {

    @Test
    public void test01() {
        Solution solution = new Solution();
        int count = solution.numberOfRounds("12:02", "12:20");//0
//        int count = solution.numberOfRounds("09:31", "10:14"); //1
//        int count = solution.numberOfRounds("00:00", "23:59"); //95
//        int count = solution.numberOfRounds("20:00", "06:00"); //40
//        int count = solution.numberOfRounds("00:47", "00:57"); //0
        System.out.println(count);
    }


    class Solution {
        public int numberOfRounds(String startTime, String finishTime) {
            String[] start = startTime.split(":");
            String[] end = finishTime.split(":");

            Integer startHour = Integer.valueOf(start[0]);
            Integer startMin = Integer.valueOf(start[1]);

            Integer endHour = Integer.valueOf(end[0]);
            Integer endMin = Integer.valueOf(end[1]);

            if (finishTime.compareTo(startTime) < 1) {
                endHour += 24;
            }

            if (startMin % 15 != 0) {
                startMin = (startMin / 15 + 1) * 15;
            }

            return Math.max((endHour - startHour - 1) * 4 + (60 - startMin) / 15 + endMin / 15, 0);
        }
    }

    /**
     * 更好理解
     */
    class Solution2 {
        public int numberOfRounds(String startTime, String finishTime) {
            int sHour = Integer.parseInt(startTime.substring(0, 2)), sMin = Integer.parseInt(startTime.substring(3, 5));//起始小时、分钟
            int fHour = Integer.parseInt(finishTime.substring(0, 2)), fMin = Integer.parseInt(finishTime.substring(3, 5));//结束小时、分钟
            if (fHour < sHour || (fHour == sHour && fMin < sMin))//判断是否通宵
                fHour += 24;
            int ans = (fHour - sHour) * 4;//[起始小时,结束小时)内对局数
            ans -= (sMin + 14) / 15;//减去起始小时中未完整进行的对局数
            ans += fMin / 15;//增加结束小时中完整进行的对局数
            return Math.max(ans, 0);//避免无完整对局时重复相减，造成负数答案
        }
    }
}
