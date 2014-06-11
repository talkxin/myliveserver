package com.mylive.paybank.bo;

import java.sql.SQLException;
import java.util.List;

import com.mylive.paybank.module.T_paybank_card;
import com.mylive.paybank.module.T_paybank_home;
import com.mylive.paybank.module.T_paybank_home_all;
import com.mylive.paybank.module.T_paybank_shouzhi;
import com.mylive.paybank.module.T_paybank_user;
import com.mylive.paybank.module.T_paybank_zhichutype;

public interface PayBankBo {
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

	/**
	 * 添加家庭
	 * 
	 * @param home
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_home insertHome(T_paybank_home home) throws SQLException;

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
	public void insertHomeUser(T_paybank_home_all all) throws SQLException;

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

	/**
	 * 注册用户
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_user regPayUser(T_paybank_user l) throws SQLException;

	/**
	 * 用户登录
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public T_paybank_user payLoginUser(T_paybank_user l, Integer type)
			throws SQLException;

	/**
	 * 修改用户
	 * 
	 * @param l
	 * @return
	 * @throws SQLException
	 */
	public Integer updateLoginUser(T_paybank_user l) throws SQLException;

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
