/**
 * 
 */
package inheritance;

/**
 * @author c1114
 *
 */
public class Manager extends Employee {
	private double bonus;

	/**
	 * @param name
	 * @param salary
	 * @param year
	 * @param month
	 * @param day
	 */
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
		// TODO Auto-generated constructor stub
		bonus = 0;
	}

	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
