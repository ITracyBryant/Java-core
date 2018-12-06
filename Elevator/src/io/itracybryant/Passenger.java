/**
 * 
 */
package io.itracybryant;

/**
 * @XinCheng 2018��6��6�� Administrator ���ݶ���
 */
public class Passenger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		elevator.setState(IElevator.STOPING_STATE); // ���ݳ�ʼֹͣ
		elevator.open();
		elevator.close();
		elevator.run();
		elevator.stop();
		System.out.println("******************************");

		elevator.setState(IElevator.OPENING_STATE); // ���ݳ�ʼ����
		elevator.open();
		elevator.close();
		elevator.run();
		elevator.stop();
		System.out.println("******************************");

		elevator.setState(IElevator.CLOSING_STATE); // ���ݳ�ʼ�ر�
		elevator.open();
		elevator.close();
		elevator.run();
		elevator.stop();
		System.out.println("******************************");

		elevator.setState(IElevator.RUNNING_STATE); // ���ݳ�ʼ����
		elevator.open();
		elevator.close();
		elevator.run();
		elevator.stop();
		System.out.println("******************************");
	}

}
