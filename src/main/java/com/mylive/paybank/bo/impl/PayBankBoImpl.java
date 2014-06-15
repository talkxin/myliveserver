package com.mylive.paybank.bo.impl;

import java.sql.SQLException;
import java.util.List;

import com.mylive.paybank.bo.PayBankBo;
import com.mylive.paybank.dao.HomeCardDao;
import com.mylive.paybank.dao.HomeDao;
import com.mylive.paybank.dao.LoginPayUserDao;
import com.mylive.paybank.dao.PayBankDao;
import com.mylive.paybank.module.T_paybank_card;
import com.mylive.paybank.module.T_paybank_home;
import com.mylive.paybank.module.T_paybank_home_all;
import com.mylive.paybank.module.T_paybank_shouzhi;
import com.mylive.paybank.module.T_paybank_user;
import com.mylive.paybank.module.T_paybank_zhichutype;

public class PayBankBoImpl implements PayBankBo {
	private HomeCardDao homeCardDao;
	private HomeDao homeDao;
	private LoginPayUserDao loginPayUserDao;
	private PayBankDao payBankDao;

	/**
	 * 增加一张卡
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_card insertPayCard(T_paybank_card c) throws SQLException {
		return homeCardDao.insertPayCard(c);
	}

	/**
	 * 修改卡片信息
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public Integer updatePayCard(T_paybank_card c) throws SQLException {
		return homeCardDao.updatePayCard(c);
	}

	/**
	 * 删除卡片
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public Integer deletePayCard(T_paybank_card c) throws SQLException {
		return homeCardDao.deletePayCard(c);
	}

	/**
	 * 获取一个卡片信息
	 * 
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_card getOneCard(T_paybank_card c) throws SQLException {
		return homeCardDao.getOneCard(c);
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
		return homeCardDao.getCardList(c);
	}

	/**
	 * 添加家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home insertHome(T_paybank_home home) throws SQLException {
		return homeDao.insertHome(home);
	}

	/**
	 * 删除家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteHome(T_paybank_home home) throws SQLException {
		return homeDao.deleteHome(home);
	}

	/**
	 * 添加家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public void insertHomeUser(T_paybank_home_all all) throws SQLException {
		homeDao.insertHomeUser(all);
	}

	/**
	 * 修改家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public Integer updateHomeUser(T_paybank_home_all all) throws SQLException {
		return homeDao.updateHomeUser(all);
	}

	/**
	 * 删除家庭成员
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteHomeUser(T_paybank_home_all all) throws SQLException {
		return homeDao.deleteHomeUser(all);
	}

	/**
	 * 获取家庭创建信息
	 * 
	 * @param all
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home getHomeInfo(T_paybank_home all) throws SQLException {
		return homeDao.getHomeInfo(all);
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
		return homeDao.getAllHomeUser(all);
	}

	/**
	 * 注册用户
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_user regPayUser(T_paybank_user l) throws SQLException {
		return loginPayUserDao.regPayUser(l);
	}

	/**
	 * 用户登录
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_user payLoginUser(T_paybank_user l, Integer type)
			throws SQLException {
		return loginPayUserDao.payLoginUser(l, type);
	}

	/**
	 * 修改用户
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public Integer updateLoginUser(T_paybank_user l) throws SQLException {
		return loginPayUserDao.updateLoginUser(l);
	}

	/**
	 * 保存支出类型
	 * 
	 * @param t
	 * @return
	 */
	public T_paybank_zhichutype insertZhichu(T_paybank_zhichutype t)
			throws SQLException {
		return payBankDao.insertZhichu(t);
	}

	/**
	 * 修改支出类型
	 * 
	 * @param t
	 * @return
	 */
	public Integer updateZhichu(T_paybank_zhichutype t) throws SQLException {
		return payBankDao.updateZhichu(t);
	}

	/**
	 * 删除支出类型
	 * 
	 * @param t
	 * @return
	 */
	public Integer deleteZhichu(T_paybank_zhichutype t) throws SQLException {
		return payBankDao.deleteZhichu(t);
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
		return payBankDao.insertShouzhi(t);
	}

	/**
	 * 修改收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public Integer updateShouzhi(T_paybank_shouzhi t) throws SQLException {
		return payBankDao.updateShouzhi(t);
	}

	/**
	 * 删除收支
	 * 
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	public Integer deleteShouzhi(T_paybank_shouzhi t) throws SQLException {
		return payBankDao.deleteShouzhi(t);
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
		return payBankDao.getOneShouzhi(t);
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
		return payBankDao.getShouzhiList(t);
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
		return payBankDao.getZhichuList(t);
	}

	public HomeCardDao getHomeCardDao() {
		return homeCardDao;
	}

	public void setHomeCardDao(HomeCardDao homeCardDao) {
		this.homeCardDao = homeCardDao;
	}

	public HomeDao getHomeDao() {
		return homeDao;
	}

	public void setHomeDao(HomeDao homeDao) {
		this.homeDao = homeDao;
	}

	public LoginPayUserDao getLoginPayUserDao() {
		return loginPayUserDao;
	}

	public void setLoginPayUserDao(LoginPayUserDao loginPayUserDao) {
		this.loginPayUserDao = loginPayUserDao;
	}

	public PayBankDao getPayBankDao() {
		return payBankDao;
	}

	public void setPayBankDao(PayBankDao payBankDao) {
		this.payBankDao = payBankDao;
	}

}
