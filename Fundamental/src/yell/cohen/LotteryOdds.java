package yell.cohen;

import java.util.*;

public class LotteryOdds {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		System.out.println("How many numbers do you need to draw? ");
		int k=in.nextInt();
		
		System.out.println("What is the highest number you can draw? ");
		int n=in.nextInt();
		//×éºÏ  n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
		int lotteryOdds=1;
		for(int i=1;i<=k;i++)
			lotteryOdds=lotteryOdds*(n-i+1)/i;
		System.out.println("You are becoming a lucker in: "+lotteryOdds+" Good Luck!");

	}

}
