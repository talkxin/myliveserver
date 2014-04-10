package com.mylive.common.yun;

import java.io.FileInputStream;
import java.io.InputStream;

import com.mylive.common.GetProperties;

import net.sf.json.JSONObject;

public interface YunFileDao {
	public final String url = GetProperties
			.getDefaultDevpModValue("piaoju.imageurl");

	/**
	 * 上传文件
	 * 
	 * @param in
	 * @return
	 */
	public boolean uploadFile(FileInputStream in,String filename);

	/**
	 * 上传文件
	 * 
	 * @param in
	 * @param json
	 * @return
	 */
	public JSONObject uploadFile(FileInputStream in, JSONObject json);

	/**
	 * 上传大文件
	 * 
	 * @param obj
	 * @return
	 */
	public JSONObject uploadSuperfile(Object obj);

	/**
	 * 下载文件
	 * 
	 * @param path
	 * @return
	 */
	public InputStream downloadFile(String path);

	/**
	 * 下载文件
	 * 
	 * @param json
	 * @return
	 */
	public String downloadFile(JSONObject json);

	/**
	 * 删除文件
	 * 
	 * @param path
	 * @return
	 */
	public boolean deleteFile(String path);

	/**
	 * 获取数据列表
	 * 
	 * @param json
	 * @return
	 */
	public Object getFileList(JSONObject json);

	/**
	 * 获取空间使用情况
	 * 
	 * @param json
	 * @return
	 */
	public Object getSpaceUsage(JSONObject json);
}
