package com.fm.controller;

import com.fm.model.Disciple;
import com.fm.service.DiscipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by andrewstulii on 12.03.16.
 */
@RestController
public class DiscipleController {

    @Autowired
    private DiscipleService discipleService;

    @RequestMapping(path = "/disciples", method = RequestMethod.GET)
    public Iterable<Disciple> showDisciples(){
        return discipleService.selectAllDisciples();
    }

    @RequestMapping(path = "mentors/{id}/disciples", method = RequestMethod.GET)
    public Iterable<Disciple> showDisciplesOfMentor(@PathVariable int id){
        return discipleService.selectDisciplesOfMentor(id);
    }

    @RequestMapping(path = "disciples/{id}/accept", method = RequestMethod.POST)
    public String acceptDisciple(@PathVariable int id,
                                 @RequestParam(required = true) int mId){
        discipleService.acceptDisciple(mId, id);
        return "Disciple was accepted by Mentor";
    }

    @RequestMapping(path = "disciples/{id}/decline", method = RequestMethod.POST)
    public String declineDisciple(@PathVariable int id,
                                 @RequestParam(required = true) int mId){
        discipleService.declineDisciple(mId, id);
        return "Disciple was declined by Mentor";
    }
}
