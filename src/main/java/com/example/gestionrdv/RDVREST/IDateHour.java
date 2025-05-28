package com.example.gestionrdv.RDVREST;

import com.example.gestionrdv.RDVREST.DateHour;

import java.util.List;

public interface IDateHour {


    public List<DateHour> gelallDateHours();
    public DateHour saveDateHour(DateHour DateHour);
    public DateHour deleteDateHour(int id);
    public DateHour updateDateHour(DateHour DateHour);
    public DateHour getDateHourById(int id);

}
