/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018��6��6�� Administrator ����״̬
 */
public class RunState extends ElevatorState {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#open()
	 */
	@Override
	public void open() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#close()
	 */
	@Override
	public void close() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#run()
	 */
	@Override
	public void run() {
		System.out.println("��������");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#stop()
	 */
	@Override
	public void stop() {
		super.context.setElevatorState(Context.stopState);
		super.context.getElevatorState().stop();
	}

}
