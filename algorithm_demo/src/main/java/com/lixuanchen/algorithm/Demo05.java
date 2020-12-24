package com.lixuanchen.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        String testStr = "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        System.out.println("str length: " + testStr.length());
        String babad = test(testStr);
        System.out.println(babad + "长度为：" + babad.length());
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
        String str = "";
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i <= str.length()){
                break;
            }
            for (int j = s.length() - 1; j > i; j--) {
                if (j - i + 1 <= str.length()){
                    break;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    String substring = s.substring(i, j + 1);
                    if (stringBuffer.length() > 0){
                        stringBuffer.delete(0, stringBuffer.length());
                    }
                    stringBuffer.append(substring);
                    if (stringBuffer.reverse().toString().equals(substring)) {
                        if (str.length() > 0) {
                            str = substring;
                            break;
                        } else if (substring.length() > str.length()) {
                            str = substring;
                            System.out.println(substring + "长度为：" + substring.length());
                            break;
                        }
                    }
                }
            }
        }
        if (str.length() == 0) {
            return s.substring(0, 1);
        }
        return str;
    }

    public static String test2(String s){
        char[] chars = s.toCharArray();
        int startIndex = 0;
        int endIndex = chars.length -1;
        String str = "";
        boolean flag = true;
        StringBuffer stringBuffer = new StringBuffer();
        while (flag){
            String substring = s.substring(startIndex, endIndex + 1);
            if (stringBuffer.length() > 0){
                stringBuffer.delete(0, stringBuffer.length());
            }
            stringBuffer.append(substring);
            if (stringBuffer.reverse().equals(substring) && substring.length() > str.length()){
                str = substring;
            }
            startIndex++;
        }
        return str;
    }
}
