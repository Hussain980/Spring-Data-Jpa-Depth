package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Guardian;
import com.example.demo.entity.Student;

@SpringBootTest
class StudentRepositoryTest {

	@Autowired
	private StudentRepository studentRepo;
	
	@Test
	@Disabled
	public void saveStudent() {
		Student s = new Student("Hussain", "Mansoori", "hussain@gmail.com");
		Student s1 = new Student("Maniish", "Patel", "manish@gmail.com");
		ArrayList<Student> st = new ArrayList<>();
		st.add(s);
		st.add(s1);
		studentRepo.saveAll(st);
	}
	
	@Test
	@Disabled
	public void saveStudentWithGuardian() {
		Guardian g = new Guardian("Nikhil", "nk@gmail.com", "898793742934");
		Student s = new Student("hussain", "Mansoori", g, "hussain@gmail.com");
		studentRepo.save(s);
	}
	
	@Test
	@Disabled
	public void printAll() {
		List<Student> list = studentRepo.findAll();
		System.out.println("List >>>>>>>> " + list);
	}
	
	@Test
	@Disabled
	public void printStudentByFirstName() {
		List<Student> students = studentRepo.findByFirstName("Hussain");
		System.out.println("Students By First Name  "+ students);
	}
	
	@Test
	@Disabled
	public void getStudentByEmailId() {
		Student s = studentRepo.getStudentByEmailAddress("hussain@gmail.com");
		System.out.println("Students By EmailAddress  "+ s);
	}
	
	@Test
	@Disabled
	public void getStudentFirstnameByEmailId() {
		String s = studentRepo.getStudentFirstNameByEmailAddress("hussain@gmail.com");
		System.out.println("Students By EmailAddress  "+ s);
	}
	
	@Test
	@Disabled
	public void getStudentByEmailIdNative() {
		Student s = studentRepo.getStudentByEmailAddressNative("hussain@gmail.com");
		System.out.println("Students By EmailAddress Native query  "+ s);
	}
	
	
	@Test
	@Disabled
	public void getStudentByEmailIdNativeParam() {
		Student s = studentRepo.getStudentByEmailAddressNativeNamed("hussain@gmail.com");
		System.out.println("Students By EmailAddress Native Named Parameter query  "+ s);
	}
	
	@Test
	public void updateStudentByEmailId() {
	   studentRepo.updateStudentByEmailId("Hussain Khan","hussain@gmail.com");
		System.out.println("updated >>>");
	}
	

}
