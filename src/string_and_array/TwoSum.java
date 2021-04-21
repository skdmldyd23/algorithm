package string_and_array;

import java.util.*;
//https://leetcode.com/problems/two-sum/

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
//
//Example 1:
//
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
//Example 2:
//
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
//Example 3:
//
//Input: nums = [3,3], target = 6
//Output: [0,1]

//다중포문을 쓰지않고 풀기

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = {2,8,11,21};
        int target =10;
        TwoSum a = new TwoSum();
        int[]  result = a.solve(nums, target);
        for(int i : result)
        	System.out.println(i);
	}
	
//	containsKey랑 get이 결국 포문
	public int[] solve(int[] nums, int target) {
 		int[] returnArr = new int[2];
		
		HashMap<Integer, Integer> hash = new HashMap<>();
		
		for(int i = 0; i < nums.length; ++i) {
			int num = nums[i];
			if(hash.containsKey(num)) {
				returnArr[0] = hash.get(num);
				returnArr[1] = i;
				return returnArr;
			}
			hash.put(target-num, i);
		}
		return returnArr;
	}
	
//	포문한번만
	public int[] solve2(int[] nums, int target) {
        int i, j;
        for(i = 0, j = i + 1 ; i < nums.length;){
            if(j == nums.length) j = ++i + 1;
            else if(target == nums[i] + nums[j]) break;
            else j++;
            }
        int[] returnArr = {i, j};
        return returnArr;
    }
}