package org.youcode.airafrika.dao;

import org.youcode.airafrika.entities.Vol;

import java.util.Date;
import java.util.List;

public interface VolDao {
    public void create(Vol vol);
    public List<Vol> listVols();
    public List<Vol> searchVols(String start, String arrive, Date date_start, Date date_end);
    public Vol findById(int id);
    public void update(Vol vol);
    public void delete(int id);
}
