package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Course;

@SpringBootTest
class CourseRepositoryTest {
	
	@Autowired
	CourseRepository courseRepo;

	@Test
	void getAllCourse() {
		List<Course> courses = courseRepo.findAll();
		System.out.println("Courses  >> "+courses);
		
	}

}
