package com.fm.model;

/**
 * Created by andrewstulii on 02.03.16.
 */
public enum Status {
    FREE("FREE"),
    BOOKED("BOOKED")
    ;

    private final String status;

    Status(final String status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return status;
    }
}
