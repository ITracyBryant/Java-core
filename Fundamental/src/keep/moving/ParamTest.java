package keep.moving;

public class ParamTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Test 1:Methods can't modify numeric parameters
		System.out.println("Testing tripleValue:");
		double percent=10;
		System.out.println("Before: percent="+percent);
		tripleValue(percent);  //x变，percent不变    x用完就丢弃
		System.out.println("After: percent"+percent);  //一个方法不可能修改一格基本数据类型（数字，布尔值）的参数
		
		//Test 2:Methods can change the state of object parameters
		System.out.println("\nTesting tripleSalary:");
		Employee3 harry=new Employee3("Harry", 50000);
		System.out.println("Before: salary="+harry.getSalary());
		tripleSalary(harry);  //x被初始化为harry值的拷贝，这里是对一个新雇员对象的引用       x和harry同时引用的那个Employee3对象的salary提高200%
		System.out.println("After: salary="+harry.getSalary()); //但是，对象变量harry继续引用那个薪金增至3倍的Employee3对象
		
		//Test 3:Methods can't attach new objects to object parameters
		System.out.println("\nTesting swap:");
		Employee3 a=new Employee3("Alice", 70000);
		Employee3 b=new Employee3("Bob", 60000);
		System.out.println("Before: a="+a.getName());
		System.out.println("Before: b="+b.getName());
		swap(a,b);
		System.out.println("After: a="+a.getName());  //变量a和b仍然引用在swap方法调用之前所引用的对象
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
		System.out.println("End of method: salary="+x.getSalary());   //方法结束后，变量x不再使用
	}
	
	public static void swap(Employee3 x,Employee3 y)  //对象引用是按值传递的     Java总是采用按值调用
	{
		Employee3 temp=x;  
		x=y;
		y=temp;  //一个方法不能让对象参数引用一个新的对象
		System.out.println("End of method: x="+x.getName());
		System.out.println("End of method: y="+y.getName());  //swap方法的参数x,y被初始化为两个对象引用的拷贝，该方法交换的是这两个拷贝，在方法结束时参数变量x,y就被丢弃了
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


