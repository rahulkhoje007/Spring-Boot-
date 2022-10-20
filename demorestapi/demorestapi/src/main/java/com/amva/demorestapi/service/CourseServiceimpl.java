package com.amva.demorestapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		Course c = null;
		for (Course course : list) {
			if (course.getId() == courseID) {
				c = course;
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

	@Override
	public Course updateCourse(Course course) {

		list.forEach(e -> {
			if (e.getId() == course.getId()) {
				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});

		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		list = this.list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
	}

	@Override
	public Course patchCourse(Course course) {

		System.out.println("Get Id: " + course.getId());
		System.out.println("Get Description: " + course.getDescription());
		System.out.println("Get Title: " + course.getTitle());
		Course c1 = null;
		System.out.println(list.size());

		for (Course courseObject : list) {

			if (courseObject.getId() == course.getId()) {

				if (course.getDescription() != null)

				{

					courseObject.setDescription(course.getDescription());
				} else {
					break;
				}

				if (course.getTitle() != null) {

					courseObject.setTitle(course.getTitle());
				} else {
					break;
				}

			} else {
				break;
			}
			c1 = courseObject;
		}
		return c1;
	}
}