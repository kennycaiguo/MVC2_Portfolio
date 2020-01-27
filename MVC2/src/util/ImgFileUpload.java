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
	private final StringBuffer FILE_UPLOAD_MEMBER = new StringBuffer();
	private final StringBuffer FILE_UPLOAD_TEMP = new StringBuffer();
	private String getFileName;
	private String memberDir;
	private String tempDir;
	private String id;
	private final boolean MEMBER = true;
	private final boolean TEMP = false;

	public ImgFileUpload() {
		setVariable(null);
	}

	public ImgFileUpload(String file) {
		this.file = file;
		setVariable(null);
	}

	public ImgFileUpload(String file, String id) {
		this.file = file;
		setVariable(id);
	}

	public String fileUpload(boolean flag) throws Exception {
		String fileName = null;
		if (!fileCheck(MEMBER))
			fileName = upload(MEMBER);
		if (flag) {
			fileName = upload(TEMP);
			fileDelete(TEMP);
		}
		return fileName;
	}

	public String fileUpdate(String oldFile) throws Exception {
		File file = null;
		String newFileName = fileUpload(TEMP);// temp경로에 임시로 newFileimg 생성
		// System.out.println("FILE_UPLOAD_MEMBER:" + FILE_UPLOAD_MEMBER.toString());
		// System.out.println("FILE_UPLOAD_TEMP:" + FILE_UPLOAD_TEMP.toString());
		// System.out.println("newFileName:" + newFileName);
		dirPathReset();
		FILE_UPLOAD_MEMBER.append(oldFile);
		this.file = FILE_UPLOAD_MEMBER.toString();
		FILE_UPLOAD_TEMP.append("old_" + oldFile);
		String oldFileName = fileUpload(TEMP);
		// System.out.println("oldFileName:" + oldFileName);
		file = new File(FILE_UPLOAD_MEMBER.toString());
		if (file.exists()) {
			fileDelete(MEMBER);
			dirPathReset();
			FILE_UPLOAD_MEMBER.append("(" + id + ")" + getFileName);
			FILE_UPLOAD_TEMP.append(new File(newFileName).getName());
			newFileName = fileUpload(MEMBER);
		}

		// System.out.println("finish newFileName:" + newFileName);
		return newFileName;
	}

	private void setVariable(String id) {
		FILE_UPLOAD_MEMBER.append(ROOT);
		FILE_UPLOAD_MEMBER.append("WebContent");
		FILE_UPLOAD_MEMBER.append(SEPARATOR);
		FILE_UPLOAD_MEMBER.append("imgFile");
		FILE_UPLOAD_MEMBER.append(SEPARATOR);
		FILE_UPLOAD_MEMBER.append("member");
		FILE_UPLOAD_MEMBER.append(SEPARATOR);

		FILE_UPLOAD_TEMP.append(ROOT);
		FILE_UPLOAD_TEMP.append("WebContent");
		FILE_UPLOAD_TEMP.append(SEPARATOR);
		FILE_UPLOAD_TEMP.append("imgFile");
		FILE_UPLOAD_TEMP.append(SEPARATOR);
		FILE_UPLOAD_TEMP.append("temp");
		FILE_UPLOAD_TEMP.append(SEPARATOR);
		memberDir = FILE_UPLOAD_MEMBER.toString();
		tempDir = FILE_UPLOAD_TEMP.toString();
		if (this.file != null) {
			getFileName = new File(this.file).getName().toLowerCase();
		}
		if (id != null) {
			this.id = id;
			FILE_UPLOAD_MEMBER.append("(" + id + ")" + getFileName);
		}
		FILE_UPLOAD_TEMP.append("(TEMP)" + getFileName);
	}

	private void dirPathReset() {
		FILE_UPLOAD_MEMBER.delete(memberDir.length(), FILE_UPLOAD_MEMBER.length());
		FILE_UPLOAD_TEMP.delete(tempDir.length(), FILE_UPLOAD_TEMP.length());
		// System.out.println("pathReset:" + FILE_UPLOAD_MEMBER.toString());
		// System.out.println("tempReset:" + FILE_UPLOAD_TEMP.toString());
	}

	private boolean fileCheck(boolean flag) throws Exception {
		if (flag) {
			// System.out.println("TEMP FILE CHECK");
			return new File(FILE_UPLOAD_TEMP.toString()).exists();
		}
		// System.out.println("PATH FILE CHECK");
		return new File(FILE_UPLOAD_MEMBER.toString()).exists();
	}

	private String upload(boolean flag) throws Exception {// refactoring 대상
		String tempFileName = null;
		InputStream in = null;
		OutputStream out = null;
		FileChannel infc = null;
		FileChannel outfc = null;
		String inUrl = flag ? this.file : FILE_UPLOAD_TEMP.toString();
		String outUrl = flag ? FILE_UPLOAD_TEMP.toString() : FILE_UPLOAD_MEMBER.toString();

		// System.out.println("inUrl:" + inUrl);
		// System.out.println("outUrl:" + outUrl);

		try {
			in = new FileInputStream(inUrl);
			infc = ((FileInputStream) in).getChannel();
			out = new FileOutputStream(outUrl);
			outfc = ((FileOutputStream) out).getChannel();
			infc.transferTo(0, infc.size(), outfc);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (closeAll(outfc, out, infc, in)) {
				tempFileName = flag ? FILE_UPLOAD_TEMP.toString() : FILE_UPLOAD_MEMBER.toString();
			}

		}
		return tempFileName;
	}

	private void fileDelete(boolean flag) throws Exception {
		File target = new File(flag ? FILE_UPLOAD_MEMBER.toString() : FILE_UPLOAD_TEMP.toString());
		if (target.exists()) {
			if (flag) {
				target = new File(FILE_UPLOAD_MEMBER.toString());
				// System.out.println("MEMBER_delete:" + target.getName());
				target.delete();
			} else {
				target = new File(FILE_UPLOAD_TEMP.toString());
				// System.out.println("TEMP_delete:" + target.getName());
				target.delete();
			}

		}
	}

	private boolean closeAll(Object... obj) throws Exception {// 가능하면 if문 줄여보기
		List<Boolean> flag = new ArrayList<Boolean>();
		List<Boolean> alltrue = new ArrayList<Boolean>();
		try {
			for (int i = 0; i < obj.length; i++) {
				flag.add(false);
				alltrue.add(true);
				if (obj[i] instanceof OutputStream) {
					((OutputStream) obj[i]).close();
					// System.out.println("OutputStream 객체 close");
					flag.set(i, true);
				}
				if (obj[i] instanceof InputStream) {
					((InputStream) obj[i]).close();
					// System.out.println("InputStream 객체 close");
					flag.set(i, true);
				}
				if (obj[i] instanceof FileChannel) {
					((FileChannel) obj[i]).close();
					// System.out.println("FileChannel 객체 close");
					flag.set(i, true);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Arrays.deepEquals(flag.toArray(), alltrue.toArray());
	}

	// ELFunction 사용
	public String getPath(String where) throws Exception {
		dirPathReset();
		return where.equals("temp") ? substr(tempDir):substr(memberDir);
	}
	private String substr(String path) {
		return path.substring((ROOT+"WebContent"+SEPARATOR).length());
	}
}
