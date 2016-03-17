package com.fm.service;

import com.fm.model.Mentor;
import com.fm.model.Status;
import com.fm.repo.MentorsRepository;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.fm.model.ValuesStore.*;

/**
 * Created by andrewstulii on 03.03.16.
 */
@Component
public class MentorService implements UserService {

    @Autowired
    private MentorsRepository repository;

    public Iterable<Mentor> selectAllMentors(){
        return repository.findAll();
    }

    public Iterable<Mentor> bookMentor(int id){
        Mentor currentMentor = repository.findOne(id);
        if (currentMentor.getStatus().equals(Status.FREE)){
            currentMentor.setStatus(Status.BOOKED);
            repository.save(currentMentor);
        }
        return selectMentorsByParams(
                DEFAULT_LANGUAGE, Integer.valueOf(DEFAULT_EXPERIENCE), DEFAULT_COMPANY, Status.BOOKED);
    }

    public Iterable<Mentor> freeMentor(int id){
        Mentor currentMentor = repository.findOne(id);
        if (currentMentor.getStatus().equals(Status.BOOKED)){
            currentMentor.setStatus(Status.FREE);
            repository.save(currentMentor);
        }
        return selectMentorsByParams(
                DEFAULT_LANGUAGE, Integer.valueOf(DEFAULT_EXPERIENCE), DEFAULT_COMPANY, Status.FREE);
    }

    public Iterable<Mentor> selectMentorsByParams(String language, int experience, String company, Status status){

        boolean languageUnSpecified = Strings.isNullOrEmpty(language);
        boolean companyUnSpecified = Strings.isNullOrEmpty(company);

        if (languageUnSpecified && companyUnSpecified){
            return repository.findMentorsByExperienceIsGreaterThanEqualAndStatus(
                    experience , status);
        }else if (!languageUnSpecified && companyUnSpecified){
            return repository.findMentorsByLanguageAndExperienceIsGreaterThanEqualAndStatus(
                    language, experience, status);
        }else if (languageUnSpecified && !companyUnSpecified){
            return repository.findMentorsByExperienceIsGreaterThanEqualAndStatusAndCompany(
                    experience, status, company);
        }else {
            return repository.findMentorsByLanguageAndExperienceIsGreaterThanEqualAndStatusAndCompany(
                    language, experience, company, status);
        }
    }

}
