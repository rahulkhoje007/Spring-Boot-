package com.amva.demorestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amva.demorestapi.entity.Course;
import com.amva.demorestapi.service.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService cr;
	
	@GetMapping("/courses")
	public List<Course> getCourses(){
		
		return this.cr.getCourses();
		
	}
	@GetMapping("/courses/{courseID}")
	public Course getCourse(@PathVariable String courseID) {
			
		return this.cr.getCourse(Long.parseLong(courseID));
	}
	
	@PostMapping("/addCourses")
	public Course addCourse(@RequestBody Course course) {
		
		return this.cr.addCourse(course);
	}
	
	@PutMapping("/updateCourse")
	public Course updateCourse(@RequestBody Course course) {
		return this.cr.updateCourse(course);
		
	}
	
	@DeleteMapping("/deleteCourse/{CourseID}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String CourseID)
	{
		this.cr.deleteCourse(Long.parseLong(CourseID));
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PatchMapping("/patchCourse")
	public Course patchCourse(@RequestBody Course course) {
		return this.cr.patchCourse(course);
	}
	
}
