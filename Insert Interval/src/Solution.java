
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
//import java.util.LinkedHashMap.Entry;
import java.util.Set;


class Solution {
	
	public static void main(String args[])
	{
		Solution s = new Solution();
		
		int [][] intervals = {{1,5}};
		
		int [] newInterval = {6,8};
		
		int [][] rr=s.insert(intervals, newInterval);
		System.out.println(rr);
	}
    public int[][] insert(int[][] intervals, int[] newInterval) {
    	
    	if(newInterval.length==0)
    	{
    		return intervals;
    	}
    	
    	if(intervals.length==0)
    	{
    		int rt[][]= new int[1][2];
    		rt[0]=newInterval;
    		return rt;
    		
    	}
    	
    	int p1=0;
    	int p2=0;
    	
    	HashMap<Integer,int[]> map = new HashMap<Integer,int[]>();
    	
    	int len = intervals.length;
    	
    	boolean checkInterval=true;
    	
    	while(p1<len)
    	{
    	
    	int[] temp1=intervals[p1];
    	
    	if(checkInterval)
    	{
    		if(mergePossible(newInterval, temp1))
    		{
    			int mg[]=merged(newInterval, temp1);
    			map.put(p2, mg);
    			checkInterval=false;
    			p1++;
    		}
    		else
    		{
    			if(smaller(temp1,newInterval))
    			{
    				map.put(p2,temp1);
    				p2++;
    				p1++;
    				
    				
    			}
    			else
    			{
    				map.put(p2,newInterval);
    				checkInterval=false;
    				p2++;
    				map.put(p2, temp1);
    				p1++;
    			}
    		}
    		
    	}
    	else
    	{
    		int t2[]=map.get(p2);
    		
    		if(mergePossible(temp1, t2))
    		{
    			int merg[]=merged(temp1, t2);
    			map.put(p2, merg);
    			p1++;
    			
    		}
    		else
    		{
    			map.put(++p2, temp1);
    			p1++;
    		}
    		
    	}
    	
    	
    	}
    	
    	if(checkInterval)
    	{
    	int ii = map.size();
    	
    	map.put(ii,newInterval);
    	}
    	Set<Entry<Integer, int[]>>  s = map.entrySet();
    	
    	int rr[][]=new int[s.size()][2];
    	
    	Iterator<Entry<Integer, int[]>> it = s.iterator();
    	
    	int c=0;
    	
    	while(it.hasNext())
    	{
    		rr[c++]=it.next().getValue();
    	}
    	
    	
    	return rr;
    }

	private boolean smaller(int[] temp1, int[] newInterval) {
		// TODO Auto-generated method stub
		
		if(temp1[1]<newInterval[0])
			return true;
		return false;
	}
	private int[] merged(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int res[]=new int[2];
		
		if(arr1[0]<arr2[0])
		{
			res[0]=arr1[0];
		}
		else
		{
			res[0]=arr2[0];
		}
		
		if(arr1[1]>arr2[1])
		{
			res[1]=arr1[1];
		}
		else
		{
			res[1]=arr2[1];
		}
		
		
		return res;
					
	}

	private boolean mergePossible(int[] arr1, int[] arr2) {
		if((arr1[0]>=arr2[0] && arr1[0]<=arr2[1]) || (arr1[1]>=arr2[0] && arr1[1]<=arr2[1]) || (arr2[0]>=arr1[0] && arr2[0]<=arr1[1]) || (arr2[1]>=arr1[0] && arr2[1]<=arr1[1]))
		{
			return true;
	
		}
		return false;
	}
}