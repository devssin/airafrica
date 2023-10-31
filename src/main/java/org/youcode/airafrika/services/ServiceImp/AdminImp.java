package org.youcode.airafrika.services.ServiceImp;

import org.mindrot.jbcrypt.BCrypt;
import org.youcode.airafrika.dao.AdminDao;
import org.youcode.airafrika.dao.implementation.AdminDaoImp;
import org.youcode.airafrika.entities.Admin;
import org.youcode.airafrika.services.AdminService;

public class AdminImp implements AdminService {


    @Override
    public boolean authenticate(String username, String password) {
        AdminDao adminDao = new AdminDaoImp();
        Admin admin = adminDao.findAdminByUsername(username);
        return admin != null &&  BCrypt.checkpw(password, admin.getPassword());
    }
}
