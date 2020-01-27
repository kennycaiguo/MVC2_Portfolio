package util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Utility {

	public Utility() {
	}

	public int getAge(String year, String month) throws Exception{
		int age = Calendar.getInstance().get(Calendar.YEAR) - strCastingint(year);
		if (strCastingint(month) < 3) {
			return age + 1;
		}
		return age + 2;
	}
	public  List<String> getYear() throws Exception{
		int year=Calendar.getInstance().get(Calendar.YEAR);
		List<String> years=new ArrayList<String>();
		for(int i=year; i>year-100; i--) {
			years.add(intCastionstr(i));
		}
		return years;
	}
	public  List<String> getMonth() throws Exception{
		List<String> month=new ArrayList<String>();
		for(int i=1;i<=12; i++) {
			month.add(intCastionstr(i));
		}
		return month;
	}
	
	
	private int strCastingint(String values) throws Exception{
		return Integer.parseInt(values);
	}
	private String intCastionstr(int values) throws Exception{
		String value=String.valueOf(values);
		return value.length()<2?"0"+value:value;
	}
}
