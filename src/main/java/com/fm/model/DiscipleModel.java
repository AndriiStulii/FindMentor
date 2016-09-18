package com.fm.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fm.entity.Disciple;
import com.fm.entity.Mentor;


/**
 * Created by andrewstulii on 16.05.16.
 */
public class DiscipleModel extends UserModel {

    private String name;
    private String language;
    private Mentor mentor;
    private int age;
    private String university;

    @JsonCreator
    public DiscipleModel(@JsonProperty("name") String name,
                         @JsonProperty("language") String language,
                         @JsonProperty("mentor") Mentor mentor,
                         @JsonProperty("age") int age,
                         @JsonProperty("university") String university) {
        this.name = name;
        this.language = language;
        this.mentor = mentor;
        this.age = age;
        this.university = university;
    }

    public DiscipleModel(Disciple disciple) {
        this.name = disciple.getName();
        this.language = disciple.getLanguage();
        this.mentor = disciple.getMentor();
        this.age = disciple.getAge();
        this.university = disciple.getUniversity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
