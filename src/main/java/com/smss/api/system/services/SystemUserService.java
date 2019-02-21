package com.smss.api.system.services;

import com.smss.api.system.daos.SystemUserDao;
import com.smss.api.system.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserService {
    @Autowired
    private SystemUserDao systemUserDao;

    public List<SystemUser> getSystemUsers(){
        return systemUserDao.getSystemUsers();
    }

    public List<SystemUserDetails> getSystemUserDetails() throws Exception{
        return systemUserDao.getSystemUserDetails();
    }
    public List<EmployeeDetails> getAllUserDetails(SystemUserDetails userdetails) throws Exception{
        return systemUserDao.getUserDetails(userdetails);
    }
    public List<Employee> getAllBranchUserDetails(Employee emp) throws Exception{
        return systemUserDao.getBranchUserDetails(emp);
    }
    public List<Employee> getInsertBranchUserDetails(Employee emp) throws Exception {
        return systemUserDao.getInsertBranchUserDetails(emp);
    }
    public List<EmployeeDetails> getUpdateUserDetails(Employee emp) throws Exception {
        return systemUserDao.getUpdateUserDetails(emp);
    }

    public List<EmployeeDetails> getUpdateBranchUserDetails(Employee emp) throws Exception{
        return systemUserDao.getBranchUpdateUserDetails(emp);
    }
    public List<Employee> getInsertUserDetails(Employee emp) throws Exception{
        return systemUserDao.getInsertUserDetails(emp);
    }

    public List<SystemUserModules> getUserAssignedModules(int userId) throws Exception{
        return systemUserDao.getUserAssignedModules(userId);
    }

}
