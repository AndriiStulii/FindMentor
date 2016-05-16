package com.fm.repo;

import com.fm.entity.Mentor;
import com.fm.entity.Status;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/**
 * Created by andrewstulii on 02.03.16.
 */
@Component
public interface MentorsRepository extends PagingAndSortingRepository<Mentor, Integer> {

    Iterable<Mentor> findMentorsByLanguageAndExperienceIsGreaterThanEqualAndStatusAndCompany(
            String language, int experience, String company, Status status);

    Iterable<Mentor> findMentorsByLanguageAndExperienceIsGreaterThanEqualAndStatus(
            String language, int experience, Status status);

    Iterable<Mentor> findMentorsByExperienceIsGreaterThanEqualAndStatusAndCompany(
            int experience, Status status, String company);

    Iterable<Mentor> findMentorsByExperienceIsGreaterThanEqualAndStatus(
            int experience, Status status);
}
