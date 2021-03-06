package com.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.training.entity.Courses;
import com.training.entity.Student;

public class StudentDAOimpl implements StudentDAO {

private Connection conn;
	
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		String sql="insert into studentshv values(?,?,?)";
		PreparedStatement pstmt=null;
		int rowAdded=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setLong(1, student.getStudentId());
			pstmt.setString(2, student.getStudentName());
			pstmt.setLong(3, student.getCourseId());
			rowAdded=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rowAdded;
	}

	public StudentDAOimpl() {
		super();
		conn=DbConnections.getConnection();
		// TODO Auto-generated constructor stub
	}

}
