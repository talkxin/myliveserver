package com.mylive.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 处理同步的sqlite
 * 
 * @author talkliu
 * 
 */
public class SqliteUpload {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager
				.getConnection("jdbc:sqlite:C:\\Users\\talkliu\\Desktop\\hb.sqlite");
		Statement stmt = conn.createStatement();
	}

	private String dataurl;

	public SqliteUpload(String dataurl) {
		// TODO Auto-generated constructor stub
		this.dataurl = dataurl;
	}

}
