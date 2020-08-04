package com.code.jsonparsiranje.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class CoursePOJO {

    private String title;
    private boolean learning;
    private LocalDate startDay;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLearning() {
        return learning;
    }

    public void setLearning(boolean learning) {
        this.learning = learning;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }
}
