package com.fm.processor;

import com.fm.controller.MentorController;
import com.fm.entity.Status;
import com.fm.model.MentorModel;
import com.fm.model.UserModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by andrewstulii on 16.05.16.
 */
@Component
public class MentorHypermediaProcessor implements ResponseProcessor {

    @Override
    public MentorModel processResponseModel(UserModel model, int id, int did) {
        MentorModel mentor = (MentorModel) model;
        if (mentor.getStatus().equals(Status.BOOKED)) {
            mentor.add(linkTo(methodOn(MentorController.class).freeMentor(id, did)).withRel("Free this mentor"));
        } else if (mentor.getStatus().equals(Status.FREE)) {
            mentor.add(linkTo(methodOn(MentorController.class).bookMentor(id, did)).withRel("Book this mentor"));
        }
        return mentor;
    }
}
