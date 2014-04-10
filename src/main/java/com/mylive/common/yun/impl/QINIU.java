package com.mylive.common.yun.impl;

import java.io.FileInputStream;
import java.io.InputStream;

import net.sf.json.JSONObject;

import com.mylive.common.yun.YunFileDao;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;

public class QINIU implements YunFileDao {
	public static void main(String[] args) throws Exception {
		Config.ACCESS_KEY = "0vKT1xiYXnq3KrNvjJzVgurk3eVFyu5IrGoh1xDb";
		Config.SECRET_KEY = "QQQXPjN0MPa7RMLGCdVDCkDnFBzUfjFfC7G2ksJG";
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		// 请确保该bucket已经存在
		String bucketName = "mylive";
		PutPolicy putPolicy = new PutPolicy(bucketName);
		String token = putPolicy.token(mac);
		System.out.println(token);
	}

	/**
	 * 上传文件
	 * 
	 * @param in
	 * @return
	 */
	public boolean uploadFile(FileInputStream in, String filename) {
		return false;
	}

	/**
	 * 上传文件
	 * 
	 * @param in
	 * @param json
	 * @return
	 */
	public JSONObject uploadFile(FileInputStream in, JSONObject json) {
		return null;
	}

	/**
	 * 上传大文件
	 * 
	 * @param obj
	 * @return
	 */
	public JSONObject uploadSuperfile(Object obj) {
		return null;
	}

	/**
	 * 下载文件
	 * 
	 * @param path
	 * @return
	 */
	public InputStream downloadFile(String path) {
		return null;
	}

	/**
	 * 下载文件
	 * 
	 * @param json
	 * @return
	 */
	public String downloadFile(JSONObject json) {
		return null;
	}

	/**
	 * 删除文件
	 * 
	 * @param path
	 * @return
	 */
	public boolean deleteFile(String path) {
		return false;
	}

	/**
	 * 获取数据列表
	 * 
	 * @param json
	 * @return
	 */
	public Object getFileList(JSONObject json) {
		return null;
	}

	/**
	 * 获取空间使用情况
	 * 
	 * @param json
	 * @return
	 */
	public Object getSpaceUsage(JSONObject json) {
		return null;
	}
}
