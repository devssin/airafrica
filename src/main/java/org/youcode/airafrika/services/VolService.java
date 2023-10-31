package org.youcode.airafrika.services;

import org.youcode.airafrika.entities.Vol;

import java.text.ParseException;
import java.util.List;

public interface VolService {
    public void addVol(Vol vol, int planId);
    public List<Vol> listVols();
    public List<Vol> SearchVol(String start_city, String arrive_city, String date) throws ParseException;

}
