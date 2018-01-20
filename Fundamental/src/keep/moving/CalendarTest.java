package keep.moving;

import java.time.*;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate date=LocalDate.now(); //构造一个 日历对象，用当前时间初始化
		int month=date.getMonthValue();
		int today=date.getDayOfMonth();
		
		date=date.minusDays(today-1); //set to start of a month
		DayOfWeek weekday=date.getDayOfWeek(); //weekday得到当前日期是星期几，作为DayOfWeek类的一个实例返回
	    int value=weekday.getValue(); //1=Monday,2=Tuesday,...,7=Sunday
	    
	    System.out.println("Mon Tue Wed Thu Fri Sat Sun"); //打印表头
	    for(int i=1;i<value;i++)
	    	System.out.print("    "); //第一行的缩进，使得月份的第一天指向相应的星期几，不用换行
	    while(date.getMonthValue()==month)  //当月则循环
	    {
	    	System.out.printf("%3d", date.getDayOfMonth());//与表头对应，打印该月每天日期
	    	if(date.getDayOfMonth()==today){
	    		System.out.print("*");//当天日期用*标记
	    		}
	    	else{
	    		System.out.print(" ");//否则缩进一格
	    	}
	    	date=date.plusDays(1);//累加器，每次循环向后推进一天
	    	if(date.getDayOfWeek().getValue()==1) System.out.println(); //若到达新的一周的第一天，则换行打印
	    }
	    if(date.getDayOfWeek().getValue()!=1) System.out.println();//当月结束，则迭代（循环）停止换行
	}

}

