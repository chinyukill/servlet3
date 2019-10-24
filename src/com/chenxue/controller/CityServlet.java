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

import com.chenxue.bean.City;
import com.chenxue.bean.Province;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet("/province_city/city.do")
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection =null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select * from city where pid=?";
		String pId = request.getParameter("pId");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/chenxue","root","root");
			ps=connection.prepareStatement(sql);
			ps.setString(1, pId);
			rs=ps.executeQuery();
			response.setContentType("application/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			ArrayList<City> CityList = new ArrayList<>();
			while(rs.next()) {
				int cityId=rs.getInt(1);
				String cityName = rs.getString(2);
				City city = new City(cityId, cityName, Integer.valueOf(pId));
				CityList.add(city);
			}
			out.write(JSONArray.fromObject(CityList).toString());
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
