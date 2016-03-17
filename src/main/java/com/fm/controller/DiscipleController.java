package com.fm.controller;

import com.fm.model.Disciple;
import com.fm.service.DiscipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrewstulii on 12.03.16.
 */
@RestController
public class DiscipleController {

    @Autowired
    private DiscipleService discipleService;

    @RequestMapping(path = "/disciples", method = RequestMethod.GET)
    public Iterable<Disciple> showMentors(){
        return discipleService.selectAllDisciples();
    }
}
