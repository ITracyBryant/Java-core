/**
 * 
 */
package io.itracybryant;

/**
 * @XinCheng 2018年6月6日 Administrator 电梯类 不符合开闭原则和单一职责原则
 */
public class Elevator implements IElevator {
	private int state;

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.IElevator#setState(int)
	 */
	public void setState(int state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.IElevator#open()
	 */
	public void open() {
		switch (this.state) {
		case OPENING_STATE: // 已开，不做其它
			break;
		case CLOSING_STATE: // 处于关闭，可以开启，并改变状态
			this.RealOpen();
			this.setState(OPENING_STATE);
			break;
		case RUNNING_STATE: // 运行不能开启
			break;
		case STOPING_STATE:
			this.RealOpen();
			this.setState(OPENING_STATE);
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.IElevator#close()
	 */
	public void close() {
		switch (this.state) {
		case OPENING_STATE: // 处于开启，可以关闭，并改变状态
			this.RealClose();
			this.setState(CLOSING_STATE);
			break;
		case CLOSING_STATE: // 已关
			break;
		case RUNNING_STATE: // 运行时已关
			break;
		case STOPING_STATE: // 停止时已关
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.IElevator#run()
	 */
	public void run() {
		switch (this.state) {
		case OPENING_STATE: // 处于开启，不能运行
			break;
		case CLOSING_STATE: // 关闭时可以运行
			this.RealRun();
			this.setState(RUNNING_STATE);
			break;
		case RUNNING_STATE: // 已在运行
			break;
		case STOPING_STATE: // 停止时可以运行
			this.RealRun();
			this.setState(RUNNING_STATE);
			break;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.itracybryant.IElevator#stop()
	 */
	public void stop() {
		switch (this.state) {
		case OPENING_STATE: // 处于开启，已停
			break;
		case CLOSING_STATE: // 关闭时可以停
			this.RealStop();
			this.setState(STOPING_STATE);
			break;
		case RUNNING_STATE: // 已在运行，可以停
			this.RealStop();
			this.setState(STOPING_STATE);
			break;
		case STOPING_STATE: // 已停
			break;
		}
	}

	private void RealOpen() {
		System.out.println("电梯门开启");
	}

	private void RealClose() {
		System.out.println("电梯门关闭");
	}

	private void RealRun() {
		System.out.println("电梯运行");
	}

	private void RealStop() {
		System.out.println("电梯停止");
	}
}
