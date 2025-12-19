package cat.tecnocampus.exam25students.repository;

import cat.tecnocampus.exam25students.domain.college.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @EntityGraph(attributePaths = "lessons")
    Optional<Course> findWithLessonsById(Long id);
}
