package com.example.demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

	
	@Autowired
	/*Object dependency in code*/
	public TopicService topicService;
	
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopis(){
		return topicService.getAllTopics();
		
	}
	
	@RequestMapping("/topics/{id}")
	/*this {id} takes URL part as variable and 
	what is passed will fetch from here and path variable annotation tells 
	method argument that this take id as variable which is to be passed */
	/*{id} -> map to String id using @PathVariable*/
	
	public Optional<Topic> getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST , value="/topics")
	/*for default @RequestMapping  works for GET so explicitly telling it for POST*/
	public void addTopic(@RequestBody Topic topic)
	/*it tells MVC to create instance of topic of Topic via @RequestBody*/{
		topicService.addTopic(topic);
		
		
	} 
	
	@RequestMapping(method=RequestMethod.PUT , value="/topics/{id}")
	/*for default @RequestMapping  works for GET so explicitly telling it for POST*/
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id)
	/*it tells MVC to create instance of topic of Topic via @RequestBody*/{
		topicService.updateTopic(id,topic);
		} 
	  
	@RequestMapping(method=RequestMethod.DELETE , value="/topics/{id}")
	
	public void deleteTopic(@RequestBody Topic topic,@PathVariable String id)
	{
		topicService.deleteTopic(id);
		} 
	
	
	
	
	
	
	
}
