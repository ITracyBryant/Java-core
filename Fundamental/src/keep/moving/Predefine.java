package keep.moving;

import java.util.Date;

public class Predefine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("%tc\n",new Date());
		System.out.printf("%1$s %2$tB %2$te, %2$tY\n","DUE DATE:",new Date());
		System.out.printf("%s %tB %<te, %<tY\n","DUE DATE:",new Date());
		
		Date birthday=new Date(); //��������������ʼ��   �����¶���Date()
		String s=birthday.toString();
		System.out.println(s);

		Date deadline = birthday; //deadline���������Ѵ��ڵĶ���
		String s1=deadline.toString();
		System.out.println(s1);
		
		Date c=null;  //��ʽ����Ϊ�գ��ö������Ŀǰû�������κζ���
		System.out.println(c);
		/*String s2=c.toString(); //���������ʱ����   runtime error!
		System.out.println(s2);*/


	}

}
