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
	
	
	
	public Member 회원찾기(int id) {
		try {
				String sql = "select * from member where id = ?";
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					Member member = new Member();
					member.setId(rs.getInt("id"));
					member.setUsername(rs.getString("username"));
					member.setPassword(rs.getString("password"));
					member.setEmail(rs.getString("email"));
					member.setCreateDate(rs.getTimestamp("createDate"));
					return member;
				}
				
		} catch (Exception e) {
				e.printStackTrace();
		}
		return null;
	}
	public int 회원수정(int id , String username, String password, String email) {
		try {
				String sql = "update member set username = ?,  password =?,  email = ? where id = ?";
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				pstmt.setString(3, email);
				pstmt.setInt(4, id);
				return pstmt.executeUpdate();
		} catch (Exception e) {
				e.printStackTrace();
		}
		return -1;
	}
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
					return member;
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
