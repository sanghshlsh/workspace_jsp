package com.naver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp.PStmtKey;

public class DAO {
	private DataSource dataFactory;
	public DAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
			pstmt.close();	
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<DTO> list() {

		List<DTO> list = new ArrayList<DTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board order by repRoot desc, repStep asc";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");
				list.add(new DTO(num, title, content, writer, writeday, readcnt, 0, 0, repIndent));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		
		
		return list;
	}

	public List<DTO> search(String title) {
		List<DTO> list = new ArrayList<DTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where title like ? order by repRoot desc, repStep asc";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String ntitle = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");
				list.add(new DTO(num, ntitle, content, writer, writeday, readcnt, 0, 0, repIndent));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}

	public DTO read(int num) {
		DTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num = ?";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String contetn = rs.getString("content");
				String writer = rs.getString("writer");
				int readcnt = rs.getInt("readcnt");
				dto = new DTO(num, title, contetn, writer, null, readcnt+1, 0, 0, 0);
			}
			cntup(num,conn);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return dto;
	}

	private void cntup(int num,Connection conn) {
		
		PreparedStatement pstmt = null;
		String sql = "update board set readcnt = readcnt+1 where num = ?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			closeAll(null, pstmt, null);
		}
	}
}
