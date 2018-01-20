package good.advancing;

import java.math.*;
import java.util.*;

public class BigIntegerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        @SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		
		System.out.print("How many numbers do you need to draw? ");
		int k=in.nextInt();
		System.out.print("What is the highest number you can draw? ");
		int n=in.nextInt();
		
		//compute binomial coefficient
		BigInteger lotteryOdds=BigInteger.valueOf(1);
		for(int i=1;i<=k;i++)
			lotteryOdds=lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
		System.out.println("You are becoming a lucker in: "+lotteryOdds+" Good Luck!");

	}

}

