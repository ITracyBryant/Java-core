package yell.cohen;

public class Constants {
	
	public static final double tk=3.33; //类常量

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double m=tk;
		final double CM_PER_INCH=2.54; //定义常量
		double paperWidth=8.5;
		double paperHeight=11;
		System.out.println("Paper size in centimeters: "
		 + paperWidth*CM_PER_INCH + " by " + paperHeight*CM_PER_INCH+" in the price of "+m);
		
		for(int i=10;i>0;i--)
			System.out.println("Counting down..."+i+" Blastoff!");
		System.out.println("Blastoff!");
	}

}
