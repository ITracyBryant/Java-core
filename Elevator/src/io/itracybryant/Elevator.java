/**
 * 
 */
package io.itracybryant;

/**
 * @XinCheng 2018��6��6�� Administrator ������ �����Ͽ���ԭ��͵�һְ��ԭ��
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
		case OPENING_STATE: // �ѿ�����������
			break;
		case CLOSING_STATE: // ���ڹرգ����Կ��������ı�״̬
			this.RealOpen();
			this.setState(OPENING_STATE);
			break;
		case RUNNING_STATE: // ���в��ܿ���
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
		case OPENING_STATE: // ���ڿ��������Թرգ����ı�״̬
			this.RealClose();
			this.setState(CLOSING_STATE);
			break;
		case CLOSING_STATE: // �ѹ�
			break;
		case RUNNING_STATE: // ����ʱ�ѹ�
			break;
		case STOPING_STATE: // ֹͣʱ�ѹ�
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
		case OPENING_STATE: // ���ڿ�������������
			break;
		case CLOSING_STATE: // �ر�ʱ��������
			this.RealRun();
			this.setState(RUNNING_STATE);
			break;
		case RUNNING_STATE: // ��������
			break;
		case STOPING_STATE: // ֹͣʱ��������
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
		case OPENING_STATE: // ���ڿ�������ͣ
			break;
		case CLOSING_STATE: // �ر�ʱ����ͣ
			this.RealStop();
			this.setState(STOPING_STATE);
			break;
		case RUNNING_STATE: // �������У�����ͣ
			this.RealStop();
			this.setState(STOPING_STATE);
			break;
		case STOPING_STATE: // ��ͣ
			break;
		}
	}

	private void RealOpen() {
		System.out.println("�����ſ���");
	}

	private void RealClose() {
		System.out.println("�����Źر�");
	}

	private void RealRun() {
		System.out.println("��������");
	}

	private void RealStop() {
		System.out.println("����ֹͣ");
	}
}
