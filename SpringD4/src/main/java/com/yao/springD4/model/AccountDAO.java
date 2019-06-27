package com.yao.springD4.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;


public class AccountDAO implements IAccount{
	
//	"com.mysql.cj.jdbc.Driver"
	String driver;
	String url;
	String userId;
	String passwd;
	
	@Autowired
	public void settingDB(String url, String userId, String passwd) {

		this.url = url;
		this.userId = userId;
		this.passwd = passwd;

	}
	
	private static final String INSERT_ACCOUNT = "INSERT INTO test1.account(firstName, lastName, account, password, imfPath) VALUE (?, ?, ?, ?, ?) ";
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
	public AccountVO findAccount(String account) {
		AccountVO accountVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(url, userId, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setString(1, account);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				accountVO = new AccountVO();
				accountVO.setFirstName(rs.getString("firstName"));
				accountVO.setLastName(rs.getString("lastName"));
				accountVO.setAccount(rs.getString("account"));
				accountVO.setImgPath(rs.getString("imgPath"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

		} finally {
			closeResource(con, pstmt, rs);
		}
		return null;
	}
	
	
	
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
