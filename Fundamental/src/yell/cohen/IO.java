package yell.cohen;

import java.io.Console;
import java.util.*;

public class IO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner in=new Scanner(System.in);
		//get first input
		System.out.println("What are you?");
		String name=in.nextLine();
		//get second input
		System.out.println("How old are you?");
		int age=in.nextInt();
		//get third input
		System.out.println("How many is your weight?");
		double weight=in.nextDouble();
		System.out.println("Hello, "+name+".Next year,you'll be "+(age+1)+" your weght is "+weight);
		//format Output
		System.out.printf("Hello, %s. Next year,you'll be %d\n", name,age);
		//create static format string
		String message=String.format("Hello, %s. Next year,you'll be %d", name,age);
		System.out.println(message);
		

		//Use Console to read a password
		Console cons=System.console();
		String username=cons.readLine("User name: ");
		char[] passwd=cons.readPassword("Password: ");
		System.out.println("Your name: "+username+'\n'+"Your passwd: "+passwd[4]);
		


	}

}
