/**
 * 
 */
package io.itracybryant;

/**
 * @XinCheng 2018年6月6日 Administrator 电梯动作
 */
public class Passenger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		elevator.setState(IElevator.STOPING_STATE); // 电梯初始停止
		elevator.open();
		elevator.close();
		elevator.run();
		elevator.stop();
		System.out.println("******************************");

		elevator.setState(IElevator.OPENING_STATE); // 电梯初始开启
		elevator.open();
		elevator.close();
		elevator.run();
		elevator.stop();
		System.out.println("******************************");

		elevator.setState(IElevator.CLOSING_STATE); // 电梯初始关闭
		elevator.open();
		elevator.close();
		elevator.run();
		elevator.stop();
		System.out.println("******************************");

		elevator.setState(IElevator.RUNNING_STATE); // 电梯初始运行
		elevator.open();
		elevator.close();
		elevator.run();
		elevator.stop();
		System.out.println("******************************");
	}

}
