package com.mylive.paybank.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.mylive.paybank.dao.HomeDao;
import com.mylive.paybank.module.T_paybank_home;
import com.mylive.paybank.module.T_paybank_home_all;

public class HomeDaoImpl implements HomeDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 添加家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home insertHome(T_paybank_home home) throws SQLException {
		sqlMapClient.insert("insertHome",home);
		return home;
	}

	/**
	 * 修改家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public Integer updateHome(T_paybank_home home) throws SQLException {
		return sqlMapClient.update("updateHome",home);
	}

	/**
	 * 删除家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteHome(T_paybank_home home) throws SQLException {
		return sqlMapClient.delete("deleteHome",home);
	}

	/**
	 * 添加家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home_all insertHomeUser(T_paybank_home_all all)
			throws SQLException {
		sqlMapClient.insert("insertHomeUser",all);
		return all;
	}

	/**
	 * 修改家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public Integer updateHomeUser(T_paybank_home_all all) throws SQLException {
		return sqlMapClient.update("updateHomeUser",all);
	}

	/**
	 * 删除家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteHomeUser(T_paybank_home_all all) throws SQLException {
		return sqlMapClient.delete("deleteHomeUser",all);
	}

	/**
	 * 获取家庭创建信息
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home getHomeInfo(T_paybank_home all) throws SQLException {
		return (T_paybank_home) sqlMapClient.queryForObject("getHomeInfo",all);
	}

	/**
	 * 获取家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public List<T_paybank_home_all> getAllHomeUser(T_paybank_home_all all)
			throws SQLException {
		return sqlMapClient.queryForList("getAllHomeUser",all);
	}
}
