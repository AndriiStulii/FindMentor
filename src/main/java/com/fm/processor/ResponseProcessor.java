package com.fm.processor;

import com.fm.model.UserModel;

/**
 * Created by andrewstulii on 16.05.16.
 */
public interface ResponseProcessor {
    UserModel processResponseModel(UserModel model, int mid, int did);
}
