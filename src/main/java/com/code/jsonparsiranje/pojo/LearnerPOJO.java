package com.code.jsonparsiranje.pojo;

import java.util.List;

public class LearnerPOJO {

    private String learner;
    private List<CoursePOJO> courses;

    public String getLearner() {
        return learner;
    }

    public void setLearner(String learner) {
        this.learner = learner;
    }

    public List<CoursePOJO> getCourses() {
        return courses;
    }

    public void setCourses(List<CoursePOJO> courses) {
        this.courses = courses;
    }
}
