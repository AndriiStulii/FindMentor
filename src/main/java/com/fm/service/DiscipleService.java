package com.fm.service;

import com.fm.model.Disciple;
import com.fm.repo.DisciplesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by andrewstulii on 12.03.16.
 */
@Component
public class DiscipleService implements UserService {

    @Autowired
    private DisciplesRepository repository;

    public Iterable<Disciple> selectAllDisciples() {
        return repository.findAll();
    }
}
