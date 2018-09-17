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
		// �����û����Ʋ�ѯ�û�
		/* DbUtil.getUserByName("mjj", "123"); */

		// �����û�
		/*
		 * User user=new User(); user.setUserId(UUID.randomUUID().toString());
		 * user.setUserName("zkn"); user.setPassword("111");
		 * DbUtil.addUser(user);
		 */

		// ����id��ѯ�û�
		/*
		 * User u = DbUtil.queryUsers("2009620d-32ae-472f-becc");
		 * System.out.println(u.getUserId()); System.out.println("����:" +
		 * u.getUserName()); System.out.println("����:" + u.getPassword());
		 */

		// �����û�
		User u = new User();
		u.setUserId("2009620d-32ae-472f-becc-fdaca54ef9e9");
		u.setPassword("123");
		u.setUserName("mm");
		int n = DbUtil.updateUser(u);
		if (n == 1) {
			System.out.println("���³ɹ�");
		} else {
			System.out.println("����ʧ��");
		}

	}

	public static boolean getUserByName(String userName, String password) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		User user = new User(); //ʵ��������
		Connection con = getConnection();//�������ݿ�����
		Statement st = con.createStatement();// ����Statament����
		String s = "select user_name,password from tbl_user where user_name=? and password=?";
		PreparedStatement pst = con.prepareStatement(s);//���ö���con������ֵ������
		pst.setString(1, userName);//�����userName��ֵ����һ������
		pst.setString(2, password);//�����password��ֵ���ڶ�������
		ResultSet rst = pst.executeQuery();//ִ��sql���
		// �������ݿ�ķ��ؽ��(ʹ��ResultSet��)
		while (rst.next()) {
			System.out.println(rst.getString("user_name") + " " + rst.getString("password"));
			return true;
		}//�����������ǿռ�while����Ϊtrueʱ������û��������룬������true
		rst.close();//�رս����
		pst.close();//�ر�pst
		con.close();//�ر����ݿ�����
		return false;//����������Ϊ�ռ�while����Ϊfalseʱ������û��������룬������false
	}

	public static int addUser(User u) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		// ����Statament����
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
		// ����Statament����
		Statement st = con.createStatement();
		String s = "delete from tbl_user where id=?";
		PreparedStatement pst = con.prepareStatement(s);
		pst.setString(1, user_id);
		int n = pst.executeUpdate();
		return n;
	}

	public static User queryUsers(String id) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		Statement st = con.createStatement();// ����Statement����
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
		Class.forName("com.mysql.jdbc.Driver");// ������������
		Connection con = DriverManager.getConnection(URL, jdbc_user, jdbc_password);// ��ȡ���ݿ�����
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
