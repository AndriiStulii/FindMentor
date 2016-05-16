package com.fm.processor;

import com.fm.model.DiscipleModel;
import com.fm.model.UserModel;

/**
 * Created by andrewstulii on 16.05.16.
 */
public class DiscipleHypermediaProcessor implements ResponseProcessor {

    @Override
    public DiscipleModel processResponseModel(UserModel model) {
        return (DiscipleModel)model;
    }
}
