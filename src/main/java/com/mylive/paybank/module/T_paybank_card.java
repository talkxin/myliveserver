package com.mylive.paybank.module;

public class T_paybank_card {
	private Integer id;
	private Integer uid;
	private Integer homeID;
	private String cardNo;
	private String name;

	public Integer getId() {
		return id;
	}

	public Integer getHomeID() {
		return homeID;
	}

	public void setHomeID(Integer homeID) {
		this.homeID = homeID;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
