package io.springboot.SpringBootDataJpa.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;
	
	public List<Topic> allTopics() {
		return (List<Topic>)topicRepository.findAll();
	}
	
	public void saveTopic(Topic t) {
		topicRepository.save(t);
	}
	public void updateTopic(Topic t) {
		topicRepository.save(t);
	}

	public Optional<Topic> findTopic(int id) {
		System.out.println("Checking if Id exists or not");
		if(topicRepository.existsById(id)) {
			System.out.println("Id exists");
			return topicRepository.findById(id);
		}
		System.out.println("Id doesn't exist");
		return null;
	}

	public boolean topicExists(int id) {
		// TODO Auto-generated method stub
		return topicRepository.existsById(id);
	}

	public void deleteTopic(int id) {
		
		if(topicRepository.existsById(id)) {
			topicRepository.deleteById(id);
		}
	}

}
