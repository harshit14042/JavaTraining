package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.training.entity.Courses;
import com.training.entity.Student;

public class CourseDAOImpl implements CourseDAO{

	private Connection conn;
	
	@Override
	public int addCourse(Courses course) {
		// TODO Auto-generated method stub
		String sql="insert into courseshv values(?,?)";
		PreparedStatement pstmt=null;
		int rowAdded=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, course.getCourseid());
			pstmt.setString(2, course.getCourseName());
			rowAdded=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowAdded;
	}
	public CourseDAOImpl() {
		super();
		conn=DbConnections.getConnection();
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Student> getStudents(String courseName) {
		// TODO Auto-generated method stub
		List<Student> students=new ArrayList<>();
		String sql="select studentid, studentname, studentshv.courseid from studentshv inner join courseshv on studentshv.courseid=courseshv.courseid where coursename=?";
		PreparedStatement pstmt = null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, courseName);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				long studentId=rs.getLong("studentid");
				String studentName=rs.getString("studentname");
				long courseId=rs.getLong("courseid");
				students.add(new Student(studentId,studentName,courseId));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return students;
	}
	
}
