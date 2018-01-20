package keep.moving;

import java.time.*;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date=LocalDate.now(); //����һ�� ���������õ�ǰʱ���ʼ��
		int month=date.getMonthValue();
		int today=date.getDayOfMonth();
		
		date=date.minusDays(today-1); //set to start of a month
		DayOfWeek weekday=date.getDayOfWeek(); //weekday�õ���ǰ���������ڼ�����ΪDayOfWeek���һ��ʵ������
	    int value=weekday.getValue(); //1=Monday,2=Tuesday,...,7=Sunday
	    
	    System.out.println("Mon Tue Wed Thu Fri Sat Sun"); //��ӡ��ͷ
	    for(int i=1;i<value;i++)
	    	System.out.print("    "); //��һ�е�������ʹ���·ݵĵ�һ��ָ����Ӧ�����ڼ������û���
	    while(date.getMonthValue()==month)  //������ѭ��
	    {
	    	System.out.printf("%3d", date.getDayOfMonth());//���ͷ��Ӧ����ӡ����ÿ������
	    	if(date.getDayOfMonth()==today){
	    		System.out.print("*");//����������*���
	    		}
	    	else{
	    		System.out.print(" ");//��������һ��
	    	}
	    	date=date.plusDays(1);//�ۼ�����ÿ��ѭ������ƽ�һ��
	    	if(date.getDayOfWeek().getValue()==1) System.out.println(); //�������µ�һ�ܵĵ�һ�죬���д�ӡ
	    }
	    if(date.getDayOfWeek().getValue()!=1) System.out.println();//���½������������ѭ����ֹͣ����
	}

}

