package com.mylive.paybank.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.mylive.paybank.dao.PayBankDao;
import com.mylive.paybank.module.T_paybank_shouzhi;
import com.mylive.paybank.module.T_paybank_zhichutype;

public class PayBankDaoImpl implements PayBankDao {
	/**
	 * 保存支出类型
	 * 
	 * @param t
	 * @return
	 */
	public T_paybank_zhichutype insertZhichu(T_paybank_zhichutype t)
			throws SQLException {
		return null;
	}

	/**
	 * 修改支出类型
	 * 
	 * @param t
	 * @return
	 */
	public boolean updateZhichu(T_paybank_zhichutype t) throws SQLException {
		return false;
	}

	/**
	 * 删除支出类型
	 * 
	 * @param t
	 * @return
	 */
	public boolean deleteZhichu(T_paybank_zhichutype t) throws SQLException {
		return false;
	}

	/**
	 * 保存收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_shouzhi insertShouzhi(T_paybank_shouzhi t)
			throws SQLException {
		return null;
	}

	/**
	 * 修改收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public boolean updateShouzhi(T_paybank_shouzhi t) throws SQLException {
		return false;
	}

	/**
	 * 删除收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteShouzhi(T_paybank_shouzhi t) throws SQLException {
		return false;
	}

	/**
	 * 获取一个收支项
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_shouzhi getOneShouzhi(T_paybank_shouzhi t)
			throws SQLException {
		return null;
	}

	/**
	 * 获取收支列表
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public List<T_paybank_shouzhi> getShouzhiList(T_paybank_shouzhi t)
			throws SQLException {
		return null;
	}
}
