package 序列化与反序列化;

import java.io.Serializable;
import java.util.Date;

public class User {
//	private static final long serialVersionUID = 1415125151614201344L;
	private String user;
	private int age;
	private Date birthday;
	private transient String gender;
	private transient int[] array=new int[5];
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int[] getArray() {
		return array;
	}
	public void setArray(int[] array) {
		this.array = array;
	}

}
