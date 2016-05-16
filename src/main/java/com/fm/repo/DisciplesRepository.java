package com.fm.repo;

import com.fm.entity.Disciple;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by andrewstulii on 12.03.16.
 */
public interface DisciplesRepository extends PagingAndSortingRepository<Disciple, Integer> {
}
