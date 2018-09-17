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
		// 根据用户名称查询用户
		/* DbUtil.getUserByName("mjj", "123"); */

		// 新增用户
		/*
		 * User user=new User(); user.setUserId(UUID.randomUUID().toString());
		 * user.setUserName("zkn"); user.setPassword("111");
		 * DbUtil.addUser(user);
		 */

		// 根据id查询用户
		/*
		 * User u = DbUtil.queryUsers("2009620d-32ae-472f-becc");
		 * System.out.println(u.getUserId()); System.out.println("姓名:" +
		 * u.getUserName()); System.out.println("密码:" + u.getPassword());
		 */

		// 更新用户
		User u = new User();
		u.setUserId("2009620d-32ae-472f-becc-fdaca54ef9e9");
		u.setPassword("123");
		u.setUserName("mm");
		int n = DbUtil.updateUser(u);
		if (n == 1) {
			System.out.println("更新成功");
		} else {
			System.out.println("更新失败");
		}

	}

	public static boolean getUserByName(String userName, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		User user = new User(); //实例化对象
		Connection con = getConnection();//创建数据库连接
		Statement st = con.createStatement();// 创建Statament对象
		String s = "select user_name,password from tbl_user where user_name=? and password=?";
		PreparedStatement pst = con.prepareStatement(s);//调用对象con方法赋值给引用
		pst.setString(1, userName);//将入参userName赋值给第一个参数
		pst.setString(2, password);//将入参password赋值给第二个参数
		ResultSet rst = pst.executeQuery();//执行sql语句
		// 处理数据库的返回结果(使用ResultSet类)
		while (rst.next()) {
			System.out.println(rst.getString("user_name") + " " + rst.getString("password"));
			return true;
		}//当处理结果集非空即while条件为true时，输出用户名和密码，并返回true
		rst.close();//关闭结果集
		pst.close();//关闭pst
		con.close();//关闭数据库连接
		return false;//当处理结果集为空即while条件为false时，输出用户名和密码，并返回false
	}

	public static int addUser(User u) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		// 创建Statament对象
		Statement st = con.createStatement();
		String s = "insert into tbl_user(id,user_name,password) values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(s);
		String name = u.getUserName();
		String pwd = u.getPassword();
		String id = u.getUserId();
		pst.setString(1, id);
		pst.setString(2, name);
		pst.setString(3, pwd);
		int n = pst.executeUpdate();
		return n;

	}

	public static int deleteUser(String user_id) throws ClassNotFoundException, SQLException {

		Connection con = getConnection();
		// 创建Statament对象
		Statement st = con.createStatement();
		String s = "delete from tbl_user where id=?";
		PreparedStatement pst = con.prepareStatement(s);
		pst.setString(1, user_id);
		int n = pst.executeUpdate();
		return n;
	}

	public static User queryUsers(String id) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();// 创建Statement对象
		String s = "select id, user_name,password from tbl_user where id=?";
		PreparedStatement pst = con.prepareStatement(s);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		String user_id = null;
		String name = null;
		String password = null;
		while (rs.next()) {
			user_id = rs.getString("id");
			name = rs.getString("user_name");
			password = rs.getString("password");

		}
		User u = new User();
		u.setUserId(user_id);
		u.setUserName(name);
		u.setPassword(password);

		rs.close();
		pst.close();
		con.close();
		return u;

	}

	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		String URL = "jdbc:mysql://127.0.0.1:3306/approval";
		String jdbc_user = "root";
		String jdbc_password = "111111";
		Class.forName("com.mysql.jdbc.Driver");// 加载驱动程序
		Connection con = DriverManager.getConnection(URL, jdbc_user, jdbc_password);// 获取数据库连接
		return con;
	}

	public static int updateUser(User u) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		String s = "update tbl_user set user_name=?,password=? where id=?";
		PreparedStatement pst = con.prepareStatement(s);
	    pst.setString(1, u.getUserName());
		pst.setString(2, u.getPassword());
		pst.setString(3, u.getUserId());
		return pst.executeUpdate();

	}
}
