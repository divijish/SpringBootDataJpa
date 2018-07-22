package io.springboot.SpringBootDataJpa.topic;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import io.springboot.SpringBootDataJpa.course.Course;
import javax.persistence.OneToMany;
@Entity
public class Topic {

	@Id
	private int id;
	private String name;
	private String description;
	@OneToMany 			//Jpa has made this redundant.
	private List<Course> courses;

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	protected Topic() {

	}

	public Topic(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCourse(Course course) {
		courses.add(course);
	}

}
