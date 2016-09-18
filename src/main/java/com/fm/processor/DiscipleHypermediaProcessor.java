package com.fm.processor;

import com.fm.controller.DiscipleController;
import com.fm.model.DiscipleModel;
import com.fm.model.UserModel;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by andrewstulii on 16.05.16.
 */
@Component
public class DiscipleHypermediaProcessor implements ResponseProcessor {

    @Override
    public DiscipleModel processResponseModel(UserModel model, int id, int mid) {
        DiscipleModel disciple = (DiscipleModel) model;
        disciple.add(linkTo(methodOn(DiscipleController.class).acceptDisciple(id, mid)).withRel("Accept disciple"));
        disciple.add(linkTo(methodOn(DiscipleController.class).declineDisciple(id, mid)).withRel("Decline disciple"));
        return disciple;
    }
}
