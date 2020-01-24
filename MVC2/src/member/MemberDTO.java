/**
 * 
 */
package member;

import java.io.File;
import java.io.Serializable;

/**
 * @author user
 *
 */
public class MemberDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String m_grade;
	private String name;
	private int age;
	private String birth;
	private String email;
	private String img;
	private File img_file;

	/**
	 * 
	 */
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String id, String password, String name, String birth, String email, String img) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.email = email;
		this.img = img;
	}

	public MemberDTO(String id, String password, String m_grade, String name, int age, String birth, String email,
			String img) {
		this.id = id;
		this.password = password;
		this.m_grade = m_grade;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.email = email;
		this.img = img;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the class
	 */
	public String getM_grade() {
		return m_grade;
	}

	/**
	 * @param class1 the class to set
	 */
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the serialversionuid
	 */

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the img_file
	 */
	public File getImg_file() {
		return img_file;
	}

	/**
	 * @param img_file the img_file to set
	 */
	public void setImg_file(File img_file) {
		this.img_file = img_file;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
