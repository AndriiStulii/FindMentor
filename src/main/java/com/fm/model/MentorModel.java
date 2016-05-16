package com.fm.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fm.entity.Status;

/**
 * Created by andrewstulii on 16.05.16.
 */
public class MentorModel extends UserModel {

    private String name;
    private String language;
    private int experience;
    private String company;
    private Status status;

    @JsonCreator
    public MentorModel(@JsonProperty("name")String name,
                       @JsonProperty("language")String language,
                       @JsonProperty("experience")int experience,
                       @JsonProperty("company")String company,
                       @JsonProperty("status")Status status) {
        this.name = name;
        this.language = language;
        this.experience = experience;
        this.company = company;
        this.status = status;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
