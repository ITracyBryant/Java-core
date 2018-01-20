/**
 * 
 */
package pair3;

/**
 * @XinCheng 2017Äê11ÔÂ10ÈÕ Administrator
 *
 */
public class PairTest3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Manager ceo = new Manager("chengxin", 80000, 2020, 1, 1);
		 Manager cfo = new Manager("zzq", 60000, 2020, 3, 1);
		 Pair<Manager> buddies = new Pair<>(ceo, cfo);
		 printBuddies(buddies);
		 
		 ceo.setBonus(1000000);
		 cfo.setBonus(500000);
		 
		 Manager[] managers = {ceo, cfo};
		 
		 Pair<Employee> result = new Pair<>();
		 minmaxBonus(managers, result);
		 System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
		 maxminBonus(managers, result);
		 System.out.println("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());

	}
	
	public static void printBuddies(Pair<? extends Employee> p)
	{
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
	}
	
	public static void minmaxBonus(Manager[] a, Pair<? super Manager> result)
	{
		if(a.length == 0){
			return;
		}
		Manager min = a[0];
		Manager max = a[0];
		for(int i = 1; i < a.length; i++)
		{
			if(min.getBonus() > a[i].getBonus())
			{
				min = a[i];
			}
			if(max.getBonus() < a[i].getBonus())
			{
				max = a[i];
			}
		}
		result.setFirst(min);
		result.setSecond(max);
	}
	
	public static void maxminBonus(Manager[] a, Pair<? super Manager> result)
	{
		minmaxBonus(a, result);
		PairAlg.swap(result);  //OK--swapHelper captures wildcard type
	}

}

class PairAlg
{
	public static boolean hasNulls(Pair<?> p)
	{
		return p.getFirst() == null || p.getSecond() == null;	
	}
	
	public static void swap(Pair<?> p)
	{
		swapHelper(p);
	}
	
	public static <T> void swapHelper(Pair<T> p)
	{
		T t = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(t);
	}
}
