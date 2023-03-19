package leetcode;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	
	
	public static void main(String args[])
	{
		int A[] = {1,2,3,4,5};
		int B=2;
		
		Solution s = new Solution();
		
		long res = s.countPairs(A, B);
		
		System.out.println(res);
	}
	
	public long countPairs(int[] nums, int k) {
		
		HashMap<Integer,Integer> remainderFrequencyMap = new HashMap<>();
		
		
		long total =0;
		for(int i=0;i<nums.length;i++)
		{
			
			
			int remainder=nums[i]%k;
			
			if(i==0)
			{
				remainderFrequencyMap.put(remainder, 1);
				
			}
			else
			{
				if(remainder==0)
				{
					if(remainderFrequencyMap.containsKey(remainder))
					{
						
						int freq=remainderFrequencyMap.get(remainder);
						total=total+freq;
						remainderFrequencyMap.put(remainder, ++freq);
						
					}
					else
					{
						remainderFrequencyMap.put(remainder, 1);
						
					}
					
				}
				else
				{
					
					int otherRemainder = k-remainder;
					
					if(remainderFrequencyMap.containsKey(otherRemainder))
					{
						int freq = remainderFrequencyMap.get(otherRemainder);
						total= total + freq;
					}
					
					
					if(remainderFrequencyMap.containsKey(remainder))
					{
					
					int curfreq = remainderFrequencyMap.get(remainder);
					
					remainderFrequencyMap.put(remainder,++curfreq);
					
					}
					else
					{
						remainderFrequencyMap.put(remainder,1);
					}
					
				}
			}
			
		}
		
		return total;
		
    }
	

}
