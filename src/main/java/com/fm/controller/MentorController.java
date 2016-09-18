package com.fm.controller;

import com.fm.entity.Mentor;
import com.fm.entity.Status;
import com.fm.model.MentorModel;
import com.fm.processor.MentorHypermediaProcessor;
import com.fm.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.fm.model.ValuesStore.*;


/**
 * Created by andrewstulii on 02.03.16.
 */
@RestController
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @Autowired
    private MentorHypermediaProcessor hypermediaProcessor;

    @RequestMapping(path = "/mentors", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Mentor>> showMentors(@RequestParam(required = true) int dId) {
        Iterable<Mentor> mentors = mentorService.selectAllMentors();
        mentors.forEach(mentor -> hypermediaProcessor.processResponseModel(new MentorModel(mentor), mentor.getId(), dId));
        return new ResponseEntity<>(mentorService.selectAllMentors(), HttpStatus.OK);
    }

    @RequestMapping(path = "/mentors/{id}/book", method = RequestMethod.POST)
    public ResponseEntity<String> bookMentor(@PathVariable int id,
                                             @RequestParam(required = true) int dId) {
        mentorService.bookMentor(id, dId);
        return new ResponseEntity<>("Booking request was send", HttpStatus.OK);
    }

    @RequestMapping(path = "/mentors/{id}/free", method = RequestMethod.POST)
    public ResponseEntity<String> freeMentor(@PathVariable int id,
                                             @RequestParam(required = true) int dId) {
        mentorService.freeMentor(id, dId);
        return new ResponseEntity<>("Booking request was removed", HttpStatus.OK);
    }

    @RequestMapping(path = "/mentor", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Mentor>> showMentorsBySelectedParams(
            @RequestParam(required = true) int dId,
            @RequestParam(required = false, defaultValue = DEFAULT_LANGUAGE) String language,
            @RequestParam(required = false, defaultValue = DEFAULT_EXPERIENCE) int experience,
            @RequestParam(required = false, defaultValue = DEFAULT_COMPANY) String company,
            @RequestParam(required = false, defaultValue = DEFAULT_STATUS) Status status) {
        Iterable<Mentor> mentors = mentorService.selectMentorsByParams(language, experience, company, status);
        mentors.forEach(mentor -> hypermediaProcessor.processResponseModel(new MentorModel(mentor), mentor.getId(), dId));
        return new ResponseEntity<>(mentors, HttpStatus.OK);
    }

}
