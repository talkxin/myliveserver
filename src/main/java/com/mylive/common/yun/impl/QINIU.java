package com.mylive.common.yun.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.json.JSONException;

import net.sf.json.JSONObject;

import com.mylive.common.yun.YunFileDao;
import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

public class QINIU implements YunFileDao {
	private String ACCESS_KEY = "0vKT1xiYXnq3KrNvjJzVgurk3eVFyu5IrGoh1xDb";
	private String SECRET_KEY = "QQQXPjN0MPa7RMLGCdVDCkDnFBzUfjFfC7G2ksJG";
	private String bucketName = "mypiaoju";

	public QINIU() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 初始化全部参数
	 * 
	 * @param ACCESS_KEY
	 * @param SECRET_KEY
	 * @param bucketName
	 */
	public QINIU(String ACCESS_KEY, String SECRET_KEY, String bucketName) {
		this.ACCESS_KEY = ACCESS_KEY;
		this.SECRET_KEY = SECRET_KEY;
		this.bucketName = bucketName;
	}

	/**
	 * 更换空间
	 * 
	 * @param bucketName
	 */
	public QINIU(String bucketName) {
		this.bucketName = bucketName;
	}

	/**
	 * 上传文件
	 * 
	 * @param in
	 * @return
	 */
	public boolean uploadFile(FileInputStream in, String filename) {
		try {
			String token = this.getToken();
			PutExtra extra = new PutExtra();
			PutRet ret = IoApi.Put(token, filename, in, extra);
			return ret.ok();
		} catch (AuthException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	/**
	 * 获取token值
	 * 
	 * @return
	 * @throws JSONException
	 * @throws AuthException
	 */
	private String getToken() throws AuthException, JSONException {
		Config.ACCESS_KEY = ACCESS_KEY;
		Config.SECRET_KEY = SECRET_KEY;
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		// 请确保该bucket已经存在
		String bucketName = this.bucketName;
		PutPolicy putPolicy = new PutPolicy(bucketName);
		String token = putPolicy.token(mac);
		return token;
	}
}
