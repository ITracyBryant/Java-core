/**
 * 
 */
package proxy;

import java.lang.reflect.*;
import java.util.*;

/**
 * This program demonstrates the use of proxies.
 * @xincheng 2017年10月25日 Administrator
 *
 */
public class ProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object[] elements = new Object[1000];
		
		//fill elements with  proxies for the integers 1 ... 1000
		for(int i = 0; i < elements.length; i++)
		{
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			elements[i] = proxy;
		}
		
		//construct a random integer
		Integer key = new Random().nextInt(elements.length) + 1;
		
		//search for the key
		int result = Arrays.binarySearch(elements, key);
		
		//print match if found
		if(result >= 0){
			System.out.println(elements[result]);
		}
	}
}



/**
 * An invocation handler that prints out the method name and parameters, then invokes the original method
 * @xincheng 2017年10月27日 Administrator
 *
 */
class TraceHandler implements InvocationHandler
{
	private Object target;
	
	/**
	 * Constructs a TraceHandler
	 * @param t the implicit parameters(隐式参数) of the method call
	 */
	public TraceHandler(Object t)
	{
		target = t;
	}
	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
	{
		//print implicit argument
		System.out.print(target);
		//print method name
		System.out.print("." + m.getName() + "(");
		//print explicit arguments
		if(args != null)
		{
			for(int i = 0; i < args.length; i++)
			{
				System.out.print(args[i]);
				if(i < args.length - 1)
				{
					System.out.print(", ");
				}
			}
		}
		System.out.println(")");
		
		//invoke actual method
		return m.invoke(target, args);
	}
}


	
