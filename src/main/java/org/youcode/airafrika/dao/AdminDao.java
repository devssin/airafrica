package org.youcode.airafrika.dao;

import org.youcode.airafrika.entities.Admin;

public interface AdminDao {
    public Admin findAdminByUsername(String username);
}
