package com.mylive.paybank.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.mylive.paybank.dao.HomeCardDao;
import com.mylive.paybank.module.T_paybank_card;

public class HomeCardDaoImpl implements HomeCardDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 增加一张卡
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_card insertPayCard(T_paybank_card c) throws SQLException {
		sqlMapClient.insert("insertPayCard", c);
		return c;
	}

	/**
	 * 修改卡片信息
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public Integer updatePayCard(T_paybank_card c) throws SQLException {
		return sqlMapClient.update("updatePayCard", c);
	}

	/**
	 * 删除卡片
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public Integer deletePayCard(T_paybank_card c) throws SQLException {
		return sqlMapClient.delete("deletePayCard", c);
	}

	/**
	 * 获取一个卡片信息
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_card getOneCard(T_paybank_card c) throws SQLException {
		return (T_paybank_card) sqlMapClient.queryForObject("getOneCard", c);
	}

	/**
	 * 获取所有卡片信息
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public List<T_paybank_card> getCardList(T_paybank_card c)
			throws SQLException {
		return sqlMapClient.queryForList("getCardList", c);
	}
}
