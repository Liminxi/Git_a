package com.yr.entry;

import java.io.Serializable;

//import java.util.Date;

//import org.springframework.format.annotation.DateTimeFormat;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String account;
	private String pd;
	private Integer age;
	private String sex;
	private String tel;
	private String email;
	private String addr;
 
	
	public User() {
		super();
	}

	public User(Integer id, String name, String account, String pd, Integer age, String sex, String tel, String email,
			String addr) {
		super();
		this.id = id;
		this.name = name;
		this.account = account;
		this.pd = pd;
		this.age = age;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.addr = addr;
		
	}
	public User( String name, String account, String pd, Integer age, String sex, String tel, String email,
			String addr) {
		super();
		this.name = name;
		this.account = account;
		this.pd = pd;
		this.age = age;
		this.sex = sex;
		this.tel = tel;
		this.email = email;
		this.addr = addr;
		
	}
	//@DateTimeFormat(pattern="yyyy-MM-dd")
//	private Date birth;
	 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPd() {
		return pd;
	}

	public void setPd(String pd) {
		this.pd = pd;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

//	public Date getBirth() {
//		return birth;
//	}
//	public void setBirth(Date birth) {
//		this.birth = birth;
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", account=" + account + ", pd=" + pd + ", age=" + age + ", sex="
				+ sex + ", tel=" + tel + ", email=" + email + ", addr=" + addr + "]";
	}
	

}
