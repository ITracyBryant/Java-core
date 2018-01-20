package good.advancing;

import java.util.Scanner;

public class DateTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		int sum=0;
		System.out.print("your goal value: ");
		int goal=in.nextInt();
		while(sum<goal){
			System.out.print("Enter a number: ");
			int n=in.nextInt();
			if(n<0) continue;
			sum+=n;// if n<0 not executed

		}

	}

}
