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
				Employee[] staff=new Employee[3]; //new 初始化对象
				//实例化三个员工对象填入构造的员工数组staff中
				staff[0]=new Employee("duanmaozhu",50000,1994,8,8);
				staff[1]=new Employee("xiaoyaobi",50001,1994,7,7);
				staff[2]=new Employee("TracyBryant", 50003,1995,10,3);
				
				//raise everyone's salary by 5%
				for(Employee e : staff) //类类型
					e.ralseSalary(10);
				
			    //print out information about all Employee objects
				for(Employee e : staff)
					System.out.println("name="+e.getName()+" , salary="+e.getSalary()
					+" , hireDay="+e.getHireDay());

			}

		}

		class Employee
		{
			private final String name;  //name属于String类类型的实例域    final实例域用于primitive类型域，immutable类的域
			private double salary;
			private LocalDate hireDay; //hireDay属于LocalDate类类型的实例域
		//	private Date hire-day;
			
			public Employee(String n,double s,int year,int month,int day)  //constructor 不要在构造器中定义与实例域重名的局部变量    因为 会屏蔽同名的实例域
			{
				name=n;
				salary=s;
				hireDay=LocalDate.of(year, month, day);
			}
			//在所有方法中不要命名与实例域同名的变量
			public String getName() //method 域访问器   name是private只读域，达到封装的优点
			{
				return name;
			}
			
			public double getSalary() //method 域访问器   只能由raiseSalary方法修改
			{
				return salary;
			}
			
			public LocalDate getHireDay() //method 域访问器     不要编写返回引用可变对象的访问器方法，这会破坏封装性    LocalDate类没有更改器方法，LocalDate对象是不可变的
			{
				return hireDay;
			}
			
			/*public Date getHireday()
			{
				return hireday;     //Date类有一个更改器方法setTime(),Date对象是可变的
			}
			*/ 
			public void ralseSalary(double byPercent)  //method  域更改器
			{
				double ralse=this.salary*byPercent/100;  //关键字this表示隐式参数，可以将实例域与局部变量明显的区分开
				this.salary+=ralse;				
			}

}

