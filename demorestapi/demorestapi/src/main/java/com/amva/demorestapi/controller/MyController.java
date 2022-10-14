package com.amva.demorestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amva.demorestapi.entity.Course;
import com.amva.demorestapi.service.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService cr;
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to AMVA software Company";
	}
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.cr.getCourses();
		
	}
	@GetMapping("/courses/{courseID}")
	public Course getCourse(@PathVariable String courseID) {
			
		return this.cr.getCourse(Long.parseLong(courseID));
	}
	
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.cr.addCourse(course);
	}
}
