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
import kr.co.domain.PageTO;

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
			rs = pstmt.executeQuery();
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
				num += 1;
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
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
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
				int repStep = rs.getInt("repStep");
				int repRoot = rs.getInt("repRoot");
				int repIndent = rs.getInt("repIndent");
							
				dto = new BoardDTO(num, writer, title, content, null, 0, repRoot, repStep, repIndent);
								
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

	public void reply(int orgNum, BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, writer, title, content, repRoot, repStep, repIndent)	values (?,?,?,?,?,?,?)";
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			
			int num = createNum(conn);
			BoardDTO orgDTO = updateui(orgNum);
			stepPlus1(conn, orgDTO);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, orgDTO.getRepRoot());
			pstmt.setInt(6, orgDTO.getRepStep()+1);
			pstmt.setInt(7, orgDTO.getRepIndent()+1);
			pstmt.executeUpdate();
			
			isOk = true;
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
				e.printStackTrace();
			}
			
			closeAll(conn, pstmt, null);
		}
		
	}

	private void stepPlus1(Connection conn, BoardDTO orgDTO) {
		PreparedStatement pstmt = null;
		String sql = "update board set repStep = repStep+1 where  repRoot = ? and repStep > ?";
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, orgDTO.getRepRoot());
			pstmt.setInt(2, orgDTO.getRepStep());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		
	}

	public PageTO page(int curPage) {
		PageTO to = new PageTO(curPage);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from (select rownum rnum, num, title, writer, writeday, readcnt, repIndent from (select * from board order by repRoot desc, repStep asc)) where rnum >=? and rnum <=?" 
;
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			to.setAmount(getAmount(conn));
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, to.getStartNum());
			pstmt.setInt(2, to.getEndNum());
			rs=pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");				
				String writer = rs.getString("writer");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");
				list.add(new BoardDTO(num, writer, title, null, writeday, readcnt, -1, -1, repIndent));
			}
			to.setList(list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			
			
			closeAll(conn, pstmt, rs);
		}
		
		
		return to;
	}
	
	private int getAmount(Connection conn) {
		int amount = 0;
		
		PreparedStatement pstmt = null;
		String sql = "select count(num) from board";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				amount = rs.getInt(1);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, rs);
		}
		
		return amount;
	}

	public PageTO searchPage(String sTitle, int curPage) {
		PageTO to = new PageTO(curPage);
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from (select rownum rnum, num, title, writer, writeday, readcnt, repIndent from (select * from board where title like ? order by repRoot desc, repStep asc)) where rnum>=? and rnum<=?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			to.setAmount(getSerchAmount(conn,sTitle));
			pstmt.setString(1, "%"+sTitle+"%");
			pstmt.setInt(2, to.getStartNum());
			pstmt.setInt(3, to.getEndNum());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int num = rs.getInt("num");
				String title = rs.getString("title");				
				String writer = rs.getString("writer");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				int repIndent = rs.getInt("repIndent");
				list.add(new BoardDTO(num, writer, title, null, writeday, readcnt, -1, -1, repIndent));
			}
			to.setList(list);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return to;
	}

	private int getSerchAmount(Connection conn, String sTitle) {
		int amount = 0;
		PreparedStatement pstmt = null;
		String sql="select count(num) from board where title like ?";
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+sTitle+"%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				amount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, rs);
		}
		
		
		return amount;
	}

//	public void reply(int num, BoardDTO boardDTO) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		String sql = "update board set repStep = repStep+1 where  repRoot = ? and repStep > ?";
//
//
//		boolean isOk = false;
//		
//		try {
//			conn = dataFactory.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			conn.setAutoCommit(false);
//			BoardDTO orgDTO = originalDTO(conn,num);
//			pstmt.setInt(1, orgDTO.getRepRoot());
//			pstmt.setInt(2, orgDTO.getRepStep());
//			pstmt.executeUpdate();
//			insertReply(conn,boardDTO,orgDTO);
//			isOk = true;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			
//			try {
//				if (isOk) {
//					conn.commit();
//				} else {
//					conn.rollback();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			closeAll(conn, pstmt, null);
//		}
//		
//		
//	}
//
//	private void insertReply(Connection conn, BoardDTO boardDTO, BoardDTO orgDTO) {
//	
//		PreparedStatement pstmt = null;
//		String sql = "insert into board (num, writer, title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";
//	
//		try {
//			pstmt = conn.prepareStatement(sql);
//			int num = createNum(conn);
//			pstmt.setInt(1, num);
//			pstmt.setString(2, boardDTO.getWriter());
//			pstmt.setString(3, boardDTO.getTitle());
//			pstmt.setString(4, boardDTO.getContent());
//			pstmt.setInt(5, orgDTO.getRepRoot());
//			pstmt.setInt(6, orgDTO.getRepStep()+1);
//			pstmt.setInt(7, orgDTO.getRepIndent()+1);
//			pstmt.executeUpdate();
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			closeAll(null, pstmt, null);
//		}
//
//	}
//
//	private BoardDTO originalDTO(Connection conn, int num) {
//		BoardDTO dto = null;
//		PreparedStatement pstmt = null;
//		String sql = "select * from board where num = ?";
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, num);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				int repRoot = rs.getInt("repRoot");
//				int repStep = rs.getInt("repStep");
//				int repIndent = rs.getInt("repIndent");
//				dto = new BoardDTO(num, null, null, null, null, 0 , repRoot, repStep, repIndent);
//			
//				
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			closeAll(null, pstmt, rs);
//		}
//		return dto;
//		
//	}


		
	
}

