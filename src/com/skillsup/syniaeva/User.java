package com.skillsup.syniaeva;

/**
 * Created by osyniaeva on 9/21/17.
 */
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private int age;

	public User(int id, String firstName, int age, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.age = age;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", age=" + age +
				'}';
	}
}
