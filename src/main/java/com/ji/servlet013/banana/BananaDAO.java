package com.ji.servlet013.banana;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;

import com.ji.servlet013.apple.Apple;
import com.ji.servlet013.dbmanager.JiDBManager;

public class BananaDAO {

	private int allBananaCount;

	private static final BananaDAO BANANADAO = new BananaDAO();

	private BananaDAO() {

	}

	public static BananaDAO getbananadao() {
		return BANANADAO;
	}

	public int getAllBananaCount() {
		return allBananaCount;
	}

	public void setAllBananaCount(int allAppleCount) {
		this.allBananaCount = allAppleCount;
	}

	public void getAllBananas(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JiDBManager.connect("jiPool");
			String sql = "select * from banana order by b_num";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Banana> balist = new ArrayList<Banana>();

			while (rs.next()) {
				balist.add(new Banana(rs.getInt("b_num"), rs.getString("b_trademark"), rs.getString("b_location"),
						rs.getInt("b_bundle"), rs.getString("b_color"), rs.getString("b_flavor"), rs.getInt("b_price"),
						rs.getString("b_introduce")));

			}
			request.setAttribute("bananas", balist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		JiDBManager.close(conn, pstmt, rs);
	}

	public boolean getBananaDetail(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JiDBManager.connect("jiPool");
			String sql = "SELECT * FROM banana WHERE b_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("b_num")));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Banana banana = new Banana(rs.getInt("b_num"), rs.getString("b_trademark"), rs.getString("b_location"),
						rs.getInt("b_bundle"), rs.getString("b_color"), rs.getString("b_flavor"), rs.getInt("b_price"),
						rs.getString("b_introduce"));
				request.setAttribute("banana", banana);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		} finally {
			JiDBManager.close(conn, pstmt, rs);
		}

	}
	
	public void search(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JiDBManager.connect("jiPool");
			String sql = "select * from banana WHERE b_trademark LIKE '%"+ request.getParameter("b_trademark")+"%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			ArrayList<Banana> balist = new ArrayList<Banana>();

			while (rs.next()) {
				balist.add(new Banana(rs.getInt("b_num"), rs.getString("b_trademark"), rs.getString("b_location"),
						rs.getInt("b_bundle"), rs.getString("b_color"), rs.getString("b_flavor"), rs.getInt("b_price"),
						rs.getString("b_introduce")));

			}
			request.setAttribute("bananas", balist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		JiDBManager.close(conn, pstmt, rs);
	}

	public void insert(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			request.setCharacterEncoding("UTF-8");
			conn = JiDBManager.connect("jiPool");
			String sql = "INSERT INTO banana VALUES(banana_seq.nextval,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, request.getParameter("b_trademark"));
			pstmt.setString(2, request.getParameter("b_location"));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("b_bundle")));
			pstmt.setString(4, request.getParameter("b_color"));
			pstmt.setString(5, request.getParameter("b_flavor"));
			pstmt.setInt(6, Integer.parseInt(request.getParameter("b_price")));
			pstmt.setString(7, request.getParameter("b_introduce"));

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "입력 성공!");
				allBananaCount++;
			} else {
				request.setAttribute("r", "입력 실패!");
			}

		} catch (Exception e) {
			request.setAttribute("r", "입력 실패!");
			e.printStackTrace();
		} finally {
			JiDBManager.close(conn, pstmt, null);

		}

	}

	public boolean update(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			request.setCharacterEncoding("UTF-8");
			conn = JiDBManager.connect("jiPool");
			String sql = "UPDATE banana SET b_trademark=?,b_location=?,b_bundle=?,b_color=?,b_flavor=?,b_price=?,b_introduce=? WHERE b_num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("b_trademark"));
			pstmt.setString(2, request.getParameter("b_location"));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("b_bundle")));
			pstmt.setString(4, request.getParameter("b_color"));
			pstmt.setString(5, request.getParameter("b_flavor"));
			pstmt.setInt(6, Integer.parseInt(request.getParameter("b_price")));
			pstmt.setString(7, request.getParameter("b_introduce"));
			pstmt.setInt(8, Integer.parseInt(request.getParameter("b_num")));

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "수정 성공!");
				return true;
			} else {
				request.setAttribute("r", "수정 실패!");
				return false;
			}

		} catch (Exception e) {
			request.setAttribute("r", "수정 실패!");
			return false;
		} finally {
			JiDBManager.close(conn, pstmt, null);
		}

	}

	public void delete(HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			request.setCharacterEncoding("UTF-8");
			conn = JiDBManager.connect("jiPool");
			String sql = "DELETE FROM banana WHERE b_num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("b_num")));

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "삭제 성공");
			} else {
				request.setAttribute("r", "삭제 실패");
			}

		} catch (Exception e) {
			request.setAttribute("r", "삭제 실패");
		} finally {
			JiDBManager.close(conn, pstmt, null);
		}

	}

	public void getBananaCount() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JiDBManager.connect("jiPool");
			String sql = "SELECT count(*) FROM banana";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				allBananaCount = rs.getInt("count(*)");
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JiDBManager.close(conn, pstmt, rs);
		}

	}

	public void getBananaPage(int page, HttpServletRequest request) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = JiDBManager.connect("jiPool");

			int perPage = 5;
			int pageCount = (int) Math.ceil(allBananaCount / (double) perPage);
			request.setAttribute("pageCount", pageCount);

			int start = (perPage * (page - 1) + 1);
			int end = (page == pageCount) ? allBananaCount : (start + perPage - 1);

			String sql = "select * from (SELECT rownum as rn,b_num,b_trademark,b_location"
					+ ",b_bundle,b_color,b_flavor,b_price,b_introduce FROM banana order by b_num) WHERE rn>=? and rn<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			ArrayList<Banana> bananas = new ArrayList<Banana>();
			
			while (rs.next()) {
				Banana banana = new Banana(rs.getInt("b_num"), rs.getString("b_trademark"), rs.getString("b_location"),
						rs.getInt("b_bundle"), rs.getString("b_color"), rs.getString("b_flavor"), rs.getInt("b_price"),
						rs.getString("b_introduce"));
				bananas.add(banana);
			}
			request.setAttribute("bananas", bananas);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JiDBManager.close(conn, pstmt, rs);
		}

	}

}
