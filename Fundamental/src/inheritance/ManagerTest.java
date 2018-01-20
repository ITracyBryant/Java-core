/**
 * 
 */
package inheritance;

/**
 * @author c1114
 *
 */
public class ManagerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//construct a Manager object
		Manager boss = new Manager("chengxin", 20000, 1995, 10, 3);
		boss.setBonus(5000);

		Employee[] staff = new Employee[3];

		//fill the staff array with Manager and Employee objects

		staff[0] = boss; //is-a  置换法则（单向） 超类变量也可以引用子类对象 变量staff[0]与boss引用同一个对象，但编译器将staff[0]看成Employee对象，Java中对象变量是多态的
		staff[1] = new Employee("zzq", 15000, 1994, 7, 6);
		staff[2] = new Employee("qy", 15000, 1994, 6, 7);
		
		//raise everyone's salary by 5%
		for (Employee e : staff) {
			e.raiseSalary(5);
		}

		//print out information about all Employee objects
		for (Employee e : staff) {
			System.out.println("name=" + e.getName() + ", salary=" + e.getSalary() + ", birthday=" + e.getHireDay());
		}
	}
}
