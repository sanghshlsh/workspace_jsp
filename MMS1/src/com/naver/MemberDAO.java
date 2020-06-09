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
import kr.co.dto.MemberDTO;

public class MemberDAO {
		private DataSource dataFactory;
		public MemberDAO() {
			try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		public void insert(MemberDTO dto) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql  = "Insert into member(id,name,age) values (?,?,?)";
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getName());
				pstmt.setInt(3,dto.getAge());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		public List<MemberDTO> selectAll(){
			List<MemberDTO> list = new ArrayList<MemberDTO>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "select * from member";
			ResultSet rs = null;
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					int age = rs.getInt("age");
					MemberDTO dto = new MemberDTO(id, name, age);
					list.add(dto);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
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
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return list;
		}

		public void update(MemberDTO dto) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "update member set name = ? , age = ? where id = ?";
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getName());
				pstmt.setString(3, dto.getId());
				pstmt.setInt(2, dto.getAge());
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		
		public void delete(String id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			String sql = "delete from member where id = ?";
			try {
				conn = dataFactory.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
}
