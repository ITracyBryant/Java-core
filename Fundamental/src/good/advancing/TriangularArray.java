package good.advancing;

public class TriangularArray {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
final int NMAX=10; //���峣��
		
		//allocate the triangular array
		int [][] odds=new int[NMAX+1][];//�ȷ���һ��������������������  ����NMAX+1   ��0~NMAX
		for(int n=0;n<=NMAX;n++) //�ٷ�����Щ��
			odds[n]=new int[n+1];
		
		//fill triangular array
		for(int n=0;n<odds.length;n++)  //����
			for(int k=0;k<odds[n].length;k++) //��Ӧ�е�����
			{
				//compute binomial coefficient  n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
				int lotteryOdds=1;
				for(int i=1;i<=k;i++)
					lotteryOdds=lotteryOdds*(n-i+1)/i;  //�����
				
				odds[n][k]=lotteryOdds;
			}
		
		//print triangular array  for each �����ά�������
		for(int[] row : odds)
		{
			for(int odd : row)
				System.out.printf("%4d",odd);//ռλ����� �����ر�����
			System.out.println();
		}


	}

}
