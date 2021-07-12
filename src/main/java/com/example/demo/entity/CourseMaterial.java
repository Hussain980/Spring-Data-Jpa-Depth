package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CourseMaterial {
 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long courseMaterialId;
    private String url;
    
    @OneToOne(
    		 cascade = CascadeType.ALL,
    		 fetch = FetchType.LAZY
    		// fetch = FetchType.EAGER
    		)
    @JoinColumn(
    		   name = "course_Id",
    		   referencedColumnName = "courseId"
    		)
    private Course course;

	public Long getCourseMaterialId() {
		return courseMaterialId;
	}

	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public CourseMaterial() {
		
	}
    
	
	public CourseMaterial(String url, Course course) {
		super();
		this.url = url;
		this.course = course;
	}

	@Override
	public String toString() {
		return "CourseMaterial [courseMaterialId=" + courseMaterialId + ", url=" + url + "]";
	}

	

	    
}
