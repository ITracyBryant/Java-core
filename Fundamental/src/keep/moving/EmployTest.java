package keep.moving;

import java.time.*;
//import java.util.Date;

public class EmployTest {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//fill the staff array with three Employee objects
				Employee[] staff=new Employee[3]; //new ��ʼ������
				//ʵ��������Ա���������빹���Ա������staff��
				staff[0]=new Employee("duanmaozhu",50000,1994,8,8);
				staff[1]=new Employee("xiaoyaobi",50001,1994,7,7);
				staff[2]=new Employee("TracyBryant", 50003,1995,10,3);
				
				//raise everyone's salary by 5%
				for(Employee e : staff) //������
					e.ralseSalary(10);
				
			    //print out information about all Employee objects
				for(Employee e : staff)
					System.out.println("name="+e.getName()+" , salary="+e.getSalary()
					+" , hireDay="+e.getHireDay());

			}

		}

		class Employee
		{
			private final String name;  //name����String�����͵�ʵ����    finalʵ��������primitive������immutable�����
			private double salary;
			private LocalDate hireDay; //hireDay����LocalDate�����͵�ʵ����
		//	private Date hire-day;
			
			public Employee(String n,double s,int year,int month,int day)  //constructor ��Ҫ�ڹ������ж�����ʵ���������ľֲ�����    ��Ϊ ������ͬ����ʵ����
			{
				name=n;
				salary=s;
				hireDay=LocalDate.of(year, month, day);
			}
			//�����з����в�Ҫ������ʵ����ͬ���ı���
			public String getName() //method �������   name��privateֻ���򣬴ﵽ��װ���ŵ�
			{
				return name;
			}
			
			public double getSalary() //method �������   ֻ����raiseSalary�����޸�
			{
				return salary;
			}
			
			public LocalDate getHireDay() //method �������     ��Ҫ��д�������ÿɱ����ķ���������������ƻ���װ��    LocalDate��û�и�����������LocalDate�����ǲ��ɱ��
			{
				return hireDay;
			}
			
			/*public Date getHireday()
			{
				return hireday;     //Date����һ������������setTime(),Date�����ǿɱ��
			}
			*/ 
			public void ralseSalary(double byPercent)  //method  �������
			{
				double ralse=this.salary*byPercent/100;  //�ؼ���this��ʾ��ʽ���������Խ�ʵ������ֲ��������Ե����ֿ�
				this.salary+=ralse;				
			}

}

