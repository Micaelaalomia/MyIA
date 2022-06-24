package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DayTime {

    LocalDateTime date;
    String notes;

    public DayTime(LocalDateTime date, String notes) {
        this.date = date;
        this.notes = notes;
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
       // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return dtf.format(date);
    }
}
