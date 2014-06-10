package com.mylive.paybank.dao.impl;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.mylive.paybank.dao.LoginUserDao;
import com.mylive.paybank.module.T_paybank_user;

public class LoginUserDaoImpl implements LoginUserDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 注册用户
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_user regUser(T_paybank_user l) throws SQLException {
		sqlMapClient.insert("regUser",l);
		return l;
	}

	/**
	 * 用户登录
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_user loginUser(T_paybank_user l) throws SQLException {
		return (T_paybank_user) sqlMapClient.queryForObject("loginUser",l);
	}

	/**
	 * 修改用户
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public Integer updateLoginUser(T_paybank_user l) throws SQLException {
		return sqlMapClient.update("updateLoginUser",l);
	}
}
