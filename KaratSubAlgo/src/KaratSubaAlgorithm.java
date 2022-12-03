
public class KaratSubaAlgorithm 
{
	
	public static void main(String args[])
	{
		KaratSubaAlgorithm  obj = new KaratSubaAlgorithm();
		
		int x=20;
		int y=40;
		
		int mul=obj.ks(x, y);
		
		System.out.println(mul);
	}
	
	int ks(int x,int y)
	{
		if(x<10 || y<10)
			return x*y;
		
	int resx[]=splitInHalf(x);
	int resy[]=splitInHalf(y);
	
	int a=resx[0];
	int b= resx[1];
	
	int c= resy[0];
	int d= resy[1];
	
	int ac= ks(a,c);
	int bd = ks(b,d);
	
	int adPlusbc=ks(a+b,c+d)-ac-bd;
	
	int n= max(len(x),len(y));
	int halfn=n/2;
	
	return toPower(10, n)*ac + toPower(10, halfn) * adPlusbc + bd;
	
	}
	
	int max(int x,int y ) {
		
		if(x>y)
			return x;
		else
			return y;
	}
	
	
	
	int [] splitInHalf(int num)
	{
		int res[]=new int[2];
		int d=toPower(10,len(num)/2);
		res[0]=num/d;
		res[1]=num%d;
		return res;
		
	}

	int toPower(int i, int j) {
		int mul=1;
		for(int x=1;x<=j;x++)
		{
			mul=mul*i;
		}
		return mul;
	}

	int len(int num) {
		String s = Integer.toString(num);
		
		return s.length();
	}

}
