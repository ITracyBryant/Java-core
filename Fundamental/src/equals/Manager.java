/**
 * 
 */
package equals;

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
	
	public double getSalary()
	{
		double baseSalary = super.getSalary();
		return baseSalary + bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public boolean equals(Object otherObject) {
		// TODO Auto-generated method stub
		if(!super.equals(otherObject)) return false;
		Manager other = (Manager) otherObject;
		// super.equals checked that this and other belong to the same class
		return bonus == other.bonus;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode() + 17 * new Double(bonus).hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "[bonus=" + bonus + "]";
	}

}
