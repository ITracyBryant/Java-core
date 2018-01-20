package yell.cohen;

public class Ergodic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String greeting="Hello";
		int n=greeting.length();
		System.out.println(n);
		int cpCount=greeting.codePointCount(0, n);
		System.out.println(cpCount);
		char x=greeting.charAt(1);
		System.out.println(x);
		int index=greeting.offsetByCodePoints(0,1);//?
		int cp=greeting.codePointAt(index);
		System.out.println(cp);
		String sentence="\u1D546 is the set of octonions";//八元数集\u1D546
		char ch=sentence.charAt(1);
		System.out.println(ch);
		//遍历字符串，并依次查看每一个码点
		int i = 0;
		int cd=sentence.codePointAt(i);
		if(Character.isSupplementaryCodePoint(cd))
			i+=2;
		else
			i++;
		System.out.println(cd);
		//回退
		i--;
		if(Character.isHighSurrogate(sentence.charAt(i)))
				i--;
		int cd1=sentence.codePointAt(i);
		System.out.println(cd1);
		
		StringBuilder builder=new StringBuilder();
		String str1="With the eyes of programmers";
		String str2=" to more understanding of the world!";
		builder.append(str1);
		builder.append(str2);
		String completeString=builder.toString();
		System.out.println(completeString);
		

	}

}
