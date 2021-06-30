package com.example.demo.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String>{

	//Course findAll(String id);
/*Using interface here since spring data uses JPA which itself is a interface for implementation*/
	  
	//public List<Course> findByTopicId(String topicId);
	/*you don't have to implement the method | just declare the method with 
	 * the findByProperty name format and Spring Data JPA will implement the method for you*/
    // public Course findOne(String id);

	public ArrayList<Course> findByTopicId(String topicId);
	
	
	
}
