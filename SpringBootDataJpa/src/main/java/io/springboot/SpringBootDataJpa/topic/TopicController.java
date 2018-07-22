package io.springboot.SpringBootDataJpa.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

	@Autowired
	TopicService topicService;

	@RequestMapping(method=RequestMethod.GET, value="/topics")	//Get fetches values.
	public List<Topic> allTopics(){

		return topicService.allTopics();
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics")	//Post inputs data.
	public void addTopic(@RequestBody Topic topic) {
		System.out.println("Adding Topic");
		topicService.saveTopic(topic);
	}

	@RequestMapping(method=RequestMethod.GET, value="/topics/{id}")
	public Optional<Topic> getTopic(@PathVariable("id") int id) {
		System.out.println("Finding Topic");
		Optional<Topic> topic = topicService.findTopic(id);
		return topic;
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topics/{id}")	//Put updates data
	public void updateTopic(@PathVariable int id,@RequestBody Topic topic) {
		System.out.println("update Topic");
		if(topicService.topicExists(id)) {
			System.out.println("Updating Topic");
			topicService.updateTopic(topic);
		}
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{id}")	//Delete deletes values.
	public void deleteTopic(@PathVariable int id){
		topicService.deleteTopic(id);
	}

}
