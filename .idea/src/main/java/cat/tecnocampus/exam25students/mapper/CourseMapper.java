package cat.tecnocampus.exam25students.mapper;

import cat.tecnocampus.exam25students.domain.college.Course;
import cat.tecnocampus.exam25students.domain.college.Lesson;
import cat.tecnocampus.exam25students.dto.CourseInformation;
import cat.tecnocampus.exam25students.dto.LessonInformation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CourseMapper {

    public static CourseInformation toCourseInformation(Course course) {
        List<LessonInformation> lessons = course.getLessons().stream()
                .sorted(Comparator.comparingInt(Lesson::getLessonOrder))
                .map(CourseMapper::toLessonInformation)
                .collect(Collectors.toList());

        return new CourseInformation(course.getId(), course.getName(), lessons);
    }

    public static LessonInformation toLessonInformation(Lesson lesson) {
        return new LessonInformation(lesson.getLessonOrder(), lesson.getTitle());
    }
}

