package com.mylive.paybank.dao;

import java.sql.SQLException;

import com.mylive.paybank.module.T_paybank_shouzhi;
import com.mylive.paybank.module.T_paybank_zhichutype;

/**
 * 
 * @author talkxin
 * 
 */
public interface PayBankDao {
	/**
	 * 保存支出类型
	 * 
	 * @param t
	 * @return
	 */
	public T_paybank_zhichutype insertZhichu(T_paybank_zhichutype t)
			throws SQLException;

	/**
	 * 修改支出类型
	 * 
	 * @param t
	 * @return
	 */
	public boolean updateZhichu(T_paybank_zhichutype t) throws SQLException;

	/**
	 * 删除支出类型
	 * 
	 * @param t
	 * @return
	 */
	public boolean deleteZhichu(T_paybank_zhichutype t) throws SQLException;

	/**
	 * 保存收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_shouzhi insertShouzhi(T_paybank_shouzhi t)
			throws SQLException;

	/**
	 * 修改收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public boolean updateShouzhi(T_paybank_shouzhi t) throws SQLException;

	/**
	 * 删除收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteShouzhi(T_paybank_shouzhi t) throws SQLException;
}
