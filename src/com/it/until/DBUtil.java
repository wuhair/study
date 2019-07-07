package com.it.until;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBUtil {
	private static DataSource ds = new ComboPooledDataSource();
	//获取一个连接池
	public static DataSource getDataSource() {
		return ds;
		
	} 
	//获取一个connection对象
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
		
	}
}
