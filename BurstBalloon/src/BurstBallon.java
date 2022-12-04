import java.util.Arrays;

public class BurstBallon {
	
	public static void main(String args[])
	{
		int points[][]= {{-1,1},{0,1},{2,3},{1,2}};
		BurstBallon obj = new BurstBallon();
		
		int arrows=obj.findMinArrowShots(points);
		
		System.out.println(arrows);
	}

	 public int findMinArrowShots(int[][] points) {
		 
		 sort(points);
		 
		 int len=points.length;
		 
		 int balloon =0;
		 int l=Integer.MIN_VALUE;
		 int r=Integer.MIN_VALUE;
		 
		 
		 for(int i=0;i<len;i++)
		 {
			 int arr[]=points[i];
			 
			 int l1=arr[0];
			 int r1=arr[1];
			 
			 if((l1>=l && l1<=r)||(r1>=l && r1<=r) ||(l>=l1 && l<=r1)||(r>=l1 && r<=r1) )
				 continue;
			 else
			 {
				 balloon++;
				 l=l1;
				 r=r1;
				 
			 }
			 
			 
			 
			 
			 
		 }
		return balloon==0?1:balloon;
	        
	    }

	private void sort(int[][] points) {
		Arrays.sort(points,(x,y)->{
			
			Integer e1= x[1];
			Integer e2 = y[1];
			
			return e1.compareTo(e2);
		});
		
	}
}
