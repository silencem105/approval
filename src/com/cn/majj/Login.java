package com.cn.majj;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8"); //��������������Ϊutf-8����
		response.setContentType("text/html;charset=utf-8"); //��������������Ϊutf-8
		String name = request.getParameter("username");//��ȡ�����еĲ���username
		String password = request.getParameter("password");//��ȡ�����еĲ���password
		DbUtil dt=new DbUtil();//ʵ��������
		boolean b=false;//��ʼ������
		try {
			b = dt.getUserByName(name, password);//���ö����getUserByName����
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(b){
			response.getWriter().write("��¼�ɹ�");}
		else{
			response.getWriter().write("��¼ʧ��");
		}
			
			
			
		}

	}


