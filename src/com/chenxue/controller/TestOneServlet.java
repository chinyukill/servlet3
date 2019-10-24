package com.chenxue.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxue.bean.Dept;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import sun.awt.RepaintArea;

/**
 * Servlet implementation class TestOneServlet
 */
@WebServlet("/one.do")
public class TestOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/*String jsonObj = "{\"deptno\":\"10\",\"dname\":\"ACCOUNTTING\",\"loc\":\"beijing\"}";
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonObj);*/
		
		
		
		/*Dept dept = new Dept(10,"10","10adrress");//2
		JSONObject jsonObj = JSONObject.fromObject(dept);//2
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonObj.toString());*/
		
		
		
		/*Dept dept1 = new Dept(10,"10","10adrress");
		Dept dept2 = new Dept(10,"11","11adrress");
		Dept dept3 = new Dept(10,"12","12adrress");
		ArrayList<Dept> deptList = new ArrayList();
		deptList.add(dept1);
		deptList.add(dept2);
		deptList.add(dept3);
		JSONArray jsonArray = JSONArray.fromObject(deptList);
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.write(jsonArray.toString());*/
		
		
		
		Connection connection=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String dname=null;
		String keyWord=request.getParameter("keyWord");
		String sql=" select * "
				+ " from dept ";
				if (!"".equals(keyWord)) {
					sql += " where dName like ? "
							+ " or loc like ?"
							+ " or deptNo like ?";
				}				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			ps=connection.prepareStatement(sql);
			if (!"".equals(keyWord)) {
				ps.setString(1, "%"+keyWord+"%");
				ps.setString(2, "%"+keyWord+"%");
				ps.setString(3, keyWord+"%");
			}	
			rs=ps.executeQuery();
			ArrayList<Dept> deptList = new ArrayList();
			while(rs.next()) {
				int deptNo = rs.getInt(1);
				String dName = rs.getString(2);
				String loc = rs.getString(3);
				Dept dept = new Dept(deptNo, dName, loc);
				deptList.add(dept);
			}
			JSONArray jsonArray = JSONArray.fromObject(deptList);
			request.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.write(jsonArray.toString());
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
