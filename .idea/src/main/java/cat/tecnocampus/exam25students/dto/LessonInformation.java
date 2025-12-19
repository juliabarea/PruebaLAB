package cat.tecnocampus.exam25students.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LessonInformation {

    @JsonProperty("order")
    private int lessonOrder;

    private String title;

    public LessonInformation() {
    }

    public LessonInformation(int lessonOrder, String title) {
        this.lessonOrder = lessonOrder;
        this.title = title;
    }

    public int getLessonOrder() {
        return lessonOrder;
    }

    public void setLessonOrder(int lessonOrder) {
        this.lessonOrder = lessonOrder;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

