package good.advancing;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[]a=new int[100];
		
		for(int i=0;i<100;i++){
			a[i]=i; 
		System.out.println(a[i]);
		}
		for(int i=0;i<a.length;i++)
			System.out.println(a[i]);
		
		int[]b={1,2,3,4};
		b=new int[]{5,6,7,8};
		int[] c=b;//”µ½M¿½Ø
		c[3]=9; //b[3]Ò²•þ¸Ä×ƒ
		int[] d=Arrays.copyOf(c,2*c.length);
		for(int element:d)
			System.out.println(element);
		for(int element:b) //for each research every array element
			System.out.println(element);	
				
		int [] e={0,1,2,3,4};
		System.out.println(Arrays.toString(e));
		


	}

}

