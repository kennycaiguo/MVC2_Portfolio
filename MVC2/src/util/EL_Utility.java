package util;

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
}
