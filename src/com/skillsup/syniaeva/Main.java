package com.skillsup.syniaeva;

/**
 * Created by osyniaeva on 9/21/17.
 */
public class Main {
	public static void main(String[] args) {
		DBManager dbManager = new DBManager();
		dbManager.createTable();
		dbManager.addRecords(new User(1, "Masha", 33, "Petriva"));
		dbManager.addRecords(new User(2, "Vasya", 45, "Pupkin"));
		System.out.println(dbManager.getRegistratedUsers());

	}
}
