package io.kiran.courseapi.course;

import io.kiran.courseapi.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses (@PathVariable String topicId ) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getTopic(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId) {
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(id,course);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/topics/{topicid}/courses/{id}")
    public void deletecourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
