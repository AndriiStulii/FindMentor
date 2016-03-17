package com.fm.controller;

import com.fm.model.Mentor;
import com.fm.model.Status;
import com.fm.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.fm.model.ValuesStore.*;


/**
 * Created by andrewstulii on 02.03.16.
 */
@RestController
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @RequestMapping(path = "/mentors", method = RequestMethod.GET)
    public Iterable<Mentor> showMentors(){
        return mentorService.selectAllMentors();
    }

    @RequestMapping(path = "/mentors/{id}/book", method = RequestMethod.PATCH)
    public Iterable<Mentor> bookMentor(@PathVariable int id){
        return mentorService.bookMentor(id);
    }

    @RequestMapping(path = "/mentors/{id}/free", method = RequestMethod.PATCH)
    public Iterable<Mentor> freeMentor(@PathVariable int id){
        return mentorService.freeMentor(id);
    }

    @RequestMapping(path = "/mentor", method = RequestMethod.GET)
    public Iterable<Mentor> showMentorsBySelectedParams(
            @RequestParam (required = false, defaultValue = DEFAULT_LANGUAGE)String language,
            @RequestParam (required = false, defaultValue = DEFAULT_EXPERIENCE) int experience,
            @RequestParam (required = false, defaultValue = DEFAULT_COMPANY) String company,
            @RequestParam (required = false, defaultValue = DEFAULT_STATUS) Status status){
        return mentorService.selectMentorsByParams(language, experience, company, status);
    }

}
