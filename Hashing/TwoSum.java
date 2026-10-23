/*
You are given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

leetCode link :- https://leetcode.com/problems/two-sum/

Time complexity :- O(n)
Space Complexity :- O(n)
*/


package Hashing;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums , int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0 ; i<nums.length ; i++){
            int need = target - nums[i];

            if(map.containsKey(need)){
                return new int[]{map.get(need) , i};
            }

            map.put(nums[i] , i);
        }

        return new int[]{};
    }
    
    public static void main(String[] args) {
        int nums[] = {2,6,5,8,11};
        int target = 14;

        int[] result = twoSum(nums, target);

        for(int i=0 ; i<result.length ; i++){
            System.out.print(result[i] + " ");
        }
    }
}
