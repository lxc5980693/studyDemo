package com.lixuanchen.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: algorithm_demo
 * @Package: com.lixuanchen.algorithm
 * @ClassName: Demo01
 * @Author: lixuanchen
 * @Description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * @Date: 2020-02-05  17:51
 * @Version: 1.0
 */
public class Demo01 {
    public static void main(String[] args) throws IllegalAccessException {
        int[] arr = new int[]{3,2,4};
        int[] ints = twoSumNew(arr, 6);
        System.out.println(ints[0] + " " + ints[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    public static int[] twoSumNew(int[] nums, int target) throws IllegalAccessException {
        Map<Integer,Integer> maps = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int numTwo = target - nums[i];
            if (maps.containsKey(numTwo)){
                return new int[]{maps.get(numTwo),i};
            }
            maps.put(nums[i],i);
        }
        throw new IllegalAccessException("no two num sum solution");
    }
}
