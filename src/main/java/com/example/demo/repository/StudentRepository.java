package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

	List<Student> findByFirstName(String FirstName);

	//jpql
	@Query("select s from Student s where s.emailId= ?1")
	Student getStudentByEmailAddress(String EmailId);

	//jpql
	@Query("select s.firstName from Student s where s.emailId= ?1")
	String getStudentFirstNameByEmailAddress(String emailId);

	
	//Native query
	@Query(value = "SELECT * FROM springdatajpa.tbl_student where email_address= ?1" ,
			nativeQuery = true)
	Student getStudentByEmailAddressNative(String emailId);
	
	//Native named parameter query
		@Query(value = "SELECT * FROM springdatajpa.tbl_student where email_address=:emailId" ,
				nativeQuery = true)
		Student getStudentByEmailAddressNativeNamed(@Param("emailId") String emailId);

		@Modifying
		@Transactional
		@Query(value = "update springdatajpa.tbl_student set first_name=?1 where email_address=?2" ,
		           nativeQuery = true
				 )
		void updateStudentByEmailId(String firstName, String emailId);


}
