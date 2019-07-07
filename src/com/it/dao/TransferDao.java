package com.it.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.it.until.DBUtil;

public class TransferDao {
	public void transferOut(String out,int money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Connection con = null;
		con = DBUtil.getConnection();
		String sql = "update account set account = account -"+money+" where name = '"+out+"'";
		qr.update(con, sql);
	}
	public void transferIn(String in ,int money) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Connection con = null;
		con = DBUtil.getConnection();
		String sql = "update account set account = account +"+money+" where name = '"+in+"'";
		qr.update(con, sql);
	}
}
