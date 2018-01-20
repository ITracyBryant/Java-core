package good.advancing;

import java.util.*;

public class LotteryDrawing {
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
		
		//fill an array with numbers 1 2 3...n
		int[] numbers=new int[n];
		for(int i=0;i<numbers.length;i++)
			numbers[i]=i+1;      //总数
		
		//draw k numbers and put them into second array
		int[] result=new int[k];
		for(int i=0;i<result.length;i++)
		{
			//make a random index between 0 and n-1
			int r=(int)(Math.random()*n);
			
			//pick the element at the random location
			result[i]=numbers[r];
			
			//move the last element  下标指向包含尚未抽取过的数组元素
			numbers[r]=numbers[n-1];
			n--;
		}
		
		//print the sorted array
		Arrays.sort(result); //类似快速排序
		System.out.println("Bet the following combination. It'll make you rich!");
		for(int r:result)
			System.out.println(r);


	}

}

