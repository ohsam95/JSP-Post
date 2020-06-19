package com.cos.apple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.apple.db.DBConn;
import com.cos.apple.model.Member;
import com.cos.apple.model.Post;

public class PostDao {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	public int 글쓰기(int memberId ,String title, String content) {
		try {
				String sql = "insert into post values(post_seq.nextval,?,?,?,sysdate)";
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, memberId);
				pstmt.setString(2, title);
				pstmt.setString(3, content);
				
				return pstmt.executeUpdate();
				
		} catch (Exception e) {
				e.printStackTrace();
		}
		return -1;		
	}
}
