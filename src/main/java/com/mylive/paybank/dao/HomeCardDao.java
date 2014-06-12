package com.mylive.paybank.dao;

import java.sql.SQLException;
import java.util.List;

import com.mylive.paybank.module.T_paybank_card;

public interface HomeCardDao {
	/**
	 * 增加一张卡
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_card insertPayCard(T_paybank_card c) throws SQLException;

	/**
	 * 修改卡片信息
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public Integer updatePayCard(T_paybank_card c) throws SQLException;

	/**
	 * 删除卡片
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public Integer deletePayCard(T_paybank_card c) throws SQLException;

	/**
	 * 获取一个卡片信息
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_card getOneCard(T_paybank_card c) throws SQLException;

	/**
	 * 获取所有卡片信息
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public List<T_paybank_card> getCardList(T_paybank_card c)
			throws SQLException;
}
