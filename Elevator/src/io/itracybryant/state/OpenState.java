/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018年6月6日 Administrator 开门状态
 */
public class OpenState extends ElevatorState {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#open()
	 */
	@Override
	public void open() {
		System.out.println("电梯开启");
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
