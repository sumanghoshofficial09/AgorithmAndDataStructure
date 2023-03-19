import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	
	
	public static void main(String args[])
	{
		int A[] = {1,2,3,4,5};
		int B=2;
		
		Solution s = new Solution();
		
		int res = s.solve(A, B);
		
		System.out.println(res);
	}
	
	public int solve(int[] A, int B) {
		
		long mod = 1000000007L;
		
		HashMap<Integer,Integer> remainderFrequencyMap = new HashMap<>();
		
		
		long total =0l;
		for(int i=0;i<A.length;i++)
		{
			
			
			int remainder=A[i]%B;
			
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
						total=(total+freq)%mod;
						remainderFrequencyMap.put(remainder, ++freq);
						
					}
					else
					{
						remainderFrequencyMap.put(remainder, 1);
						
					}
					
				}
				else
				{
					
					int otherRemainder = B-remainder;
					
					if(remainderFrequencyMap.containsKey(otherRemainder))
					{
						int freq = remainderFrequencyMap.get(otherRemainder);
						total=(total+freq)%mod;
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
		
		return (int) (total%mod);
		
    }
	

}
