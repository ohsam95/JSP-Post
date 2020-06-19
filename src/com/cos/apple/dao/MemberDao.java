package com.cos.apple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.apple.db.DBConn;
import com.cos.apple.model.Member;

public class MemberDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public Member 로그인(String username, String password) {
		try {
				String sql = "select * from member where username = ? and password = ?";
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					Member member = new Member();
					member.setId(rs.getInt("id"));
					member.setUsername(rs.getString("username"));
					member.setPassword(rs.getString("password"));
					member.setEmail(rs.getString("email"));
					member.setCreateDate(rs.getTimestamp("createDate"));
				}
				
		} catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	
	public int 회원가입(String username, String password, String email) {
		try {
				String sql = "insert into member(id ,username, password,email,createDate) values(member_seq.nextval, ?, ?, ?, sysdate)";
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, email);
				return pstmt.executeUpdate();
		} catch (Exception e) {
				e.printStackTrace();
		}
		return -1;
	}
	
}
