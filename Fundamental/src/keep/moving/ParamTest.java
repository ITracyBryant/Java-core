package keep.moving;

public class ParamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test 1:Methods can't modify numeric parameters
		System.out.println("Testing tripleValue:");
		double percent=10;
		System.out.println("Before: percent="+percent);
		tripleValue(percent);  //x�䣬percent����    x����Ͷ���
		System.out.println("After: percent"+percent);  //һ�������������޸�һ������������ͣ����֣�����ֵ���Ĳ���
		
		//Test 2:Methods can change the state of object parameters
		System.out.println("\nTesting tripleSalary:");
		Employee3 harry=new Employee3("Harry", 50000);
		System.out.println("Before: salary="+harry.getSalary());
		tripleSalary(harry);  //x����ʼ��Ϊharryֵ�Ŀ����������Ƕ�һ���¹�Ա���������       x��harryͬʱ���õ��Ǹ�Employee3�����salary���200%
		System.out.println("After: salary="+harry.getSalary()); //���ǣ��������harry���������Ǹ�н������3����Employee3����
		
		//Test 3:Methods can't attach new objects to object parameters
		System.out.println("\nTesting swap:");
		Employee3 a=new Employee3("Alice", 70000);
		Employee3 b=new Employee3("Bob", 60000);
		System.out.println("Before: a="+a.getName());
		System.out.println("Before: b="+b.getName());
		swap(a,b);
		System.out.println("After: a="+a.getName());  //����a��b��Ȼ������swap��������֮ǰ�����õĶ���
		System.out.println("After: b="+b.getName());
		
	}
	
	public static void tripleValue(double x)  //doesn't work
	{
		x=x*3;
		System.out.println("End of method: x="+x);
	}
	
	public static void tripleSalary(Employee3 x) //works
	{
		x.raiseSalary(200);   
		System.out.println("End of method: salary="+x.getSalary());   //���������󣬱���x����ʹ��
	}
	
	public static void swap(Employee3 x,Employee3 y)  //���������ǰ�ֵ���ݵ�     Java���ǲ��ð�ֵ����
	{
		Employee3 temp=x;  
		x=y;
		y=temp;  //һ�����������ö����������һ���µĶ���
		System.out.println("End of method: x="+x.getName());
		System.out.println("End of method: y="+y.getName());  //swap�����Ĳ���x,y����ʼ��Ϊ�����������õĿ������÷������������������������ڷ�������ʱ��������x,y�ͱ�������
	}
}
	
class Employee3  //simplified Employee class
{
	private String name;
	private double salary;		
		
	public Employee3(String n,double s)
	{
		name=n;
		salary=s;
	}
		
	public String getName()
	{
		return name;
	}
		
	public double getSalary()
	{

		return salary;
	}
		
	public void raiseSalary(double byPercent)
	{
		double raise=salary*byPercent/100;
		salary+=raise;
	}
}


