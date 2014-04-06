package com.mylive.authenticate.dao;

import java.sql.SQLException;

import com.mylive.authenticate.model.RoleModel;
import com.mylive.base.dao.BaseDAO;
import com.mylive.common.Page;

public interface AuthRoleDAO {

	/**
	 * 查看所有的角色项
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Page listRole(int pageNo, int pageSize) throws SQLException;

	/**
	 * 存储
	 */
	public void authRoleSave(RoleModel r);

	/**
	 * 修改
	 * 
	 * @param r
	 */
	public void authRoleUpdate(RoleModel r);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void authRoleDelete(Long id);

	/**
	 * 获取对象
	 * 
	 * @param id
	 * @return
	 */
	public RoleModel getAuthRoleObject(Long id);
}
