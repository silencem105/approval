package com.cn.majj;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import java.sql.Connection;

public class DbUtil {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//DbUtil.getUserByName("mjj", "123");
		//User user=new User();
		//user.setUserId(UUID.randomUUID().toString());
		//user.setUserName("zkn");
		//user.setPassword("111");
		DbUtil.deleteUser("1001");
	}

	public static boolean getUserByName(String userName, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		String URL = "jdbc:mysql://127.0.0.1:3306/approval";
		String jdbc_user = "root";
		String jdbc_password = "111111";
		
		// 加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		// 获取数据库连接
		Connection con = DriverManager.getConnection(URL, jdbc_user, jdbc_password);
		// 创建Statament对象
		Statement st = con.createStatement();
		String s = "select user_name,password from tbl_user where user_name=? and password=?";
		PreparedStatement pst = con.prepareStatement(s);
		pst.setString(1, userName);
		pst.setString(2, password);
		ResultSet rst = pst.executeQuery();
		// 处理数据库的返回结果(使用ResultSet类)
		while (rst.next()) {
			System.out.println(rst.getString("user_name") + " " + rst.getString("password"));
			return true;
		}
		rst.close();
		pst.close();
		con.close();
		return false;
	}
	public static int addUser(User u) throws ClassNotFoundException, SQLException{
		String URL="jdbc:mysql://127.0.0.1:3306/approval";
		String jdbc_user="root";
		String jdbc_password="111111";

		// 加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		// 获取数据库连接
		Connection con = DriverManager.getConnection(URL, jdbc_user, jdbc_password);
		// 创建Statament对象
		Statement st = con.createStatement();
		String s="insert into tbl_user(id,user_name,password) values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(s);
		String name=u.getUserName();
		String pwd=u.getPassword();
		String id=u.getUserId();
		pst.setString(1, id);
		pst.setString(2, name);
		pst.setString(3, pwd);
		int n=pst.executeUpdate();
		return n;
		
	}
	
	public static int deleteUser(String user_id) throws ClassNotFoundException, SQLException{
		
		String URL="jdbc:mysql://127.0.0.1:3306/approval";
		String jdbc_user="root";
		String jdbc_password="111111";	
		// 加载驱动程序
				Class.forName("com.mysql.jdbc.Driver");
				// 获取数据库连接
				Connection con = DriverManager.getConnection(URL, jdbc_user, jdbc_password);
				// 创建Statament对象
				Statement st = con.createStatement();
				String s="delete from tbl_user where id=?";
				PreparedStatement pst=con.prepareStatement(s);
				pst.setString(1, user_id);
				int n=pst.executeUpdate();
				return n;
	}

}
