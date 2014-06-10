package com.mylive.paybank.dao;

import java.sql.SQLException;
import java.util.List;

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
	public Integer updateZhichu(T_paybank_zhichutype t) throws SQLException;

	/**
	 * 删除支出类型
	 * 
	 * @param t
	 * @return
	 */
	public Integer deleteZhichu(T_paybank_zhichutype t) throws SQLException;

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
	public Integer updateShouzhi(T_paybank_shouzhi t) throws SQLException;

	/**
	 * 删除收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteShouzhi(T_paybank_shouzhi t) throws SQLException;

	/**
	 * 获取一个收支项
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_shouzhi getOneShouzhi(T_paybank_shouzhi t)
			throws SQLException;

	/**
	 * 获取收支列表
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public List<T_paybank_shouzhi> getShouzhiList(T_paybank_shouzhi t)
			throws SQLException;
}
