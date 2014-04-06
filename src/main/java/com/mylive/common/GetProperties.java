package com.mylive.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GetProperties {

	public static final Log log = LogFactory.getLog("N_Mall");

	/**
	 * 读取同级目录properties文件属性值
	 * 
	 * @param filePath
	 *            文件路径
	 * @param key
	 *            属性key
	 * @return
	 */
	public static String getValue(String fileName, String key) {
		InputStream is = null;
		Properties propertie = new Properties();
		try {
			is = new FileInputStream(new File(getXmlPath() + fileName));
			propertie.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertie.getProperty(key);
	}

	/**
	 * 获取WEB-INF目录下面server.xml文件的路径
	 * 
	 * @return
	 */
	public static String getXmlPath() {
		String pathStr = GetProperties.class.getClassLoader().getResource("")
				.getPath();
		// 对 Windows 下获取 物理路径 做 特殊处理
		if ("\\".equals(File.separator)) {
			pathStr = pathStr.substring(1).replaceAll("/", "\\\\");
		}
		return pathStr;
	}

	/**
	 * 给路径取properties值
	 * 
	 * @param filePath
	 * @param key
	 * @return
	 */
	public static String getValueByPath(String filePath, String key) {
		Properties propertie = new Properties();
		try {
			FileInputStream inputFile = new FileInputStream(filePath);
			propertie.load(inputFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return propertie.getProperty(key);
	}

	/**
	 * 得到开发模式下属性文件的值
	 * 
	 * @param key
	 * @return
	 */
	public static String getDefaultDevpModValue(String key) {
		return getValue(getValue("DevelopMode.properties", "play.app")
				+ ".properties", key);
	}

	/**
	 * 得到工程路径
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		return basePath;
	}

	public static void main(String[] args) {
		String s = GetProperties.class.getResource("").toString();
		String s2 = GetProperties.class.getResource("").getPath();
		try {
			FileInputStream inputFile = new FileInputStream(s2
					+ "DEVELOP.properties");
			Properties propertie = new Properties();
			propertie.load(inputFile);
			System.out.println(propertie.getProperty("NLOGOUT"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(s);
		System.out.println(s2);
	}
}
