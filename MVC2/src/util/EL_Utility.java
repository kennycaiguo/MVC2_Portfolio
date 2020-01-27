package util;

import java.io.File;
import java.util.List;

import member.MemberDAO;

public class EL_Utility {
	
	public EL_Utility() {
	}

	public static String getGrade(String id) {
		String grade=null;
		try {
			if (id != null)
				grade=new MemberDAO().read(id).getM_grade();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grade;
	}
	public static String getImgPath(String where) {
		String path=null;
		try {
			path=new ImgFileUpload().getPath(where);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	public static List<String> getMonth(){
		try {
			return new Utility().getMonth();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static List<String> getYear(){
		try {
			return new Utility().getYear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String getTempImg() {
		String fileName=null;
		try {
			fileName= new ImgFileUpload().fileUpload(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
