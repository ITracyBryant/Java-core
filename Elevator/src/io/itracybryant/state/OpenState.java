/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018��6��6�� Administrator ����״̬
 */
public class OpenState extends ElevatorState {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#open()
	 */
	@Override
	public void open() {
		System.out.println("���ݿ���");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#close()
	 */
	@Override
	public void close() {
		super.context.setElevatorState(Context.closeState);
		super.context.getElevatorState().close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#run()
	 */
	@Override
	public void run() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#stop()
	 */
	@Override
	public void stop() {
	}

}
