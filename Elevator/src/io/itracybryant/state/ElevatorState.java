/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018��6��6�� Administrator �������״̬�Ľӿ�
 */
public abstract class ElevatorState {
	protected Context context;

	public void setContext(Context context) {
		this.context = context;
	}

	public abstract void open();

	public abstract void close();

	public abstract void run();

	public abstract void stop();

}
