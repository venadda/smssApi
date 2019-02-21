package com.smss.api.app.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:database/dev/authentication.properties"})
@Component
public class AuthenticationDB {

    @Value("${ADD_AUTHORIZATION}")
    private String addAuthentication;
    @Value("${VALIDATE_AUTHORIZATION}")
    private String isAuthenticationValidate;

    @Value("${GETSYSTEMUSERPHOTO}")
    private String systemUserPhoto;
    @Value("${GETALLSYSTEMUSERS}")
    private String getAllSystemUsers;
    @Value("${GETALLSYSTEMUSERDETAILS}")
    private String getAllSystemUserDetails;
    @Value("${GETSYSTEMUSERROLES}")
    private String systemUserRoles;

    @Value("${GETUSERASSIGNEDMODULE}")
    private String getUserAssignedModules;

    @Value("${GETUSERROLES}")
    private String getUserRoles;
    @Value("${GETUSERPHOTO}")
    private String userPhoto;
    @Value("${GETALLUSERDETAILS}")
    private String allUserDetails;

    @Value("${GETALLBRANCHUSERDETAILS}")
    private String allBranchUserDetails;

    @Value("${INSERTUSER}")
    private String insertUser;
    @Value("${UPDATEUSER}")
    private String updateUser;
    @Value("${UPDATEBRANCHUSER}")
    private String updateBranchUser;

    @Value("${INSERTUSERROLES}")
    private String insertUserRoles;
    @Value("${UPDATEUSERROLE}")
    private String updateUserRole;

    @Value("${GET_ORG_AUTHORIZATION_USERS}")
    private String orgAuthorizedUsers;
    @Value("${GET_ALL_AUTHORIZATION_USERS}")
    private String allOrgAuthorizedUsers;

    @Value("${ADD_PARENT}")
    private String addParent;
    @Value("${GET_PARENT}")
    private String parentList;
    @Value("${GET_PARENT_BY_ID}")
    private String parentById;
    @Value("${GET_PARENT_BY_NAME}")
    private String parentByName;
    @Value("${GET_PARENT_BY_NAME_LIKE}")
    private String parentByNameLike;
    @Value("${GET_PARENT_BY_EMAIL_ID_IGNORECASE}")
    private String parentByEmailIdIgnoreCase;
    @Value("${ADD_PARENT_STUD}")
    private String addParentStud;
    @Value("${GET_PARENT_STUD_BY_ID}")
    private String parentStudById;
    @Value("${ADD_OTHER}")
    private String addOther;
    @Value("${GET_OTHER}")
    private String otherList;
    @Value("${GET_OTHER_BY_ID}")
    private String otherById;
    @Value("${GET_OTHER_BY_NAME}")
    private String otherByName;
    @Value("${GET_OTHER_BY_NAME_LIKE}")
    private String otherByNameLike;
    @Value("${GET_OTHER_BY_EMAIL_ID_IGNORECASE}")
    private String otherByEmailIdIgnreCase;

    public AuthenticationDB() {
    }


    public String getAddAuthentication() {
        return addAuthentication;
    }

    public String getIsAuthenticationValidate() {
        return isAuthenticationValidate;
    }

    public String getGetUserRoles(){
        return getUserRoles;
    }

    public String getGetAllSystemUsers() {
        return getAllSystemUsers;
    }

    public String getGetAllSystemUserDetails() {
        return getAllSystemUserDetails;
    }

    public String getOrgAuthorizedUsers() {
        return orgAuthorizedUsers;
    }

    public String getAllOrgAuthorizedUsers() {
        return allOrgAuthorizedUsers;
    }

    public String getAddParent() {
        return addParent;
    }

    public String getParentList() {
        return parentList;
    }

    public String getParentById() {
        return parentById;
    }

    public String getParentByName() {
        return parentByName;
    }

    public String getParentByNameLike() {
        return parentByNameLike;
    }

    public String getParentByEmailIdIgnoreCase() {
        return parentByEmailIdIgnoreCase;
    }

    public String getAddParentStud() {
        return addParentStud;
    }

    public String getParentStudById() {
        return parentStudById;
    }

    public String getAddOther() {
        return addOther;
    }

    public String getOtherList() {
        return otherList;
    }

    public String getOtherById() {
        return otherById;
    }

    public String getOtherByName() {
        return otherByName;
    }

    public String getOtherByNameLike() {
        return otherByNameLike;
    }

    public String getOtherByEmailIdIgnreCase() {
        return otherByEmailIdIgnreCase;
    }

    public String getGetUserAssignedModules() {
        return getUserAssignedModules;
    }

    public String getSystemUserPhoto() {
        return systemUserPhoto;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public String getSystemUserRoles() {
        return systemUserRoles;
    }

    public String getAllUserDetails() {
        return allUserDetails;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public String getInsertUserRoles() {
        return insertUserRoles;
    }

    public String getUpdateUserRole() {
        return updateUserRole;
    }

    public String getAllBranchUserDetails() {
        return allBranchUserDetails;
    }

    public String getUpdateBranchUser() {
        return updateBranchUser;
    }
}
