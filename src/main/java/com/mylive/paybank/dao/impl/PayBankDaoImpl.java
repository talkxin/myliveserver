package com.mylive.paybank.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.mylive.paybank.dao.PayBankDao;
import com.mylive.paybank.module.T_paybank_shouzhi;
import com.mylive.paybank.module.T_paybank_zhichutype;

public class PayBankDaoImpl implements PayBankDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 保存支出类型
	 * 
	 * @param t
	 * @return
	 */
	public T_paybank_zhichutype insertZhichu(T_paybank_zhichutype t)
			throws SQLException {
		sqlMapClient.insert("insertZhichu", t);
		return t;
	}

	/**
	 * 修改支出类型
	 * 
	 * @param t
	 * @return
	 */
	public Integer updateZhichu(T_paybank_zhichutype t) throws SQLException {
		return sqlMapClient.update("updateZhichu", t);
	}

	/**
	 * 删除支出类型
	 * 
	 * @param t
	 * @return
	 */
	public Integer deleteZhichu(T_paybank_zhichutype t) throws SQLException {
		return sqlMapClient.delete("deleteZhichu", t);
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
		sqlMapClient.insert("insertShouzhi", t);
		return t;
	}

	/**
	 * 修改收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public Integer updateShouzhi(T_paybank_shouzhi t) throws SQLException {
		return sqlMapClient.update("updateShouzhi", t);
	}

	/**
	 * 删除收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteShouzhi(T_paybank_shouzhi t) throws SQLException {
		return sqlMapClient.delete("deleteShouzhi", t);
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
		return (T_paybank_shouzhi) sqlMapClient.queryForObject("getOneShouzhi",
				t);
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
		return sqlMapClient.queryForList("getShouzhiList", t);
	}

	/**
	 * 获取所有支出项
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public List<T_paybank_zhichutype> getZhichuList(T_paybank_zhichutype t)
			throws SQLException {
		return sqlMapClient.queryForList("getZhichuList", t);
	}
}
