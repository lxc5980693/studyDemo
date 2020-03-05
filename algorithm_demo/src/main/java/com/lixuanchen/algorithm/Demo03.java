package com.lixuanchen.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: algorithm_demo
 * @Package: com.lixuanchen.algorithm
 * @ClassName: Demo03
 * @Author: lixuanchen
 * @Description: 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @Date: 2020-02-05  20:19
 * @Version: 1.0
 */
public class Demo03 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * 思路：设置一个start和end指针，end向后遍历，有map对遍历的每个字符进行存储key为字符 value为end+1下标，
     * 如果遍历到某个字符时，map中存在的话，则更新start的下标，将start的下标更新为当前map存储的字符的下标。
     * 保证[start,end]这个区间之内的字符串都为不同子串。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int ans = 0;
        Map<Character, Integer> maps = new HashMap<Character, Integer>();
        int length = chars.length;
        for (int start = 0, end = 0; end < length; end++) {
            Character character = chars[end];
            if (maps.containsKey(character)) {
                start = Math.max(maps.get(character), start);
            }
            ans = Math.max(end - start + 1, ans);
            maps.put(chars[end], end + 1);
        }
        return ans;
    }
}
