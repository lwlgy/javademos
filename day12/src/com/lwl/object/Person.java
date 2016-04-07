package com.lwl.object;

public class Person {
	private int id;
	private String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", id=" + id + "]";
	}
	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		return this.id == p.id;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
}
