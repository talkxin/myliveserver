package com.mylive.base;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.mylive.authenticate.bo.AuthenticateBO;
import com.mylive.authenticate.model.RoleVsMenuModel;
import com.mylive.authenticate.model.UserModel;
import com.mylive.cache.CacheFactory;
import com.mylive.common.CookieUtil;

public class BaseAction extends ActionSupport {
	/**
	 * 查看所有的菜单项
	 */
	private AuthenticateBO authenticateBo;

	/**
	 * 角色与菜单对应实体
	 */
	private RoleVsMenuModel roleVsMenu;

	/**
	 * 用户实体
	 */
	public UserModel userModel;
	/**
	 * 菜单id
	 */
	private String menuId = "0";

	/**
	 * 时间格式化
	 */
	public SimpleDateFormat dateformat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 取出权限的方法
	 */
	public void returnRole() {
		String roleId = CookieUtil.getCookieValue(
				ServletActionContext.getRequest(),
				CookieUtil.USER_ROLEID_COOKIE);
		Map<Long, RoleVsMenuModel> map = CacheFactory.getRoleVsMenuByKey(
				"roleVsMenuCache", roleId);// 从缓存里读取角色对应权限信息
		if (null == map) {
			// 从库里读取角色权限信息
			this.getRoleVsMenuModel();
		} else {
			roleVsMenu = map.get(Long.valueOf(menuId));// 根据菜单id读取缓存里的权限信息
		}
		if (userModel == null) {
			String loginName = CookieUtil.getCookieValue(
					ServletActionContext.getRequest(),
					CookieUtil.LOGIN_NAME_COOKIE);
			userModel = authenticateBo.listUser(loginName);
		}
	}

	/**
	 * 如果缓存里没有该权限信息，从数据库里读取
	 * 
	 * @return
	 */
	public RoleVsMenuModel getRoleVsMenuModel() {
		String loginName = CookieUtil
				.getCookieValue(ServletActionContext.getRequest(),
						CookieUtil.LOGIN_NAME_COOKIE);
		userModel = authenticateBo.listUser(loginName);
		if (null != userModel) {
			try {
				roleVsMenu = this.authenticateBo.getRoleVs(
						userModel.getRoleId(), Long.valueOf(menuId));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return roleVsMenu;

	}

	public AuthenticateBO getAuthenticateBo() {
		return authenticateBo;
	}

	public void setAuthenticateBo(AuthenticateBO authenticateBo) {
		this.authenticateBo = authenticateBo;
	}

	public RoleVsMenuModel getRoleVsMenu() {
		return roleVsMenu;
	}

	public void setRoleVsMenu(RoleVsMenuModel roleVsMenu) {
		this.roleVsMenu = roleVsMenu;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
}
