class Solution {

    public int[][] generateMatrix(int n) {

        int res[][] = new int [n][n];

        

        int si=0;
        int ei=n-1;

        int sj=0;

        int ej=n-1;

        int num=1;

        while(si<=ei)
        {
            for(int j=sj;j<=ej;j++)
            {
                res[si][j]=num++;

            }
            si++;

            for(int i=si;i<=ei;i++)
            {
                res[i][ej]=num++;
            }
            ej--;

            for(int j=ej;j>=sj;j--)
            {
                res[ei][j]=num++;
            }
            ei--;

            for(int i=ei;i>=si;i--)
            {
                res[i][sj]=num++;
            }
            sj++;

        }

        return res;


        
    }
}