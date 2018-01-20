/**
 * 
 */
package clone;

/**
 * This program demonstrates cloning
 * @xincheng 2017Äê10ÔÂ21ÈÕ Administrator
 *
 */
public class CloneTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Employee original = new Employee("Zeal", 50000);
			original.setHireDay(2017, 1, 1);
			Employee copy = original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2017, 12, 31);
			System.out.println("original=" + original);
			System.out.println("copy=" + copy);
		}
		catch(CloneNotSupportedException e)
		{
			e.printStackTrace();
		}

	}

}
