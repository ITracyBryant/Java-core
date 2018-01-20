package keep.moving;

import java.text.NumberFormat;

public class FactoryMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFormat currencyFormatter=NumberFormat.getCurrencyInstance();
		NumberFormat percentFormatter=NumberFormat.getPercentInstance();
		double x=0.1;
		System.out.println(currencyFormatter.format(x));//prints $0.10
		System.out.println(percentFormatter.format(x));//prints 10%

	}

}
