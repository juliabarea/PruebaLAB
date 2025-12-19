package cat.tecnocampus.exam25students.controller;

import cat.tecnocampus.exam25students.dto.CourseInformation;
import cat.tecnocampus.exam25students.service.CourseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseRestController {

    private final CourseService courseService;

    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{courseId}")
    public CourseInformation getCourse(@PathVariable("courseId") long courseId) {
        return courseService.getCourseById(courseId);
    }
}

