package com.it.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.it.dao.TransferDao;
import com.it.until.DBUtil;

public class TransferService {
	TransferDao td = new TransferDao();
	public void transfer(String out,String in,int money) {
		Connection conn = null;
		try {
			//开启事务的conn必须是同一个才能生效
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			td.transferOut(conn,out, money);
			int i = 1/0;
			td.transferIn(conn,in, money);
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		
	}
}
