import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	
    	List<Integer> resultList = new ArrayList<>();
    	
    	int lenj=matrix[0].length;
    	int leni=matrix.length;
    	
    	int si=0;  int ei=leni-1;
    	
    	int sj=0; int ej=lenj-1;
    	
    	
    	while(si<=ei && sj<=ej )
    	{
    		if(si<=ei && sj<=ej)
    		{
    		for(int j=sj;j<=ej;j++)
    		{
    			resultList.add(matrix[si][j]);
    		}
    		si++;
    		}
    		
    		if(si<=ei && sj<=ej)
    		{
    		
    		for(int i=si;i<=ei;i++)
    		{
    			resultList.add(matrix[i][ej]);
    		}
    		ej--;
    		}
    		
    		if(si<=ei && sj<=ej)
    		{
    		
    		for(int j=ej;j>=sj;j--)
    		{
    			resultList.add(matrix[ei][j]);
    		}
    		ei--;
    		}
    		
    		if(si<=ei && sj<=ej)
    		{
    		for(int i=ei;i>=si;i--)
    		{
    			resultList.add(matrix[i][sj]);
    		}
    		sj++;
    		}
    	}
    			
        
    return resultList;
    }
    
}