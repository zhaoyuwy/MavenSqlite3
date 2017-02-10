package com.syz.test.entity;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity

// 注意不是hibernate的

@Table(name = "PERSON")

// 注意不是hibernate的

public class Person {

	public String pid;

	public String name;

	public Integer age;

	// 实体类的id，id生成策略是uuid

	@Id

	@Column(name = "ID", unique = true, nullable = false, length = 32)

	@GeneratedValue(generator = "paymentableGenerator")

	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	public String getPid() {

		return pid;

	}

	public void setPid(String pid) {

		this.pid = pid;

	}

	@Column(name = "name", length = 255)

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	@Column(name = "age", precision = 11, scale = 0)

	public Integer getAge() {

		return age;

	}

	public void setAge(Integer age) {

		this.age = age;

	}

}