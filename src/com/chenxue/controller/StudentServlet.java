package com.chenxue.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chenxue.bean.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/Student.do")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu1 = new Student(1, "student1");
		Student stu2 = new Student(2, "student2");
		Student stu3 = new Student(3, "student3");
		Student stu4 = new Student(4, "student4");
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(stu1);
		students.add(stu2);
		students.add(stu3);
		students.add(stu4);
		request.setAttribute("students", students);
		HashMap<String, String> hashMap = new HashMap<String,String>();
		hashMap.put("1", "hashmap1");
		hashMap.put("2", "hashmap2");
		hashMap.put("3", "hashmap3");
		request.setAttribute("hashmaps", hashMap);
		request.getRequestDispatcher("/student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
