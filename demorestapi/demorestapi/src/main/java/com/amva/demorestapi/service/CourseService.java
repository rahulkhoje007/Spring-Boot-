package com.amva.demorestapi.service;

import java.util.List;

import com.amva.demorestapi.entity.Course;

public interface CourseService {
	
	public List<Course> getCourses();

	public Course getCourse(Long courseID);
	
	public Course addCourse(Course course);
	
}
