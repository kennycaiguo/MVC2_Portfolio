package util;

import java.util.Calendar;

import member.MemberDAO;

public class Utility {

	public Utility() {
	}

	public int getAge(String year, String month) {
		int age = Calendar.getInstance().get(Calendar.YEAR) - strCastingint(year);
		if (strCastingint(month) < 3) {
			return age + 1;
		}
		return age + 2;

	}

	private int strCastingint(String values) {
		return Integer.parseInt(values);
	}


}
