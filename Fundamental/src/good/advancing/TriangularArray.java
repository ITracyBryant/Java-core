package good.advancing;

public class TriangularArray {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
final int NMAX=10; //定义常量
		
		//allocate the triangular array
		int [][] odds=new int[NMAX+1][];//先分配一个具有所含行数的数组  行数NMAX+1   从0~NMAX
		for(int n=0;n<=NMAX;n++) //再分配这些行
			odds[n]=new int[n+1];
		
		//fill triangular array
		for(int n=0;n<odds.length;n++)  //行数
			for(int k=0;k<odds[n].length;k++) //相应行的列数
			{
				//compute binomial coefficient  n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
				int lotteryOdds=1;
				for(int i=1;i<=k;i++)
					lotteryOdds=lotteryOdds*(n-i+1)/i;  //组合数
				
				odds[n][k]=lotteryOdds;
			}
		
		//print triangular array  for each 处理二维数组输出
		for(int[] row : odds)
		{
			for(int odd : row)
				System.out.printf("%4d",odd);//占位符输出 不是特别整齐
			System.out.println();
		}


	}

}
