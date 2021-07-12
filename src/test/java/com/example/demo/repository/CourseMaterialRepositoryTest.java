package com.example.demo.repository;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Course;
import com.example.demo.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository courseMaterialRepo;

	@Test
	@Disabled
	void saveCourseMaterial() {
		Course c = new Course("java first", 5);
		CourseMaterial cm = new CourseMaterial("www.google.com", c);
		courseMaterialRepo.save(cm);
		
	}
	
	@Test
	public void getAllCourseMaterial() {
		List<CourseMaterial> cm = courseMaterialRepo.findAll();
		System.out.println(cm);
	}

}
