package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.BoardDTO;

public class BoardDAO {
	private DataSource dataFactory;

	public BoardDAO() {
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
			e.printStackTrace();
		}
	}

	public List<BoardDTO> list() {
	
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board order by repRoot desc, repStep asc";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
			list.add(new BoardDTO(num, writer, title, null, writeday, readcnt, repRoot, repStep, repIndent));
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return list;
	}
	
	public void insert(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, writer, title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";

		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			int num = createNum(conn);
			pstmt.setInt(1, num);
			pstmt.setString(2, boardDTO.getWriter());
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		
	}
	
	public void insert2(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, writer, title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";
		int num = insertNum();
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, boardDTO.getWriter());
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
	}

	private int insertNum() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board order by num asc";
		ResultSet rs = null;
		int num = -1;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				num = rs.getInt("num");
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		
		return num+1;
	}

	private int createNum(Connection conn) {
	
		PreparedStatement pstmt = null;
		String sql = "select max(num) from board";
		ResultSet rs = null;
		Integer num = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
				num +=1;
			}	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, rs);
		}
		
		return num;
	}

	public List<BoardDTO> search(String title) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where title like ? order by repRoot desc, repStep asc";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title1 = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
			list.add(new BoardDTO(num, writer, title1, null, writeday, readcnt, repRoot, repStep, repIndent));
				
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return list;
	}
	
	public BoardDTO read(int num) {
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				
				dto = new BoardDTO(num, writer, title, content, writeday, readcnt+1, 0, 0, 0);
				increaseReadcnt(conn,num);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return dto;
	}

	private void increaseReadcnt(Connection conn, int num) {
		PreparedStatement pstmt = null;
		String sql = "update board set readcnt = readcnt+1 where num = ? ";		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
	}
	
	//transactinon해야하는 위치에 method 사용시
	public BoardDTO read2(int num) {
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num = ?";
		ResultSet rs = null;
		boolean isOk = false;
		
		
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			increaseReadcnt(conn,num);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				
				dto = new BoardDTO(num, writer, title, content, writeday, readcnt+1, 0, 0, 0);
				isOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeAll(conn, pstmt, rs);
		}
		return dto;
	}

	public BoardDTO updateui(int num) {
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
								
				dto = new BoardDTO(num, writer, title, content, null, 0, 0, 0, 0);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return dto;
	}

	public void update(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set writer = ?, title = ?, content = ?, writeday = sysdate where num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getWriter());
			pstmt.setString(2, boardDTO.getTitle());
			pstmt.setString(3, boardDTO.getContent());
			pstmt.setInt(4, boardDTO.getNum());
			pstmt.executeUpdate();
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		
	}

	public void delete(int num) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where num = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		
	}
	
	
	
	
}
