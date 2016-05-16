package com.fm.service;

import com.fm.model.Connection;
import com.fm.entity.Disciple;
import com.fm.entity.Mentor;
import com.fm.entity.Status;
import com.fm.repo.DisciplesRepository;
import com.fm.repo.MentorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.fm.model.ValuesStore.MENTORS_AND_DISCIPLES_CONNECTIONS;

/**
 * Created by andrewstulii on 12.03.16.
 */
@Component
public class DiscipleService implements UserService {

    @Autowired
    private DisciplesRepository disciplesRepository;

    @Autowired
    private MentorsRepository mentorsRepository;

    public Iterable<Disciple> selectAllDisciples() {
        return disciplesRepository.findAll();
    }

    public Iterable<Disciple> selectDisciplesOfMentor(int id){
        List<Connection> connections = MENTORS_AND_DISCIPLES_CONNECTIONS.stream().filter(connection -> connection.getMentorId() == id).collect(Collectors.toList());
        return connections.stream().map(connection -> disciplesRepository.findOne(connection.getDiscipleId())).collect(Collectors.toList());
    }

    public void acceptDisciple(int idMentor, int idDisciple){
        Connection connectionToAccept = Connection.findConnectionWithIds(idDisciple, idMentor);
        if (connectionToAccept != null){
            connectionToAccept.setAgreement(true);
            MENTORS_AND_DISCIPLES_CONNECTIONS.add(connectionToAccept);

            updateDiscipleWithCurrentMentor(bookCurrentMentor(idMentor), idDisciple);
        }
    }

    public void declineDisciple(int idMentor, int idDisciple){
        Connection connectionToRemove = Connection.findConnectionWithIds(idDisciple, idMentor);
        if (connectionToRemove != null){
            MENTORS_AND_DISCIPLES_CONNECTIONS.remove(connectionToRemove);
        }

    }

    private Mentor bookCurrentMentor(int idMentor){
        Mentor currentMentor = mentorsRepository.findOne(idMentor);
        currentMentor.setStatus(Status.BOOKED);
        mentorsRepository.save(currentMentor);
        return currentMentor;
    }

    private Disciple updateDiscipleWithCurrentMentor(Mentor currentMentor, int idDisciple){
        Disciple currentDisciple = disciplesRepository.findOne(idDisciple);
        currentDisciple.setMentor(currentMentor);
        disciplesRepository.save(currentDisciple);
        return currentDisciple;
    }
}
