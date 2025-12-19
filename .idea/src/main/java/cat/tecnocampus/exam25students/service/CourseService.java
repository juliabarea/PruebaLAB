package cat.tecnocampus.exam25students.service;

import cat.tecnocampus.exam25students.dto.CourseInformation;
import cat.tecnocampus.exam25students.exception.NotFoundException;
import cat.tecnocampus.exam25students.repository.CourseRepository;
import cat.tecnocampus.exam25students.mapper.CourseMapper;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseInformation getCourseById(long courseId) {
        return courseRepository.findWithLessonsById(courseId)
                .map(CourseMapper::toCourseInformation)
                .orElseThrow(() -> new NotFoundException("Course with id " + courseId + " not found"));
    }
}

