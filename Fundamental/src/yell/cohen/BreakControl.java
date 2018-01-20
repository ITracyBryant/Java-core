package yell.cohen;

import java.util.Scanner;

public class BreakControl {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Format Output
				double x=10000.0/3.0;
				System.out.printf("%f\n", x);
				System.out.printf("%8.2f\n", x);
				System.out.printf("%,.2f\n", 10000.0/3.0);
				System.out.printf("%,(.2f\n", -10000000.0/3.0);
				
				@SuppressWarnings("resource")
				Scanner in=new Scanner(System.in);
				System.out.println("How much do you need to retire?");
				double goal=in.nextDouble();
				System.out.println("How much money will you contribute every year?");
				double payment=in.nextDouble();
				System.out.println("Interest rate in %: ");
				double interestRate=in.nextDouble();
				
				double balance=0;
				int years=0;
				//Update account balance while goal isn't reached
				while(years<=100){ //add this year's payment and interest
					balance+=payment;
					double interest=balance*interestRate/100;
					balance+=interest;
					if(balance>=goal) break;
					years++;
				}
				/*while(years<=100&&balance<goal){
					balance+=payment;
					double interest=balance*interestRate/100;
					balance+=interest;
					if(balance<goal) //check twice
						years++;
				}*/

				System.out.println("You can retire in "+years+"years.");


	}

}
