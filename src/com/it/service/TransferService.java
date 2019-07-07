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
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			td.transferOut(out, money);
			td.transferIn(in, money);
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
