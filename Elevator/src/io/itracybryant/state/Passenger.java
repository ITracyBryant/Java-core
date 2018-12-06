/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018��6��6�� Administrator ���ݵ���
 */
public class Passenger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Context context = new Context();
		context.setElevatorState(new RunState());
		context.open();
		context.close();
		context.run();
		context.stop();
	}

}
