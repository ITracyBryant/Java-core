/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018年6月6日 Administrator 电梯调度
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
