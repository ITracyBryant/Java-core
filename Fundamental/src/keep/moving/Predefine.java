package keep.moving;

import java.util.Date;

public class Predefine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%tc\n",new Date());
		System.out.printf("%1$s %2$tB %2$te, %2$tY\n","DUE DATE:",new Date());
		System.out.printf("%s %tB %<te, %<tY\n","DUE DATE:",new Date());
		
		Date birthday=new Date(); //定义对象变量并初始化   引用新对象Date()
		String s=birthday.toString();
		System.out.println(s);

		Date deadline = birthday; //deadline变量引用已存在的对象
		String s1=deadline.toString();
		System.out.println(s1);
		
		Date c=null;  //显式设置为空，该对象变量目前没有引用任何对象
		System.out.println(c);
		/*String s2=c.toString(); //会产生运行时错误   runtime error!
		System.out.println(s2);*/


	}

}
