package com.mylive.paybank.dao;

import java.sql.SQLException;

import com.mylive.paybank.module.T_paybank_user;

/**
 * 管理用户注册
 * 
 * @author talkxin
 * 
 */
public interface LoginUserDao {
	/**
	 * 注册用户
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public LoginUserDao regUser(T_paybank_user l) throws SQLException;

	/**
	 * 用户登录
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public LoginUserDao loginUser(T_paybank_user l) throws SQLException;
}
