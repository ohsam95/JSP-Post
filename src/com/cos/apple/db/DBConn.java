package com.cos.apple.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DBConn {
		public static Connection getConnection() {
			try {
				Context initContext = new InitialContext();
				Context envContext  = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
				Connection conn = ds.getConnection();
				System.out.println("DBConn : 데이터베이스 연결 성공");
				return conn;
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("DBConn : 데이터베이스 연결 실패");
         	System.out.println("DBConn : Message : " +e.getMessage());
			}
			return null;
		}
		public static void close(Connection conn, PreparedStatement pstmt) {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e) {
				System.out.println("DB종료시 오류가 발생 : "+e.getMessage());
			}
		}
		
		public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e) {
				System.out.println("DB종료시 오류가 발생 : "+e.getMessage());
			}
		}	
}