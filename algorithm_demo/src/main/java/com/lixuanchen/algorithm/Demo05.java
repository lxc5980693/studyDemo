package com.lixuanchen.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: algorithm_demo
 * @Package: com.lixuanchen.algorithm
 * @ClassName: Demo05
 * @Author: lixuanchen
 * @Description: 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * @Date: 2020-07-22  10:09
 * @Version: 1.0
 */
public class Demo05 {

    public static void main(String[] args) {
        String babad = test("aaabaaaa");
        System.out.println(babad);
    }

    /**
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 输入: "cbbd"
     * 输出: "bb"
     * 设置一个开始和结束的指针，end往后找，
     * 如果end指针所在的元素与start元素相等，则将该char作为key start-end的字符作为val。
     * 然后将start职位end的地方
     *
     * @param s
     * @return
     */
    public static String test(String s) {
        if (s == null) {
            return null;
        }
        if (s.trim() == "" || s.length() == 0) {
            return "";
        }
        List<String> list = new ArrayList<String>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = chars.length - 1; j > i; j--) {
                if (chars[i] == chars[j]) {
                    String substring = s.substring(i, j + 1);
                    if (new StringBuffer(substring).reverse().toString().equals(substring)) {
                        if (list.size() == 0) {
                            list.add(substring);
                        } else if (substring.length() > list.get(list.size() - 1).length()) {
                            list.add(substring);
                        }
                    }
                }
            }
        }
        if (list.size() == 0) {
            return s.substring(0, 1);
        }
        return list.get(list.size() - 1);
    }
}
