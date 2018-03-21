package com.frontendforresume_fc.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;


    private boolean answer;

    @ManyToMany(mappedBy = "programmeRequirements")
    private Set<Programme> programmes;

    @ManyToMany(mappedBy = "studentRequirements")
    private Set<User> students;

    public Requirement() {
    }

    public Requirement(String description, boolean answer) {
        this.description = description;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public Set<Programme> getProgrammes() {
        return programmes;
    }

    public void setProgrammes(Set<Programme> programmes) {
        this.programmes = programmes;
    }

    public Set<User> getStudents() {
        return students;
    }

    public void setStudents(Set<User> students) {
        this.students = students;
    }

}
