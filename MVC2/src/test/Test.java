package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.ImgFileUpload;

public class Test {

	public static void main(String[] args) {
//		String rootPath = new File("").getAbsolutePath();// System.getProperty("user.dir")
//		String separator = File.separator;
//		String file_uploadPath = rootPath + separator + "WebContent" + separator + "WEB-INF" + separator + "imgFile"
//				+ separator + "member" + separator;
//		System.out.println(file_uploadPath);
//		String adminFileurl = "C:" + separator + "Users" + separator + "Administrator" + separator + "Desktop"
//				+ separator + "admin.jpg";
//		String file_name= new File(adminFileurl).getName();
//		InputStream in = null;
//		InputStreamReader inr = null;
//		BufferedInputStream ibr= null;
//		OutputStream out = null;
//		BufferedOutputStream outb = null;
//		FileChannel fcin=null;
//		FileChannel fcout=null;
//		try {
//			in = new FileInputStream(adminFileurl);
//			//ibr= new BufferedInputStream(in);
//			fcin= ((FileInputStream) in).getChannel();
//			out = new FileOutputStream(file_uploadPath+file_name);
//			//outb = new BufferedOutputStream(out);
//			fcout= ((FileOutputStream) out).getChannel();
//			long size= fcin.size();
//			System.out.println(fcin.transferTo(0, size, fcout));
//			/*
//			 * while (true) { int data = ibr.read(); System.out.println(data); if (data ==
//			 * -1) break; outb.write(data); }
//			 */
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (fcout != null)
//					fcout.close();
//				if (out != null)
//					out.close();
//				if (fcin != null)
//					fcin.close();
//				if (in != null)
//					in.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		/*
		 * final StringBuffer FILE_UPLOAD_PATH=new StringBuffer(); final StringBuffer
		 * FILE_UPLOAD_TEMP=new StringBuffer(); final String ROOT= new
		 * File("").getAbsolutePath(); final String SEPARATOR= File.separator;
		 * FILE_UPLOAD_PATH.append(ROOT); FILE_UPLOAD_PATH.append(SEPARATOR);
		 * FILE_UPLOAD_PATH.append("WebContent"); FILE_UPLOAD_PATH.append(SEPARATOR);
		 * FILE_UPLOAD_PATH.append("WEB-INF"); FILE_UPLOAD_PATH.append(SEPARATOR);
		 * FILE_UPLOAD_PATH.append("imgFile"); FILE_UPLOAD_PATH.append(SEPARATOR);
		 * FILE_UPLOAD_PATH.append("member"); FILE_UPLOAD_PATH.append(SEPARATOR);
		 * 
		 * FILE_UPLOAD_TEMP.append(ROOT); FILE_UPLOAD_TEMP.append(SEPARATOR);
		 * FILE_UPLOAD_TEMP.append("WebContent"); FILE_UPLOAD_TEMP.append(SEPARATOR);
		 * FILE_UPLOAD_TEMP.append("WEB-INF"); FILE_UPLOAD_TEMP.append(SEPARATOR);
		 * FILE_UPLOAD_TEMP.append("imgFile"); FILE_UPLOAD_TEMP.append(SEPARATOR);
		 * FILE_UPLOAD_TEMP.append("temp"); FILE_UPLOAD_TEMP.append(SEPARATOR);
		 * FILE_UPLOAD_TEMP.append("TEMP_admin.jpg");
		 * System.out.println(FILE_UPLOAD_PATH.toString());
		 * System.out.println(FILE_UPLOAD_TEMP.toString()); System.out.println(new
		 * File(FILE_UPLOAD_PATH.toString())); System.out.println(new
		 * File(FILE_UPLOAD_TEMP.toString()).delete());
		 */
		List<Boolean> flag= new ArrayList<Boolean>();
		List<Boolean> alltrue= new ArrayList<Boolean>();
		for(int i=0; i<10; i++) {
			flag.add(false);
			alltrue.add(true);
			if(true) {
				flag.set(i, true);
			}
		}
		System.out.println(Arrays.deepEquals(flag.toArray(), alltrue.toArray()));
		String separator = File.separator;
		String root = "C:" + separator + "git" + separator + "MVC2_Portfolio" + separator + "MVC2"+separator;
		ImgFileUpload imgtest=new ImgFileUpload(root+"WebContent"+separator+"WEB-INF"+separator+"imgFile"+separator+"temp"+separator+"cat.jpg","tester");
		try {
			System.out.println(imgtest.fileUpload(true));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
