package com.estsoft.guestbook.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//domain & entity class 설계
@Entity
@Table(name = "guestbook")
public class Guestbook {
	@Id
	@Column(name = "no")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	// length: string에만 써야함
	@Column(name = "name", nullable = false, length = 100)
	private String name;
	@Column(name = "message", nullable = false)
	@Lob // Lob을 달면 CLOB, BLOB과 자동매핑
	private String message;
	@Column(name = "passwd", nullable = false, length = 32)
	private String password;
	@Column(name = "reg_date", nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP) // Timestamp ; oracle에 있는 방언 ->											// mysql에서는 datetime으로 자동으로 바뀜
	private Date regDate;

	/*
	// test
	private int intcount;
	private short shortcount2;
	@Column(precision = 10, scale = 3)
	private BigDecimal bigdecimalcount3;

	// columnDefinition 자기가 원하는 type으로 지정함
	@Column(name = "gender", nullable = false, columnDefinition = "enum('FEMALE','MALE')")
	// EnumType.ORDINAL 0,1로 값을 넣음(gender.female ; 0)
	// EnumType.STRING gender.female : female
	@Enumerated(value = EnumType.STRING)
	private Gender gender;
*/	@Transient
	private int temp;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
/*
	public int getIntcount() {
		return intcount;
	}

	public void setIntcount(int intcount) {
		this.intcount = intcount;
	}

	public short getShortcount2() {
		return shortcount2;
	}

	public void setShortcount2(short shortcount2) {
		this.shortcount2 = shortcount2;
	}

	public BigDecimal getBigdecimalcount3() {
		return bigdecimalcount3;
	}

	public void setBigdecimalcount3(BigDecimal bigdecimalcount3) {
		this.bigdecimalcount3 = bigdecimalcount3;
	}
*/
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
/*
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}*/

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	@Override
	public String toString() {
		return "Guestbook [no=" + no + ", name=" + name + ", message=" + message + ", password=" + password
				+ ", regDate=" + regDate +", temp=" + temp + "]";
	}

}
