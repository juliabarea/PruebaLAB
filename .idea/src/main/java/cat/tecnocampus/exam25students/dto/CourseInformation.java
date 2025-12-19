package cat.tecnocampus.exam25students.dto;

import java.util.List;

public class CourseInformation {

    private Long id;
    private String name;
    private List<LessonInformation> lessons;

    public CourseInformation() {
    }

    public CourseInformation(Long id, String name, List<LessonInformation> lessons) {
        this.id = id;
        this.name = name;
        this.lessons = lessons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LessonInformation> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonInformation> lessons) {
        this.lessons = lessons;
    }
}

