package org.archfirst.template.domain;

public class Account {
	private int id;
	private String name;
	
	public Account() {
	}

	public Account(String name) {
		this.name = name;
	}

	public void copyFrom(Account other) {
		this.name = other.name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}
}
