package com.mp;

import java.util.Arrays;

/**
 * 最长递增子序列 递归算法
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums0={2,5,1,5,4,5};
        int[] nums1={1,4,3,4,2,3};
        int[] nums={1,1,1,1,1,1};
        System.out.println(getLengthOfLIS(nums));
    }
    public static int getLengthOfLIS(int[] nums){
        int n=nums.length;
        int[] dp=new int[n];//记录nums每个下标对应的最长递增子序列的长度
        Arrays.fill(dp,1);//每个下标对应的最小长度为1，自己本身
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){//递归思想，归纳出第i对应的最长子序列的长度
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);//dp[j]+1表示加上i对应的下标这个值算入新的子序列
                }
            }
        }
        int max=0;
        for(int i:dp){
            if(i>max){
                max=i;
            }
        }
        return max;
    }
}
