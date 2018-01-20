package yell.cohen;

import java.util.*;

public class ControlProcess {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("请输入销售额：");
		int yourSales=in.nextInt();
		int target=1000;
		if(yourSales>=target){
			String performance="Satisfactory";
			double bonus=100+0.01*(yourSales+target);
			System.out.println("业绩评价："+performance+"奖金："+bonus);
		}
		else{
			String performance="Unsatisfactory";
			double bonus=0;
			System.out.println("业绩评价："+performance+"奖金："+bonus);
		}

	}

}
