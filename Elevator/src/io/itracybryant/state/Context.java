/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018��6��6�� Administrator ������������״̬�������Ļ�����
 */
public class Context {
	// �������е��ݵ�״̬
	public final static OpenState openState = new OpenState();
	public final static CloseState closeState = new CloseState();
	public final static RunState runState = new RunState();
	public final static StopState stopState = new StopState();

	// ��ǰ��һ������״̬
	private ElevatorState elevatorState;

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
		this.elevatorState.setContext(this); // ����ǰ���»���֪ͨ������״̬ʵ������
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
