/**
 * 
 */
package pair2;

import java.time.*;

/**
 * @XinCheng 2017Äê11ÔÂ7ÈÕ Administrator
 *
 */
public class PairTest2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate[] birthdays = 
			{
				LocalDate.of(1995, 10, 3),
				LocalDate.of(1971, 8, 4),
				LocalDate.of(1974, 4, 3),
				LocalDate.of(1995, 8, 9)
			};
		Pair<LocalDate> minmax = ArrayAlg.minmax(birthdays);
		System.out.println("min = " + minmax.getFirst());
		System.out.println("max = " + minmax.getSecond());
	}
}

class ArrayAlg
{
	/**
	 * Gets the minimum and maximum of an array of objects of type T.
	 * @param a an array of object of type T
	 * @return a pair with the min and max value, or null if a is null or empty
	 */
	public static <T extends Comparable> Pair<T> minmax(T[] a)
	{
		if(a == null || a.length == 0)
		{
			return null;
		}
		T min = a[0];
		T max = a[0];
		for(int i = 1; i < a.length; i++)
		{
			if(min.compareTo(a[i]) > 0)
			{
				min = a[i];
			}
			if(max.compareTo(a[i]) < 0)
			{
				max = a[i];
			}
		}
		return new Pair<>(min, max);
	}
}
