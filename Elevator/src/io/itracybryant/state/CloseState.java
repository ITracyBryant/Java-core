/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018年6月6日 Administrator 关门状态
 */
public class CloseState extends ElevatorState {

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#open()
	 */
	@Override
	public void open() {
		super.context.setElevatorState(Context.openState);
		super.context.getElevatorState().open();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#close()
	 */
	@Override
	public void close() {
		System.out.println("电梯关闭");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.state.ElevatorState#run()
	 */
	@Override
	public void run() {
		super.context.setElevatorState(Context.runState);
		super.context.getElevatorState().run();
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
