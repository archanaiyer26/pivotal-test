package io.pivotal.pal.tracker.pivotalarchana;

import java.time.LocalDate;

public class TimeEntry {


    private long  id;
    private long  projectID;

    public TimeEntry(long id, long projectID, long userID, LocalDate localDate, int hours) {
        this.id = id;
        this.projectID = projectID;
        this.userID = userID;
        this.localDate = localDate;
        this.hours = hours;
    }

    private long userID;
    private LocalDate localDate;
    private int hours;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProjectID() {
        return projectID;
    }

    public void setProjectID(long projectID) {
        this.projectID = projectID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }




}
