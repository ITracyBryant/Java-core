/**
 * 
 */
package io.itracybryant;

/**
 * @XinCheng 2018年6月6日 Administrator 定义一个电梯接口
 */
public interface IElevator {
	public final static int OPENING_STATE = 1;// 开启
	public final static int CLOSING_STATE = 2;// 关闭
	public final static int RUNNING_STATE = 3;// 运行
	public final static int STOPING_STATE = 4;// 停止

	public void setState(int state);

	public void open();

	public void close();

	public void run();

	public void stop();

}
