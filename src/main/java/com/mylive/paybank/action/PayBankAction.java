package com.mylive.paybank.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.mylive.base.BaseAction;
import com.mylive.paybank.bo.PayBankBo;
import com.mylive.paybank.module.T_paybank_user;

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
			T_paybank_user user = new T_paybank_user();
			user.setLoginname(json.getString("loginname"));
			user.setPassword(json.getString("password"));
			if (payBankBo.payLoginUser(user, 2) == null) {
				payBankBo.regPayUser(user);
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
			T_paybank_user user = new T_paybank_user();
			user.setLoginname(json.getString("loginname"));
			user.setPassword(json.getString("password"));
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
