/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018年6月6日 Administrator 包含电梯所有状态的上下文环境类
 */
public class Context {
	// 定义所有电梯的状态
	public final static OpenState openState = new OpenState();
	public final static CloseState closeState = new CloseState();
	public final static RunState runState = new RunState();
	public final static StopState stopState = new StopState();

	// 当前的一个电梯状态
	private ElevatorState elevatorState;

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
		this.elevatorState.setContext(this); // 将当前上下环境通知到各个状态实现类中
	}

	public void open() {
		this.elevatorState.open();
	}

	public void close() {
		this.elevatorState.close();
	}

	public void run() {
		this.elevatorState.run();
	}

	public void stop() {
		this.elevatorState.stop();
	}
}
