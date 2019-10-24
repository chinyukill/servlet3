package com.chenxue.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxue.bean.Province;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class ProvinceServlet
 */
@WebServlet("/province_city/province.do")
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from province";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			ArrayList<Province> provinceList = new ArrayList<>();
			while(rs.next()) {
				int pId=rs.getInt(1);
				String pName=rs.getString(2);
				Province province = new Province(pId,pName);
				provinceList.add(province);
			}
			out.write(JSONArray.fromObject(provinceList).toString());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
