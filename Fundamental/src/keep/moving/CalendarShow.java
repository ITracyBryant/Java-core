package keep.moving;

import java.time.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarShow {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GregorianCalendar someDay=new GregorianCalendar(1999, 11, 31);//Odd feature of that class:month numbers go from 0 to 11
		someDay.add(Calendar.DAY_OF_MONTH, 1000);// mutator method
		
		int year=someDay.get(Calendar.YEAR);
		int month=someDay.get(Calendar.MONTH)+1;
		int day=someDay.get(Calendar.DAY_OF_MONTH);  //Accessory method
		System.out.printf("%2d%2d%3d\n",year,month,day);
		
		LocalDate newYearsEve=LocalDate.of(1999,12,31);
		int year1=newYearsEve.getYear();
		int month1=newYearsEve.getMonthValue();
		int day1=newYearsEve.getDayOfMonth();	//Accessory method
		System.out.printf("%2d%3d%3d\n",year1,month1,day1);
		
		LocalDate aThousandDaysLater=newYearsEve.plusDays(1000); //生成新的local date对象赋给aThousandDaysLater变量
		int year2=aThousandDaysLater.getYear();
		int month2=aThousandDaysLater.getMonthValue();
		int day2=aThousandDaysLater.getDayOfMonth();     //Accessory method
		System.out.printf("%2d%2d%3d\n",year2,month2,day2);

	}

}

