/**
 * 
 */
package abstractClasses;

/**
 * @author c1114
 *
 */
public class Student extends Person {
	private String major;

	public Student(String name, String major) {
		super(name);  //pass n to superclass constructor
		this.major = major;
	}

	/* (non-Javadoc)
	 * @see abstractClasses.Person#getDescription()
	 */
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "a student majoring in " + major;
	}

}
