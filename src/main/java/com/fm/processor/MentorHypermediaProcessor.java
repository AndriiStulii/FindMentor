package com.fm.processor;

import com.fm.model.MentorModel;
import com.fm.model.UserModel;

/**
 * Created by andrewstulii on 16.05.16.
 */
public class MentorHypermediaProcessor implements ResponseProcessor {

    @Override
    public MentorModel processResponseModel(UserModel model) {
        return (MentorModel) model;
    }
}
