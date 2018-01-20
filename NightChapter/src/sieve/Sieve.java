/**
 * 
 */
package sieve;

import java.util.*;

/**
 * This program runs the Sieve of Erathostenes benchmark. It computes all prime numbers up to 2000000.
 * @XinCheng 2017Äê11ÔÂ25ÈÕ Administrator
 *
 */
public class Sieve {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2000000;
		long start = System.currentTimeMillis();
		BitSet b = new BitSet(n + 1);
		int count = 0;
		int i;
		for(i = 2; i <= n; i++)
			b.set(i);
		i = 2;
		while(i * i <= n)
		{
			if(b.get(i))
			{
				count++;
				int k = 2 * i;
				while(k <= n)
				{
					b.clear(k);
					k += i;
				}
			}
			i++;
		}
		while(i <= n)
		{
			if(b.get(i))
			{
				//System.out.println("prime numbers: " + i);
				count++;
			}
			i++;
		}
		
		long end = System.currentTimeMillis();
		System.out.println(count + "prime numbers");
		System.out.println("run time is: " + (end - start) + " milliseconds");

	}

}
