package com.upic.po;
/**
 * 
 * @author DTZ
 *
 */
public class User {

	private String userName;
	private Long id;
	private int age;

	private String position;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public User(String userName, Long id, int age, String position) {
		super();
		this.userName = userName;
		this.id = id;
		this.age = age;
		this.position = position;
	}

	public User(String userName, Long id, int age) {
		super();
		this.userName = userName;
		this.id = id;
		this.age = age;
	}

	public User() {
		super();
	}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", id=" + id + ", age=" + age + "]";
	}
	
}
