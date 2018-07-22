package io.springboot.SpringBootDataJpa.course;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {

	public List<Course> findByTopicId(int xkcd); //Syntax findBy+EntityName+ParameterToFindBy//argument name can be any.
}
