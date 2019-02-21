package com.smss.api.smssApi.service;

import com.smss.api.smssApi.daos.AuthenticationDAO;
import com.smss.api.smssApi.model.auth.Authentication;
import com.smss.api.system.models.UserAssignedRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthenticationService {
    @Autowired
    private AuthenticationDAO authenticationDao;

    public Authentication findByName(String loginId) throws Exception{
       return authenticationDao.validateAuthentication(loginId);
    }
    public UserAssignedRoles getUserAssignedRoles(int userId,int orgId) throws Exception{
        return authenticationDao.getUserAssignedRoles(userId);
    }
    public UserAssignedRoles getSystemUserAssignedRoles(int userId,int orgId) throws Exception{
        return authenticationDao.getSystemUserAssignedRoles(userId);
    }
    public Authentication findSystemUserPhoto(String loginId) throws Exception{
        return authenticationDao.getSystemUserPhoto(loginId);
    }
    /*public Authentication validateAuthentication(Authentication auth) throws Exception {
        Authentication result = authenticationDao.validateAuthentication(auth);
        return result;
    }*/
   /* public Authentication validateAuthentication(String loginId ) throws Exception {
        Authentication result = authenticationDao.validateAuthentication(loginId);
        return result;
    }*/

}
