/*
 * 
 * 55. Jump Game
Medium

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.
 */
public class JumpGame {
public boolean canJump(int[] nums) {
        
        int max=0;
        
        
        int endindex=nums.length-1;
        for(int i=0;i<nums.length;i++)
        {
            if(i<=max)
            {
           int  maxjump=i+nums[i];
            
            if(maxjump>=endindex)
                return true;
                
                if(maxjump>max)
                    max=maxjump;
                
            }
            else
            {
                return false;
                
            }
           
            
        }
        
        return false;
    }

}
