package com.chenxue.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxue.bean.DeptIndex3;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class DeptSelectServlet
 */
@WebServlet("/dept/select.do")
public class DeptSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String deptNo=request.getParameter("deptNo");
		String sql=" select dname,ifnull(job,'没有部门') as job, "
				+ " count(emp.ename) as jobNum "
				+ " from dept left join emp "
				+ " on dept.deptno=emp.deptno "
				+ " where dept.deptno = ? "
				+ " group by job ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			ps=connection.prepareStatement(sql);
			ps.setString(1, deptNo);
			rs=ps.executeQuery();
			ArrayList<DeptIndex3> deptIndex3List = new ArrayList<DeptIndex3>();
			while (rs.next()) {
				String dName = rs.getString(1);
				String jobName = rs.getString(2);
				int jobNum=rs.getInt(3);
				DeptIndex3 deptIndex3 = new DeptIndex3(dName, jobName, jobNum);
				deptIndex3List.add(deptIndex3);
			}
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			
			out.write(JSONArray.fromObject(deptIndex3List).toString());
			
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
