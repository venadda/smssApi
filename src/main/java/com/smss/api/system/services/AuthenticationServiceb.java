package com.smss.api.system.services;


import com.smss.api.smssApi.model.auth.Authentication;
import com.smss.api.system.daos.AuthenticationbDAO;
import com.smss.api.system.models.Others;
import com.smss.api.system.models.ParentStudent;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationServiceb {
    @Autowired
    private AuthenticationbDAO authenticationDao;


    public List<Authentication> getAuthenticatedUsers(long oid) throws SQLException {
        return authenticationDao.getAuthenticatedUsers(oid);
    }


    public List<Authentication> getAllOrgAuthenticatedUsers() throws SQLException {
        return authenticationDao.getAllOrgAuthenticatedUsers();
    }


    public Optional<Authentication> validateAuthentication(Authentication auth) throws SQLException {
        /*Optional<Authentication> result = authenticationDao.validateAuthentication(auth);
        result
                .orElseThrow(()->new Exception(" user not found"));

        result
            .ifPresent(Authentication -> {new Authentication(result)});
        return new Authentication(result);*/
        return null;
    }


    public List<Authentication> addAuthenticatedUser(Authentication user) throws SQLException {
        return null;
    }
/*
    public List<Parent> addParent(Parent parent) throws SQLException {
        return null;
    }


    public List<Parent> parentList(long oid) throws SQLException {
        return null;
    }


    public List<Parent> parentById(long oid, long pid) throws SQLException {
        return null;
    }


    public List<Parent> parentByName(long oid, String name) throws SQLException {
        return null;
    }


    public List<Parent> parentByNameLike(long oid, String name) throws SQLException {
        return null;
    }


    public List<Parent> parentByEmailIdIgnoreCase(long oid, String email) throws SQLException {
        return null;
    }


    public List<ParentStudent> addParentStud(ParentStudent parentstudent) throws SQLException {
        return null;
    }


    public List<ParentStudent> parentStudById(long pid) throws SQLException {
        return null;
    }


    public List<Others> addOther(Others others) throws SQLException {
        return null;
    }


    public List<Others> otherList(long oid) throws SQLException {
        return null;
    }


    public List<Others> otherById(long oid, long id) throws SQLException {
        return null;
    }


    public List<Others> otherByName(long oid, String name) throws SQLException {
        return null;
    }


    public List<Others> otherByNameLike(long oid, String name) throws SQLException {
        return null;
    }


    public List<Others> otherByEmailIdIgnreCase(long oid, String name) throws SQLException {
        return null;
    }
*/
}
