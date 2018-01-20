package good.advancing;

public class Message {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length==0||args[0].equals("-h"))//Óë¶ÌÂ·
			System.out.print("Hello,");
		else if(args[0].equals("-g"))
			System.out.print("Go away,");
		// go on printing the other command-line arguments
		for(int i=1;i<args.length;i++)
			System.out.print(" "+args[i]);
		System.out.println("!");

	}

}
