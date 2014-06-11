package com.mylive.paybank.dao;

import java.sql.SQLException;
import java.util.List;

import com.mylive.paybank.module.T_paybank_home;
import com.mylive.paybank.module.T_paybank_home_all;

/**
 * 管理家庭成员
 * 
 * @author talkxin
 * 
 */
public interface HomeDao {
	/**
	 * 添加家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home insertHome(T_paybank_home home) throws SQLException;

	/**
	 * 修改家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	@Deprecated
	public Integer updateHome(T_paybank_home home) throws SQLException;

	/**
	 * 删除家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteHome(T_paybank_home home) throws SQLException;

	/**
	 * 添加家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public void insertHomeUser(T_paybank_home_all all)
			throws SQLException;

	/**
	 * 修改家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public Integer updateHomeUser(T_paybank_home_all all) throws SQLException;

	/**
	 * 删除家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteHomeUser(T_paybank_home_all all) throws SQLException;

	/**
	 * 获取家庭创建信息
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home getHomeInfo(T_paybank_home all) throws SQLException;

	/**
	 * 获取家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public List<T_paybank_home_all> getAllHomeUser(T_paybank_home_all all)
			throws SQLException;
}
