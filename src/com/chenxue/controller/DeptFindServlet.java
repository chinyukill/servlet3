package com.chenxue.controller;

import java.io.IOException;
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
 * Servlet implementation class DeptFindServlet
 */
@WebServlet("/dept/find.do")
public class DeptFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection=null;
		PreparedStatement pStatement=null;
		ResultSet rSet=null;
		String sql=" select dname,ifnull(job,'没有部门') as job, "
				+ " count(emp.ename) as jobNum "
				+ " from dept left join emp "
				+ " on dept.deptno = emp.deptno "
				+ " group by dname,job ";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			pStatement=connection.prepareStatement(sql);
			rSet=pStatement.executeQuery();
			Map deptMap = new HashMap();
			while (rSet.next()) {
				String dname=rSet.getString("dname");
				String job=rSet.getString("job");
				String jobNum=rSet.getString("jobNum");
				Map map=(Map) deptMap.get(dname);
				if (map==null) {
					map= new HashMap();
					map.put(job, jobNum);
					deptMap.put(dname, map);
				}else {
					map.put(job, jobNum);
				}
				
			}
			request.setAttribute("deptInfo", deptMap);
			request.getRequestDispatcher("/dept_show.jsp").forward(request, response);
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
