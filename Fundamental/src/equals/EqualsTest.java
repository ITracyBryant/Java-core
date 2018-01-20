/**
 * 
 */
package equals;

/**
 * @author c1114
 *
 */
public class EqualsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee cx1 = new Employee("CX", 50000, 1995, 10, 3);
		Employee cx2 = cx1;
		Employee cx3 = new Employee("CX", 50000, 1995, 10, 3);
		Employee xc = new Employee("XC", 30000, 1995, 8, 9);
		
		System.out.println("cx1 == cx2: " + (cx1 == cx2));
		
		System.out.println("cx1 == cx3: " + (cx1 == cx3));
		
		System.out.println("cx1.equals(cx3): " + cx1.equals(cx3));
		
		System.out.println("cx1.equals(xc): " + cx1.equals(xc));
		
		System.out.println("xc.toString(): " + xc);
		
		Manager mg = new Manager("zq", 40000, 1994, 8, 6);
		Manager boss = new Manager("qy", 40000, 1994, 8, 6);
		boss.setBonus(5000);
		System.out.println("boss.toString(): " + boss);
		System.out.println("mg.equals(boss): " + mg.equals(boss));
		System.out.println("cx1.hashCode(): " + cx1.hashCode());
		System.out.println("cx3.hashCode(): " + cx3.hashCode());
		System.out.println("xc.hashCode(): " + xc.hashCode());
		System.out.println("mg.hashCode(): " + mg.hashCode());

	}

}
