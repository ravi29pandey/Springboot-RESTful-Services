package com.example.demo.course;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/*Service make this class a business service*/
public class CourseService {
	
	
	@Autowired
	private CourseRepository courseRepository;
	
	
/*	private  List<Topic> topics=new ArrayList<>(Arrays.asList(
				new Topic("Spring","SpringFramework","SpringFrameworkDescription"),
				new Topic("java","Core java","Core Java description"),
				new Topic("DSA","data structure and algorithm","DSADescription"),
				new Topic("DSA","data structure and algorithm 450","DSADescription")
					));
*/
      public List<Course> getAllCourses(String topicId){
		//return topics;
    	  List<Course> courses=new ArrayList<>();
    	  courseRepository.findByTopicId(topicId)
    	  .forEach(courses::add);
    	 return courses;
      }
      //GET
    /*  public Course getCourse(String id) {
	  // return	topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    return courseRepository.findOne(id);
    	 
       }*/
      //POST
      public void addCourse(Course course) {
    	  courseRepository.save(course);
      }
       //PUT
	  public void updateCourse(Course course) {
		  courseRepository.save(course); 	//it automatically knows is it for POST  or PUT
			   
		}
	//DELETE   
	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
	}

	





}
