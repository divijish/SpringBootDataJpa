package io.springboot.SpringBootDataJpa.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.springboot.SpringBootDataJpa.topic.Topic;
import io.springboot.SpringBootDataJpa.topic.TopicRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	TopicRepository topicRepository;
	
	public List<Course> getAllCourses(int topicId) 
	{
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(courses::add);
		return courses;
	}
	
	public void saveCourse(int topicId, Course course) 
	{
		Topic topic = topicRepository.findById(topicId).get();
		topic.setCourse(course);
		course.setTopic(new Topic(topicId, "", ""));
		courseRepository.save(course);
	}
	
	public void updateCourse(int id, Course course) 
	{
		if(courseRepository.existsById(id))
		courseRepository.save(course);
		else 
		{
			System.out.println("Course doesn't exist.");
		}
	}

	public Optional<Course> findCourseById(int id) 
	{
		System.out.println("Checking if Id exists or not");
		if(courseRepository.existsById(id)) 
		{
			System.out.println("Id exists");
			return courseRepository.findById(id);
		}else
		System.out.println("Id doesn't exist");

		return null;
	}

	public boolean courseExists(int id) 
	{
		// TODO Auto-generated method stub
		return courseRepository.existsById(id);
	}

	public void deleteCourse(int id) 
	{
		
		if(courseRepository.existsById(id)) 
		{
			courseRepository.deleteById(id);
		}else 
		{
			System.out.println("Could not delete course as it doesn't exist.");
		}
	}

}
