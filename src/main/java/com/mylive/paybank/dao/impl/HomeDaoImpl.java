package com.mylive.paybank.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.mylive.paybank.dao.HomeDao;
import com.mylive.paybank.module.T_paybank_home;
import com.mylive.paybank.module.T_paybank_home_all;

public class HomeDaoImpl implements HomeDao {
	/**
	 * 添加家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home insertHome(T_paybank_home home) throws SQLException {
		return null;
	}

	/**
	 * 修改家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public boolean updateHome(T_paybank_home home) throws SQLException {
		return false;
	}

	/**
	 * 删除家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteHome(T_paybank_home home) throws SQLException {
		return false;
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
		return null;
	}

	/**
	 * 修改家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public boolean updateHomeUser(T_paybank_home_all all) throws SQLException {
		return false;
	}

	/**
	 * 删除家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteHomeUser(T_paybank_home_all all) throws SQLException {
		return false;
	}

	/**
	 * 获取家庭创建信息
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home getHomeInfo(T_paybank_home all) throws SQLException {
		return null;
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
		return null;
	}
}
