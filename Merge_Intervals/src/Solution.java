
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

class Solution {
	
	public static void main(String args[])
	{
		int interval[][]={{2,3},{4,5},{6,7},{8,9},{1,10}};
		Solution s = new Solution();
		
		int rr[][]=s.merge(interval);
		System.out.println(rr);
	}
    public int[][] merge(int[][] intervals) {
    	
    	Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
    	int len = intervals.length;
    	
    	
    //	List<int[]> res= new ArrayList<int[]>();
    	HashMap<Integer,int[]> res = new HashMap<Integer,int[]>();
    	
    	
    	int p1=0;
    	int p2=0;
    	
    	while(p1<len)
    	{
    		
    		if(p1==0)
    		{
    			res.put(p2,intervals[p1]);
    			p1++;
    		}
    		else
    		{
    			int arr1[]=res.get(p2);
    			int arr2[] = intervals[p1];
    			
    			if(mergePossible(arr1,arr2))
    			{
    				int mergedArray[] = doMerge(arr1,arr2);
    				res.put(p2,mergedArray);
    				p1++;
    				
    			}
    			else
    			{
    				p2++;
    				res.put(p2,intervals[p1]);
    				p1++;
    				
    			}
    			
    		}
    	}
    	
    	
    	int[][] result=convertToArray(res);
    	
    	return result;
    	
    	
        
    }

	private int[][] convertToArray(HashMap<Integer, int[]> res) {
		int result[][]= new int[res.size()][2];
		
		Set<Entry<Integer, int[]>> s = res.entrySet();
		
		Iterator<Entry<Integer, int[]>> it = s.iterator();
		
		int index=0;
		
		while(it.hasNext())
		{
			result[index]=it.next().getValue();
			index++;
			
		}
		
		return result;
	}
	private int[] doMerge(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		int max=Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		if(arr1[0]>max)
		{
			max=arr1[0];
		}
		if(arr1[1]>max)
		{
			max=arr1[1];
		}
		if(arr2[0]>max)
		{
			max=arr2[0];
		}
		if(arr2[1]>max)
		{
			max=arr2[1];
		}
		
		
		
		
		if(arr1[0]<min)
		{
			min=arr1[0];
		}
		if(arr1[1]<min)
		{
			min=arr1[1];
		}
		if(arr2[0]<min)
		{
			min=arr2[0];
		}
		if(arr2[1]<min)
		{
			min=arr2[1];
		}
		
		int res [] = new int [2];
		
		res[0]=min;
		res[1]=max;
		
		return res;
	}

	private boolean mergePossible(int[] arr1, int[] arr2) {
		// TODO Auto-generated method stub
		
		if(   (arr1[1]>=arr2[0] && arr1[1]<=arr2[1])  || (arr2[0]<=arr1[1] && arr2[0]>=arr1[0] )  || (arr2[1]<=arr1[1] && arr2[1]>=arr1[0] )  )
		{
			return true;
		}
			
		return false;
	}
}