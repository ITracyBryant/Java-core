/**
 * 
 */
package io.itracybryant;

/**
 * @XinCheng 2018��6��6�� Administrator ����һ�����ݽӿ�
 */
public interface IElevator {
	public final static int OPENING_STATE = 1;// ����
	public final static int CLOSING_STATE = 2;// �ر�
	public final static int RUNNING_STATE = 3;// ����
	public final static int STOPING_STATE = 4;// ֹͣ

	public void setState(int state);

	public void open();

	public void close();

	public void run();

	public void stop();

}
