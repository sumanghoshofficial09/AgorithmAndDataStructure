class Solution {
    public boolean canJump(int[] nums) {

        int len=nums.length-1;

        if(nums.length==1)
        return true;

        int maxreach=0;

        for(int i=0;i<nums.length;i++)
        {

            if(i<=maxreach)
            {

            int tempreach=nums[i]+i;
            
            if(tempreach>=len)
            {
            	return true;
            	
            	
            }
            
            if(tempreach>maxreach)
            {
            	maxreach=tempreach;
            }
            
            
            
            }
            else
            {
            	break;
            }


        }
        

        return false;
    }
}