package com.example.gestionrdv.RDVREST;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.sql.Date;
import java.sql.Time;

@Entity
public class DateHour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dateHour;
    private Date date;
    private Time hour;

    public int getId_dateHour() {
        return id_dateHour;
    }
    public void setId_dateHour(int id_dateHour) {
        this.id_dateHour = id_dateHour;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Time getHour(){
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public DateHour() {
    }
    public DateHour(int id_dateHour, Date date, Time hour) {
        this.id_dateHour = id_dateHour;
        this.date = date;
        this.hour = hour;
    }


}
