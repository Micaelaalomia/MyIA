package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DayTime {

    String dateString;
    LocalDateTime date;
    String notes;

    public DayTime(LocalDateTime date, String notes) {
        this.date = date;
        this.notes = notes;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.dateString = dtf.format(date);

    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return dateString;
    }

}
