package com.example.demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.topic.Topic;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

	
	@Autowired
	/*Object dependency in code*/
	private CourseService courseService;
	
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id){
		return courseService.getAllCourses(id);
		
	}
	
	/*@RequestMapping("/topics/{topicid}/courses/{id}")
	/*this {id} takes URL part as variable and 
	what is passed will fetch from here and path variable annotation tells 
	method argument that this take id as variable which is to be passed */
	/*{id} -> map to String id using @PathVariable*/
	/*public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
		
	}*/
	
	
	@RequestMapping(method=RequestMethod.POST , value="/topics/{topicId}/courses")
	/*for default @RequestMapping  works for GET so explicitly telling it for POST*/
	public void addCourse(@RequestBody Course course, @PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
		} 
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{topicId}/courses/{id}")
	/*for default @RequestMapping  works for GET so explicitly telling it for POST*/
	public void updateTopic(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id)
	{
		course.setTopic(new Topic(topicId,"",""));
		
		courseService.updateCourse(course);
		} 
	  
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id)
	{
	courseService.deleteCourse(id);
		} 
	
	
	
	
	
	
	
}
