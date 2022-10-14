package com.amva.demorestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amva.demorestapi.entity.Course;

@Service
public class CourseServiceimpl implements CourseService {

	List<Course> list;

	public CourseServiceimpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "Java Course", "Contains Basic of Java"));
		list.add(new Course(205, "Spring Boot", "Contains Rest Api"));
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(Long courseID) {
		Course c= null;
		for(Course course:list) {
			if(course.getId()==courseID)
			{
				c=course;
				break;
			}
		}
			
		return c;
	}

	@Override
	public Course addCourse(Course course) {


		list.add(course);
		return course;
	}

}
