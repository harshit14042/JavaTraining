package com.training.entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.training.utils.CourseDAO;
import com.training.utils.DbConnections;

public class Courses implements Serializable {
	private long courseid;
	private String courseName;
	
	private Connection conn;
	public long getCourseid() {
		return courseid;
	}
	public void setCourseid(long courseid) {
		this.courseid = courseid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Courses [courseid=" + courseid + ", courseName=" + courseName + "]";
	}
	public Courses(long courseid, String courseName) {
		super();
		this.courseid = courseid;
		this.courseName = courseName;
	}
	public Courses() {
		super();
		
		// TODO Auto-generated constructor stub
	}
	
	
}
