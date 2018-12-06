/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018年6月6日 Administrator 定义电梯状态的接口
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
