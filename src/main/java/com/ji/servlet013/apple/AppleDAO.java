package com.ji.servlet013.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.ji.servlet013.dbmanager.JiDBManager;

public class AppleDAO {

	// 총 사과 데이터 수
	private int allAppleCount;

	private static final AppleDAO APPLEDAO = new AppleDAO();

	private AppleDAO() {

	}

	// 이 메소드만으로만 AppleDAO 접근 가능.
	public static AppleDAO getAppledao() {
		return APPLEDAO;
	}

	public int getAllAppleCount() {
		return allAppleCount;
	}

	public void setAllAppleCount(int allAppleCount) {
		this.allAppleCount = allAppleCount;
	}

	// 모든 사과 데이터 전부 가져오기 - R > Select

	public void getAllApples(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JiDBManager.connect("jiPool");
			String sql = "select * from nov17_apple order by a_price";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Apple> apal = new ArrayList<Apple>();
			Apple ap = null;

			while (rs.next()) {

				ap = new Apple();
				ap.setA_num(rs.getInt("a_num"));
				ap.setA_location(rs.getString("a_location"));
				ap.setA_color(rs.getString("a_color"));
				ap.setA_flavor(rs.getString("a_flavor"));
				ap.setA_price(rs.getInt("a_price"));
				ap.setA_introduce(rs.getString("a_introduce"));
				apal.add(ap);

			}
			request.setAttribute("apples", apal);

		} catch (Exception e) {
			e.printStackTrace();
		}
		JiDBManager.close(conn, pstmt, rs);
	}

	public void insertApple(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO nov17_apple VALUES(nov17_apple_seq.nextval,?,?,?,?,?)";

		try {

			request.setCharacterEncoding("UTF-8");
			conn = JiDBManager.connect("jiPool");
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("a_location"));
			pstmt.setString(2, request.getParameter("a_color"));
			pstmt.setString(3, request.getParameter("a_flavor"));
			pstmt.setInt(4, Integer.parseInt(request.getParameter("a_price")));
			pstmt.setString(5, request.getParameter("a_introduce").replace("\r\n", "<br>"));

			if (pstmt.executeUpdate() == 1) {

				request.setAttribute("r", "[등록성공]");
				allAppleCount++;

			}

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("r", "[등록실패]");

		}

		JiDBManager.close(conn, pstmt, null);

	}

	public void countApples() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			String sql = "select count(*) from nov17_apple";
			conn = JiDBManager.connect("jiPool");
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			rs.next();
			allAppleCount = rs.getInt("count(*)");
			System.out.println("전체 Column 갯수 : " + allAppleCount);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JiDBManager.close(conn, pstmt, rs);

	}

	public void getApples(int pageNo, HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JiDBManager.connect("jiPool");
			int applePerPage = 5;

			// Meth.ceil : 숫자 올림(반올림 아님.);
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage);
			request.setAttribute("pageCount", pageCount); // apple/apple.jsp에서 사용

			int start = (applePerPage * (pageNo - 1) + 1);
			int end = (pageNo == pageCount) ? allAppleCount : (start + applePerPage - 1);

			String sql = "select * from (select rownum as rn,a_num,a_location, a_color,a_flavor,a_price,a_introduce "
					+ "from (select * from nov17_apple order by a_price)) WHERE rn >= ? and rn <=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;

			while (rs.next()) {

				apples.add(new Apple(rs.getInt("a_num"), rs.getString("a_location"), rs.getString("a_color"),
						rs.getString("a_flavor"), rs.getInt("a_price"), rs.getString("a_introduce")));

			}

			request.setAttribute("apples", apples);

		} catch (Exception e) {

			e.printStackTrace();

		}

		JiDBManager.close(conn, pstmt, rs);

	}

	public boolean getAppleDetail(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JiDBManager.connect("jiPool");
			String location = request.getParameter("a_location");

			String sql = "select * from nov17_apple where a_location=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				
				Apple apple = new Apple(rs.getInt("a_num"), rs.getString("a_location"), rs.getString("a_color"),
						rs.getString("a_flavor"), rs.getInt("a_price"), rs.getString("a_introduce"));
				request.setAttribute("apple", apple);
				
				return true;
				
			}
			
			return false;

		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {
			
			JiDBManager.close(conn, pstmt, rs);
			
		}

	}
	
	public boolean update(HttpServletRequest request) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = JiDBManager.connect("jiPool");
			String sql = "UPDATE nov17_apple set a_color = ?, a_flavor = ?,a_price=?,a_introduce=? WHERE a_location = ?";
			
			request.setCharacterEncoding("UTF-8");
			String location = request.getParameter("a_location");
			String color = request.getParameter("a_color");
			String flavor = request.getParameter("a_flavor");
			int price = Integer.parseInt(request.getParameter("a_price"));
			String introduce = request.getParameter("a_introduce").replace("\r\n", "<br>");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,color);
			pstmt.setString(2, flavor);
			pstmt.setInt(3, price);
			pstmt.setString(4, introduce);
			pstmt.setString(5, location);
			
			if(pstmt.executeUpdate() ==1) {
				request.setAttribute("r", "수정 성공");
				return true;
			}else {
				request.setAttribute("r", "수정 실패");
				return false;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "수정 실패");
			return false;
		} finally {
			JiDBManager.close(conn, pstmt, null);
		}
		
	}
	
	public void delete(HttpServletRequest request) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = JiDBManager.connect("jiPool");	
			String sql = "DELETE FROM nov17_apple WHERE a_location=?";	
			String location = request.getParameter("a_location");			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, location);
			
			if(pstmt.executeUpdate()==1) {
				request.setAttribute("r", "삭제 성공");
				allAppleCount--;
				
			} else {
				
				request.setAttribute("r", "삭제 실패");	
				
			}
					
		} catch (Exception e) {
			
			e.printStackTrace();
			request.setAttribute("r", "삭제 실패");	
			
		}
		
		JiDBManager.close(conn, pstmt, null);
		
	}

}
