package com.syz.test.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cat")
public class Cat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Long id;

	public String username;

	public String password;

//	 @Id
//	    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TestSequence")
//	    //@GeneratedValue(strategy=GenerationType.IDENTITY) // MYSQL时可以这样使用自增
//	    @SequenceGenerator(name = "TestSequence", sequenceName = "SEQ_Test", allocationSize=1)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length = 18, unique = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(length = 18)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
