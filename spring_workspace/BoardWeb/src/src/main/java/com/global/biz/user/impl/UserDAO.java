package com.global.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.global.biz.common.JDBCUtil;
import com.global.biz.user.UserVO;
@Repository("userDAO")
public class UserDAO {
		
	//JDBC 관련 변수 
	
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	//SQL 명령어
	private final String USER_GET="select * from users where id=? and password=?";

	
	//CRUD 메소드 구현
	public UserVO getUser(UserVO vo) {
		//객체선언만 한거임
		UserVO user = null;
		
		try {
			System.out.println("====> JDBC로 getUser() 기능 처리....");
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();

			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getNString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getNString("name"));
				user.setRole(rs.getNString("role"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		
		return user;
	}
	
}
