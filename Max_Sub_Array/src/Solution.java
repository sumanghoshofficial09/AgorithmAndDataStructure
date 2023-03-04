/*
 * 
 * 53. Maximum Subarray
Medium
28.4K
1.3K
Companies
Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 * 
 */

class Solution {
    public int maxSubArray(int[] nums) {

        int max=nums[0];
        int min=nums[0];
        int res=nums[0];

        for(int i=1;i<nums.length;i++)
        {

            int temp=max;

            max=Math.max(Math.max(max+nums[i], min+nums[i]), nums[i]);
            min=Math.min(Math.min(temp+nums[i], min+nums[i]), nums[i]);
            
            if(max>res)
            {
            	res=max;
            }

        }
        return res;
        
    }
}