package com.fm.model;

import java.util.function.Predicate;

/**
 * Created by andrewstulii on 27.03.16.
 */
public class Connection {

    private int discipleId;
    private int mentorId;
    private boolean agreement;

    public Connection(int discipleId, int mentorId, boolean agreement) {
        this.discipleId = discipleId;
        this.mentorId = mentorId;
        this.agreement = agreement;
    }

    public int getDiscipleId() {
        return discipleId;
    }

    public void setDiscipleId(int discipleId) {
        this.discipleId = discipleId;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public boolean isAgreement() {
        return agreement;
    }

    public void setAgreement(boolean agreement) {
        this.agreement = agreement;
    }

    public static Connection findConnectionWithIds(int discipleId, int mentorId){
        Connection resultingConnection = null;
        for (Connection connection : ValuesStore.MENTORS_AND_DISCIPLES_CONNECTIONS){
            if (connection.getDiscipleId() == discipleId && connection.getMentorId() == mentorId){
                resultingConnection = connection;
            }
        }
        return resultingConnection;
    }
}
