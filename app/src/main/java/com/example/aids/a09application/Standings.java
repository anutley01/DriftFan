package com.example.aids.a09application;

/**
 * Created by Aids on 25/08/2017.
 */

public class Standings {
    /**
     * getters and setters for standings table
     */
    private int driver_id;
    private int team_id;
    private String firstName;
    private String lastName;
    private int position;
    private int points;


    public Standings(int driver_id, int team_id, String  firstName, String lastName, int position, int points) {
//Fields being instantated for pasrsing the files
        this.setDriver_id( driver_id );
        this.setTeam_id( team_id );
        this.setFirstName( firstName );
        this.setLastName( lastName );
        this.setPosition( position );
        this.setPoints( points );

    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}