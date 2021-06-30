package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/*Service make this class a business service*/
public class TopicService {
	
	
	@Autowired
	private TopicRepository topicRepository;
	
	
/*	private  List<Topic> topics=new ArrayList<>(Arrays.asList(
				new Topic("Spring","SpringFramework","SpringFrameworkDescription"),
				new Topic("java","Core java","Core Java description"),
				new Topic("DSA","data structure and algorithm","DSADescription"),
				new Topic("DSA","data structure and algorithm 450","DSADescription")
					));
*/
      public List<Topic> getAllTopics(){
		//return topics;
    	  List<Topic> topics=new ArrayList<>();
    	  topicRepository.findAll()
    	  .forEach(topics::add);
    	 return topics;
      }
      //GET
      public Optional<Topic> getTopic(String id) {
	  // return	topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    	return topicRepository.findById(id); 
    	 
       }
      //POST
      public void addTopic(Topic topic) {
    	  topicRepository.save(topic);
      }
       //PUT
	  public void updateTopic(String id,Topic topic) {
		topicRepository.save(topic); 	//it automatically knows is it for POST  or PUT
			   
		}
	//DELETE   
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

	





}
