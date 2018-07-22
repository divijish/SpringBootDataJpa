package io.springboot.SpringBootDataJpa.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses")	//Get fetches values.
	public List<Course> allCourses(@PathVariable int topicId){

		return courseService.getAllCourses(topicId);
	}

	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")	//Post inputs data.
	public void addCourse(@PathVariable int topicId, @RequestBody Course course) {
		System.out.println("Adding course");
		courseService.saveCourse(topicId,course);
	}

	@RequestMapping(method=RequestMethod.GET, value="/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable("topicId") int topicId,@PathVariable("id") int id) {
		System.out.println("Finding Course");
		Optional<Course> course= courseService.findCourseById(id);
		return course;
	}

	@RequestMapping(method=RequestMethod.PUT, value="/topic/{topicId}/courses/{id}")	//Put updates data
	public void updateCourse(@PathVariable int id,@RequestBody Course course) {
		
		System.out.println("update course");
		courseService.updateCourse(id,course);
	
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/topic/{topicId}/courses/{id}")	//Delete deletes values.
	public void deleteTopic(@PathVariable int id){
		courseService.deleteCourse(id);
	}

}
