package com.mylive.paybank.action;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.mylive.base.BaseAction;
import com.mylive.paybank.bo.PayBankBo;
import com.mylive.paybank.module.T_paybank_card;
import com.mylive.paybank.module.T_paybank_home;
import com.mylive.paybank.module.T_paybank_home_all;
import com.mylive.paybank.module.T_paybank_shouzhi;
import com.mylive.paybank.module.T_paybank_user;
import com.mylive.paybank.module.T_paybank_zhichutype;

public class PayBankAction extends BaseAction {
	/**
	 * 操作的bo
	 */
	private PayBankBo payBankBo;
	private HttpServletRequest request;// =ServletActionContext.getRequest();

	private String getmessage;
	private JSONObject returnmessage;

	/**
	 * 注册用户
	 * 
	 * @return
	 */
	public String regPayUser() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_user user = (T_paybank_user) JSONObject.toBean(json,
					T_paybank_user.class);
			if (payBankBo.payLoginUser(user, 2) == null) {
				user = payBankBo.regPayUser(user);
				returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
						+ JSONObject.fromObject(user) + "'}");
			} else {
				returnmessage = JSONObject
						.fromObject("{Result:'99',Msg:'该用户已注册'}");
			}
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 用户登录
	 * 
	 * @return
	 */
	public String payLoginUser() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_user user = (T_paybank_user) JSONObject.toBean(json,
					T_paybank_user.class);
			user = payBankBo.payLoginUser(user, 1);
			if (user != null) {
				returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
						+ JSONObject.fromObject(user) + "'}");
			} else {
				returnmessage = JSONObject
						.fromObject("{Result:'99',Msg:'登录失败'}");
			}
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	public String updateLoginUser() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_user user = new T_paybank_user();
			user.setLoginname(json.getString("loginname"));
			user = payBankBo.payLoginUser(user, 1);
			if (user != null) {
				user.setPassword(json.getString("password"));
				payBankBo.updateLoginUser(user);
				returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
						+ JSONObject.fromObject(user) + "'}");
			} else {
				returnmessage = JSONObject
						.fromObject("{Result:'99',Msg:'用户不存在'}");
			}
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 增加卡片
	 * 
	 * @return
	 */
	public String insertPayCard() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_card card = (T_paybank_card) JSONObject.toBean(json,
					T_paybank_card.class);
			card = payBankBo.insertPayCard(card);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(card) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 修改卡片信息
	 * 
	 * @return
	 */
	public String updatePayCard() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_card card = (T_paybank_card) JSONObject.toBean(json,
					T_paybank_card.class);
			payBankBo.updatePayCard(card);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(card) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 删除卡片信息
	 * 
	 * @return
	 */
	public String deletePayCard() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_card card = (T_paybank_card) JSONObject.toBean(json,
					T_paybank_card.class);
			payBankBo.deletePayCard(card);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(card) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 获取一个卡片信息
	 * 
	 * @return
	 */
	public String getOneCard() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_card card = (T_paybank_card) JSONObject.toBean(json,
					T_paybank_card.class);
			card = payBankBo.getOneCard(card);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(card) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 获取所有卡片信息
	 * 
	 * @return
	 */
	public String getCardList() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_card card = (T_paybank_card) JSONObject.toBean(json,
					T_paybank_card.class);
			List<T_paybank_card> cardList = payBankBo.getCardList(card);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(cardList) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 添加家庭
	 * 
	 * @return
	 */
	public String insertHome() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_home home = (T_paybank_home) JSONObject.toBean(json,
					T_paybank_home.class);
			home = payBankBo.insertHome(home);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(home) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 删除家庭
	 * 
	 * @return
	 */
	public String deleteHome() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_home home = (T_paybank_home) JSONObject.toBean(json,
					T_paybank_home.class);
			payBankBo.deleteHome(home);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'删除成功'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 添加家庭成员
	 */
	public String insertHomeUser() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_home_all all = (T_paybank_home_all) JSONObject.toBean(
					json, T_paybank_home_all.class);
			payBankBo.insertHomeUser(all);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'添加成功'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 修改家庭成员
	 * 
	 * @return
	 */
	public String updateHomeUser() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_home_all all = (T_paybank_home_all) JSONObject.toBean(
					json, T_paybank_home_all.class);
			payBankBo.updateHomeUser(all);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'修改成功'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 删除家庭成员
	 * 
	 * @return
	 */
	public String deleteHomeUser() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_home_all all = (T_paybank_home_all) JSONObject.toBean(
					json, T_paybank_home_all.class);
			payBankBo.deleteHomeUser(all);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'删除成功'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 获取家庭创建信息
	 * 
	 * @return
	 */
	public String getHomeInfo() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_home home = (T_paybank_home) JSONObject.toBean(json,
					T_paybank_home.class);
			home = payBankBo.getHomeInfo(home);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(home) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 获取家庭成员
	 * 
	 * @return
	 */
	public String getAllHomeUser() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_home_all all = (T_paybank_home_all) JSONObject.toBean(
					json, T_paybank_home_all.class);
			List<T_paybank_home_all> homeList = payBankBo.getAllHomeUser(all);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(homeList) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 保存支出类型
	 * 
	 * @return
	 */
	public String insertZhichu() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_zhichutype t = (T_paybank_zhichutype) JSONObject.toBean(
					json, T_paybank_zhichutype.class);
			t = payBankBo.insertZhichu(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(t) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 修改支出类型
	 * 
	 * @return
	 */
	public String updateZhichu() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_zhichutype t = (T_paybank_zhichutype) JSONObject.toBean(
					json, T_paybank_zhichutype.class);
			payBankBo.updateZhichu(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'修改成功'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 删除支出类型
	 * 
	 * @return
	 */
	public String deleteZhichu() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_zhichutype t = (T_paybank_zhichutype) JSONObject.toBean(
					json, T_paybank_zhichutype.class);
			payBankBo.deleteZhichu(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'删除成功'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 保存收支
	 * 
	 * @return
	 */
	public String insertShouzhi() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_shouzhi t = (T_paybank_shouzhi) JSONObject.toBean(json,
					T_paybank_shouzhi.class);
			t = payBankBo.insertShouzhi(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(t) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 修改收支
	 * 
	 * @return
	 */
	public String updateShouzhi() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_shouzhi t = (T_paybank_shouzhi) JSONObject.toBean(json,
					T_paybank_shouzhi.class);
			payBankBo.updateShouzhi(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'修改成功'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 删除收支
	 * 
	 * @return
	 */
	public String deleteShouzhi() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_shouzhi t = (T_paybank_shouzhi) JSONObject.toBean(json,
					T_paybank_shouzhi.class);
			payBankBo.deleteShouzhi(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'删除成功'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 获取一个收支项
	 * 
	 * @return
	 */
	public String getOneShouzhi() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_shouzhi t = (T_paybank_shouzhi) JSONObject.toBean(json,
					T_paybank_shouzhi.class);
			t = payBankBo.getOneShouzhi(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(t) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 获取收支列表
	 * 
	 * @return
	 */
	public String getShouzhiList() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_shouzhi t = (T_paybank_shouzhi) JSONObject.toBean(json,
					T_paybank_shouzhi.class);
			List<T_paybank_shouzhi> shouzhiList = payBankBo.getShouzhiList(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(shouzhiList) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	/**
	 * 获取所有支出
	 * 
	 * @return
	 */
	public String getZhichuList() {
		try {
			JSONObject json = JSONObject.fromObject(getmessage).getJSONObject(
					"obj");
			T_paybank_zhichutype t = (T_paybank_zhichutype) JSONObject.toBean(
					json, T_paybank_zhichutype.class);
			List<T_paybank_zhichutype> shouzhiList = payBankBo.getZhichuList(t);
			returnmessage = JSONObject.fromObject("{Result:'1',Msg:'"
					+ JSONObject.fromObject(shouzhiList) + "'}");
		} catch (Exception e) {
			returnmessage = JSONObject.fromObject("{Result:'100',Msg:'"
					+ e.getMessage() + "'}");
		}
		return SUCCESS;
	}

	public String getGetmessage() {
		return getmessage;
	}

	public void setGetmessage(String getmessage) {
		this.getmessage = getmessage;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public JSONObject getReturnmessage() {
		return returnmessage;
	}

	public void setReturnmessage(JSONObject returnmessage) {
		this.returnmessage = returnmessage;
	}

	public PayBankBo getPayBankBo() {
		return payBankBo;
	}

	public void setPayBankBo(PayBankBo payBankBo) {
		this.payBankBo = payBankBo;
	}

}
