package com.ji.servlet013.dbmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

// 기존 JDBC 프로그램 구현 > DBMS(OracleDB)와 연동 작업
//	Client에 요청이 있을 때마다 DB 서버와 연결을 하기위해
//	Connect 객체를 얻어내야 했음.

// 단점 :
//		1. Connection 과정은 일정 시간이 소요되는 작업(반복)
//		2. 불필요한 연결에 의한 서버자원 낭비

// 단점 보완 : DBCP(DataBase Connection Pool)
// 		여러개의 DBConnection을 하나의 Pool에 모아두고 관리함.
//		필요할 때마다 Pool을 꺼내서 사용하기만 하면 됨. (META-INF > context.xml)
//		만약, 빌려올 수 있는 Connection이 없다면, Connection 객체가 반환 될 떄 까지 클라이언트는 대기상태로 전환
//		사용이 끝난 Connection 객체가 다시 Pool로 반환

public class JiDBManager {

	public static Connection connect(String poolName) throws Exception {
		
		Context ctx = new InitialContext();	// import javax.naming.Context;
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/" + poolName);// import javax.sql.DataSource;
		return ds.getConnection();
		
	}
	
	public static void close(Connection conn,PreparedStatement pstmt,ResultSet rs) {
		
		try {
			
			rs.close();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			
			
			
		}
		
	}
	
	
}
