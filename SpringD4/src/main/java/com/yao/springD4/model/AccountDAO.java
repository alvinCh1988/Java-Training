package com.yao.springD4.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class AccountDAO implements IAccount{
	

	String driver;
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.data-username}")
	String userId;
	@Value("${spring.datasource.data-password}")
	String passwd;
	Map<String, String> map;
	

	
	private static final String INSERT_ACCOUNT = "INSERT INTO test1.account(firstName, lastName, account, password, imgPath) VALUE (?, ?, ?, ?, ?)";
	private static final String GET_ONE_STMT = "SELECT * FROM test1.account where (account=?)";
	
	@Override
	public void insert(AccountVO accountVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {

			con = DriverManager.getConnection(url, userId, passwd);
			pstmt = con.prepareStatement(INSERT_ACCOUNT);

			pstmt.setString(1, accountVO.getFirstName());
			pstmt.setString(2, accountVO.getLastName());
			pstmt.setString(3, accountVO.getAccount());
			pstmt.setString(4, accountVO.getPassword());
			pstmt.setString(5, accountVO.getImgPath());

			pstmt.executeUpdate();

		} catch (SQLException se) { 
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally {
			closeResource(con, pstmt, null);
		}
		
	}

	@Override
	public AccountVO getOne(String account) {
		AccountVO accountVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			
			map = new HashMap<String , String>();

			con = DriverManager.getConnection(url, userId, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			

			pstmt.setString(1, account);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				accountVO = new AccountVO();
				accountVO.setFirstName(rs.getString("firstName"));
				accountVO.setLastName(rs.getString("lastName"));
				accountVO.setAccount(rs.getString("account"));
				accountVO.setPassword(rs.getString("password"));
				accountVO.setImgPath(rs.getString("imgPath"));
			}
			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally {
			closeResource(con, pstmt, rs);
		}
		return accountVO;
	}
	
	
//	關閉資源
	public void closeResource(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}

}
