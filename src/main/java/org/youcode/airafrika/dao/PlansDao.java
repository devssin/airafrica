package org.youcode.airafrika.dao;

import org.youcode.airafrika.entities.Plan;

import java.util.List;

public interface PlansDao {
    public List<Plan> getAllPlans();
    public Plan findById(int id);
}
