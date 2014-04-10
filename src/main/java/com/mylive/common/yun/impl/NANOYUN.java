package com.mylive.common.yun.impl;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

import net.sf.json.JSONObject;

import com.mylive.common.yun.YunFileDao;
import com.mylive.common.yun.YunFileUtil;

public class NANOYUN implements YunFileDao {
	private FTPClient ftpClient = null;
	private FileInputStream fis = null;
	private HttpURLConnection conn = null;
	private String serverurl = "http://api.nanoyun.com";
	private String ftpurl = "ftp.nanoyun.com";
	private String username = "talkliu/mylive";
	private String passwd = "tlakliu";
	private String apikey = "3994139709";
	private String secretkey = "1524f795c29f458a9a4e7e34c0f2b94e";

	/**
	 * 上传文件
	 * 
	 * @param in
	 * @return
	 */
	public boolean uploadFile(FileInputStream in, String filename) {
		ftpClient = new FTPClient();
		fis = in;
		try {
			ftpClient.connect(ftpurl);
			ftpClient.login(username, passwd);
			// 设置上传目录
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.setBufferSize(1024);
			ftpClient.changeWorkingDirectory(this.url);
			// 以二进制方式上传
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			return ftpClient.storeFile(filename, fis);
		} catch (IOException e) {
			return false;
		} finally {
			IOUtils.closeQuietly(fis);
			try {
				ftpClient.disconnect();
				ftpClient = null;
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
	}

	/**
	 * 上传文件
	 * 
	 * @param in
	 * @param json
	 * @return
	 */
	@Deprecated
	public JSONObject uploadFile(FileInputStream in, JSONObject json) {
		return null;
	}

	/**
	 * 上传大文件
	 * 
	 * @param obj
	 * @return
	 */
	@Deprecated
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
		ftpClient = new FTPClient();
		try {
			ftpClient.connect(ftpurl);
			ftpClient.login(username, passwd);
			// 设置上传目录
			ftpClient.setControlEncoding("UTF-8");
			ftpClient.setBufferSize(1024);
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			return ftpClient.retrieveFileStream(path);
		} catch (IOException e) {
			return null;
		} finally {
			IOUtils.closeQuietly(fis);
			try {
				ftpClient.disconnect();
				ftpClient = null;
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param json
	 * @return
	 */
	@Deprecated
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
		ftpClient = new FTPClient();
		try {
			ftpClient.connect(ftpurl);
			ftpClient.login(username, passwd);
			return ftpClient.deleteFile(path);
		} catch (IOException e) {
			return false;
		} finally {
			IOUtils.closeQuietly(fis);
			try {
				ftpClient.disconnect();
				ftpClient = null;
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
		}
	}

	/**
	 * 获取数据列表
	 * 
	 * @param json
	 * @return
	 */
	@Deprecated
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
		try {
			String token = getToken();
			String server = serverurl + "/space/getSpaceUsage";
			String poststr = "access_token=" + token + "&spacename=mylive";
			URL url = new URL(server);
			conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.getOutputStream().write(poststr.getBytes());
			conn.getOutputStream().flush();
			conn.getOutputStream().close();
			return JSONObject.fromObject(new String(YunFileUtil
					.readInputStream(conn.getInputStream()), "utf-8"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取token值
	 * 
	 * @return
	 */
	private String getToken() {
		try {
			URL url = new URL(serverurl + "/oauth/accesstoken?" + "appkey="
					+ apikey + "&appsecret=" + secretkey
					+ "&response_type=code");
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			String str = null;
			str = new String(
					YunFileUtil.readInputStream(conn.getInputStream()), "utf-8");
			JSONObject jsonObject = JSONObject.fromObject(str);
			return jsonObject.getString("access_token");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
