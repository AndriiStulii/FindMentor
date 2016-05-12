package com.fm.service;

import com.fm.model.Connection;
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

    public void bookMentor(int idMentor, int idDisciple){
        MENTORS_AND_DISCIPLES_CONNECTIONS.add(new Connection(idDisciple, idMentor, false));
    }

    public void freeMentor(int idMentor, int idDisciple){
        Connection connectionToRemove = Connection.findConnectionWithIds(idDisciple, idMentor);
        if (connectionToRemove != null){
            MENTORS_AND_DISCIPLES_CONNECTIONS.remove(connectionToRemove);
        }

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
