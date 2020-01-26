package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImgFileUpload {
	private String file;
	private final String SEPARATOR = File.separator;
	private final String ROOT = "C:" + SEPARATOR + "git" + SEPARATOR + "MVC2_Portfolio" + SEPARATOR + "MVC2"
			+ SEPARATOR;
	private final StringBuffer FILE_UPLOAD_PATH = new StringBuffer();
	private final StringBuffer FILE_UPLOAD_TEMP = new StringBuffer();
	private String getFileName;
	private Object tempFileName;
	private Object memberFileName;

	public ImgFileUpload() {
	}

	public ImgFileUpload(String file) {
		this.file = file;
		setVariable(null);
		/*
		 * System.out.println("user Constructor parameter file:" + file);
		 * System.out.println("member variable file:" + this.file);
		 * System.out.println("member variavle getFileName:" + getFileName);
		 * System.out.println("member variable filaName:" + fileName);
		 */
	}

	public ImgFileUpload(String file, String id) {
		this.file=file;
		setVariable(id);
	}

	private void setVariable(String id) {
		FILE_UPLOAD_PATH.append(ROOT);
		FILE_UPLOAD_PATH.append("WebContent");
		FILE_UPLOAD_PATH.append(SEPARATOR);
		FILE_UPLOAD_PATH.append("WEB-INF");
		FILE_UPLOAD_PATH.append(SEPARATOR);
		FILE_UPLOAD_PATH.append("imgFile");
		FILE_UPLOAD_PATH.append(SEPARATOR);
		FILE_UPLOAD_PATH.append("member");
		FILE_UPLOAD_PATH.append(SEPARATOR);

		FILE_UPLOAD_TEMP.append(ROOT);
		FILE_UPLOAD_TEMP.append("WebContent");
		FILE_UPLOAD_TEMP.append(SEPARATOR);
		FILE_UPLOAD_TEMP.append("WEB-INF");
		FILE_UPLOAD_TEMP.append(SEPARATOR);
		FILE_UPLOAD_TEMP.append("imgFile");
		FILE_UPLOAD_TEMP.append(SEPARATOR);
		FILE_UPLOAD_TEMP.append("temp");
		FILE_UPLOAD_TEMP.append(SEPARATOR);

		getFileName = new File(this.file).getName();
		if (id != null) {
			memberFileName = "(" + id + ")" + getFileName;
		}
		tempFileName = "(TEMP)" + getFileName;
	}

	public String fileUpload(boolean flag) throws Exception {
		if (flag) {
			return memberFileUpload();
		}
		return null;
	}

	private String memberFileUpload() throws Exception {
		if (!tempFileCheck()) {
			fileUpload("temp");
		}
		FILE_UPLOAD_PATH.append(memberFileName);
		return fileUpload("member");
	}

	private boolean tempFileCheck() throws Exception {
		FILE_UPLOAD_TEMP.append(tempFileName);
		System.out.println("FileCheck method:" + FILE_UPLOAD_TEMP.toString());
		return new File(FILE_UPLOAD_TEMP.toString()).exists();
	}

	private String fileUpload(String path) throws Exception {// refactoring 대상
		String tempFileName = null;
		InputStream in = null;
		OutputStream out = null;
		FileChannel infc = null;
		FileChannel outfc = null;

		String inUrl = path.equals("temp") ? this.file : FILE_UPLOAD_TEMP.toString();
		String outUrl = path.equals("temp") ? FILE_UPLOAD_TEMP.toString() : FILE_UPLOAD_PATH.toString();
		System.out.println("memberPath:" + FILE_UPLOAD_PATH.toString());
		System.out.println("tempPath:" + FILE_UPLOAD_TEMP.toString());
		System.out.println("inUrl:" + inUrl);
		System.out.println("outUrl" + outUrl);
		long i = 0;
		try {
			in = new FileInputStream(inUrl);
			infc = ((FileInputStream) in).getChannel();
			out = new FileOutputStream(outUrl);
			outfc = ((FileOutputStream) out).getChannel();
			i = infc.transferTo(0, infc.size(), outfc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (closeAll(outfc, out, infc, in)&&i>0)
				new File(FILE_UPLOAD_TEMP.toString()).delete();
		}
		return tempFileName;
	}

	private boolean closeAll(Object... obj) {// 가능하면 if문 줄여보기
		List<Boolean> flag = new ArrayList<Boolean>();
		List<Boolean> alltrue = new ArrayList<Boolean>();
		try {
			for (int i = 0; i < obj.length; i++) {
				flag.add(false);
				alltrue.add(true);
				if (obj[i] instanceof OutputStream) {
					((OutputStream) obj[i]).close();
					System.out.println("OutputStream 객체 close");
					flag.set(i, true);
				}
				if (obj[i] instanceof InputStream) {
					((InputStream) obj[i]).close();
					System.out.println("InputStream 객체 close");
					flag.set(i, true);
				}
				if (obj[i] instanceof FileChannel) {
					((FileChannel) obj[i]).close();
					System.out.println("FileChannel 객체 close");
					flag.set(i, true);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Arrays.deepEquals(flag.toArray(), alltrue.toArray());
	}

	// delete 고려대상
	/*
	 * public boolean fileRead() throws Exception { File file = new
	 * File(FILE_UPLOAD_TEMP.toString() + fileName); System.out.println("check url:"
	 * + FILE_UPLOAD_TEMP.toString() + fileName);
	 * System.out.println("file name check:" + file.getName());
	 * System.out.println("check:" + file.exists()); return file.exists(); }
	 */

	// ELFunction 사용
	public String getPath(String where) throws Exception {
		return where.toLowerCase().equals("temp") ? FILE_UPLOAD_TEMP.toString() : FILE_UPLOAD_PATH.toString();
	}
}
