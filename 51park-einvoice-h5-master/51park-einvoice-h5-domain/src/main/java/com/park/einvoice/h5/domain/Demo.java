package com.park.einvoice.h5.domain;

import java.io.Serializable;

import com.park.einvoice.h5.domain.mybatis.Column;
import com.park.einvoice.h5.domain.mybatis.Index;
import com.park.einvoice.h5.domain.mybatis.Table;

@Table("demo")
public class Demo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Index("id")
	private int id;
	@Column("name")
	private String  name;
	@Column("age")
	private int age;
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
