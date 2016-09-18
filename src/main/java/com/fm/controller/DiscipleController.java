package com.fm.controller;

import com.fm.entity.Disciple;
import com.fm.model.DiscipleModel;
import com.fm.processor.DiscipleHypermediaProcessor;
import com.fm.service.DiscipleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by andrewstulii on 12.03.16.
 */
@RestController
public class DiscipleController {

    @Autowired
    private DiscipleService discipleService;

    @Autowired
    private DiscipleHypermediaProcessor hypermediaProcessor;

    @RequestMapping(path = "/disciples", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Disciple>> showDisciples(@RequestParam(required = true) int mId) {
        Iterable<Disciple> disciples = discipleService.selectAllDisciples();
        disciples.forEach(disciple -> hypermediaProcessor.processResponseModel(new DiscipleModel(disciple), disciple.getId(), mId));
        return new ResponseEntity<>(discipleService.selectAllDisciples(), HttpStatus.OK);
    }

    @RequestMapping(path = "mentors/{id}/disciples", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Disciple>> showDisciplesOfMentor(@PathVariable int id) {
        Iterable<Disciple> disciples = discipleService.selectDisciplesOfMentor(id);
        disciples.forEach(disciple -> hypermediaProcessor.processResponseModel(new DiscipleModel(disciple), disciple.getId(), id));
        return new ResponseEntity<>(discipleService.selectDisciplesOfMentor(id), HttpStatus.OK);
    }

    @RequestMapping(path = "disciples/{id}/accept", method = RequestMethod.POST)
    public ResponseEntity<String> acceptDisciple(@PathVariable int id,
                                                 @RequestParam(required = true) int mId) {
        discipleService.acceptDisciple(mId, id);
        return new ResponseEntity<>("Disciple was accepted by Mentor", HttpStatus.OK);
    }

    @RequestMapping(path = "disciples/{id}/decline", method = RequestMethod.POST)
    public ResponseEntity<String> declineDisciple(@PathVariable int id,
                                                  @RequestParam(required = true) int mId) {
        discipleService.declineDisciple(mId, id);
        return new ResponseEntity<>("Disciple was declined by Mentor", HttpStatus.OK);
    }
}
