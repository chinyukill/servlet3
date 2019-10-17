package com.chenxue.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeptCheckServlet
 */
@WebServlet("/dept/check.do")
public class DeptCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String dname=null;
		String sql=" select count(*) "
				+ " from dept "
				+ " where dname=? ";
		dname=request.getParameter("dname");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			ps=connection.prepareStatement(sql);
			ps.setString(1, dname);
			rs=ps.executeQuery();
			rs.next();
			int num=rs.getInt(1);
			response.setCharacterEncoding("utf-8");
			PrintWriter outPrintWriter=response.getWriter();
			response.setContentType("text/html;charset=utf-8");
			if (num==0) {
				outPrintWriter.write("部门名称可使用");
			} else {
				outPrintWriter.write("部门名重复，请更换");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
