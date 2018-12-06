/**
 * 
 */
package io.itracybryant.state;

/**
 * @XinCheng 2018Äê6ÔÂ6ÈÕ Administrator Í£Ö¹×´Ì¬
 */
public class StopState extends ElevatorState {

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
		System.out.println("µçÌÝÍ£Ö¹");
	}

}
