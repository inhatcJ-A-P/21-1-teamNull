package jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB {
	public static Connection conn;
	public static Statement stmt;
	
	
	/**
	 * DB 연결과 관련된 초기화 동작 수행
	 * -1. 연결 확인
	 */

	//1. init() 디비 연결
	
	public static void init() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://114.71.137.174:61083/japboss", "japboss","1222");
			// 오라클 접근 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "OTEST","1111");
			
			stmt = conn.createStatement();
			System.out.println("1. DB 연결 성--공 \n");
		} catch (Exception e) {
			throw new Exception("DB 오류 발생!!");
		}
	}
	
	//2. getResultSet() - 쿼리 결과 집합 가져오기
	public static ResultSet getResultSet(String sql) throws Exception 
	{
		try {
			stmt = conn.createStatement();
			return stmt.executeQuery(sql);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new Exception("쿼리 오류 : " + sql);
		}
	}
	
	//3. executeQuery() - 쿼리 수행하기
	public static void executeQuery(String sql) throws Exception {
		try {
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("쿼리 오류 : " + sql);
		}
	}
	public static void main(String[] args) {
		
	}
	
}
