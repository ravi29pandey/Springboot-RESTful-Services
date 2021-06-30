package com.example.demo.topic;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String>{
/*Using interface here since spring data uses JPA which itself is a interface for implementation*/
	  
	
	
	
}
