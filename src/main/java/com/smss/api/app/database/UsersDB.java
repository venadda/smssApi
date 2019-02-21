package com.smss.api.app.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:database/dev/users.properties"})
@Component
public class UsersDB {

    @Value("${INSERT_ORGANIZATION}")
    private String insertOrganization;
    //@Value("${GET_ALL_ACTIVE_USER}")
    private String allActiveUser;
   // @Value("${GET_ALL_INACTIVE_USER}")
    private String allInactiveUser;

    @Value("${GET_ORG_USER_BY_NAME}")
    private String getOrgUserByName;
    @Value("${GET_ALL_USER}") /* emss get all users */
    private String allUser;
    @Value("${GET_ALL_USER_BY_ROLE}")
    private String allUserByRole;
    @Value("${INSERT_USER}") /* emss insert users */
    private String insertUser;
    @Value("${UPDATE_USER}") /* emss update users */
    private String updateUser;
    @Value("${DELETE_USER}") /* emss delete users */
    private String deleteUser;
    @Value("${GET_USER_BY_ID}") /* emss get user by id */
    private String orgUserById;
    @Value("${GET_ORG_USER_BY_EMAIL_ID}") /* emss get user by email id */
    private String orgUserByEmailId;
    @Value("${GET_ORG_USER_BY_NAME}") /* emss get user by name */
    private String orgUserByName;

    @Value("${INSERT_PHOTO}")
    private String insertUserPhoto;
    @Value("${UPDATE_PHOTO}")
    private String updateUserPhoto;
    @Value("${GET_PHOTO_BY_ID}")
    private String userPhotoById;
    @Value("${DELETE_PHOTO}")
    private String deleteUserPhoto;

    @Value("${GET_ALL_ROLES}")
    private String getAllRoles;
    /*other users generally who visits to web site for demo */

    @Value("${GET_ALL_OTHERS}")
    private String getAllOthers;
    @Value("${INSERT_OTHERS}")
    private String insertOthers;
    @Value("${UPDATE_OTHERS}")
    private String updateOthers;
    @Value("${GET_OTHERS_BY_ID}")
    private String getOthersById;
    @Value("${DELETE_OTHERS}")
    private String deleteOthers;

/* User roles */
    @Value("${USER_ASSIGNED_ROLES_BY_USER_ID}")
    private String UserAssignedRolesByUserId;
    @Value("${GET_ALL_USERS_AND_ROLES}")
    private String allUserAndRoles;
    @Value("${ASSIGN_ROLES_TO_USER}")
    private String assignRolesToUser;
    @Value("${UPDATE_USER_ROLES}")
    private String updateUserAssignedRoles;

/* User Modules */
    @Value("${USER_ASSIGNED_MODULES}")
    private String userAssignedModulesById;
    @Value("${INSERT_USER_MODULE}")
    private String insertUserModule;
    @Value("${UPDATE_USERMODULE}")
    private String updateUserModule;
/* audit */
    @Value("${INSERT_AUDIT}")
    private String insertAudit;
    @Value("${GET_AUDIT_DETAILS_BY_CURRENTDATE}")
    private String auditDetailsByCurrentDate;
    @Value("${GET_AUDIT_DETAILS_BY_DATE}")
    private String auditDetailsByDate;
    @Value("${GET_AUDIT_DETAILS_BY_DATERANGE}")
    private String auditDetailsByDateRange;
/* joining */
    @Value("${INSERT_JOINING}")
    private String insertUserJoiningDetails;
    @Value("${UPDATE_JOINING}")
    private String updateUserJoiningDetails;
    @Value("${DELETE_JOINING}")
    private String deleteUserJoiningDetails;
    @Value("${GET_JOINING_BY_ID}")
    private String userJoiningDetailsById;
    @Value("$(GET_ACTIVE_JOINING_BY_ID)")
    private String userActiveJoiningDetails;
/* training received */
    @Value("${INSERT_TRAINING}")
    private String insertUserTrainingInfo;
    @Value("${UPDATE_TRAINING}")
    private String updateUserTrainingInfo;
    @Value("${DELETE_TRAINING}")
    private String deleteUserTrainingInfo;
    @Value("${GET_TRAINING_BY_ID}")
    private String userTrainingInfoById;

    @Value("${INSERT_HISTORY}")
    private String insertUserHistory;
    @Value("${UPDATE_HISTORY}")
    private String updateUserHistory;
    @Value("${DELETE_HISTORY}")
    private String deleteUserHistory;
    @Value("${GET_HISTORY_BY_ID}")
    private String userHistoryById;
   /* previous history */
    @Value("${OLD_INSERT_HISTORY}")
    private String insertPreviousHistory;
    @Value("${OLD_UPDATE_HISTORY}")
    private String updateUserPreviousHistory;
    @Value("${OLD_DELETE_HISTORY}")
    private String deleteUserPreviousHistory;
    @Value("${OLD_GET_HISTORY_BY_ID}")
    private String userPreviousHistoryById;

    @Value("${INSERT_EDUCATION}")
    private String insertUserEducationInfo;
    @Value("${UPDATE_EDUCATION}")
    private String updateUserEducationInfo;
    @Value("${DELETE_EDUCATION}")
    private String deleteUserEducationInfo;
    @Value("${GET_EDUCATION_BY_ID}")
    private String userEducationInfoById;
/* traing given */
    @Value("${INSERT_TRAINING_GIVEN}")
    private String insertTrainingGiven;
    @Value("${DELETE_TRAINING_GIVEN}")
    private String deleteTrainingGiven;
    @Value("${TRAINING_GIVEN_UPDATE}")
    private String updateTrainingGiven;
    @Value("${TRAINING_GIVEN_GET_BY_ID}")
    private String trainingGevenById;
/* achievements */
    @Value("${INSERT_ACHIEVEMENTS}")
    private String insertAchievements;
    @Value("${DELETE_ACHIEVEMENTS}")
    private String deleteAchievements;
    @Value("${ACHIEVEMENTS_UPDATE}")
    private String updateAchievements;
    @Value("${ACHIEVEMENTS_GET_BY_ID}")
    private String achievementsById;

    @Value("${GET_ALL_GENERICS}")
    private String allgenerics;

    @Value("${INSERT_DISABILITIES}")
    private String insertDisabilities;
    @Value("${UPDATE_DISABILITIES}")
    private String updateDisabilities;
    @Value("${DELETE_DISABILITIES}")
    private String deleteDisabilities;
    @Value("${GET_USER_DISABILITIES_BY_ID}")
    private String userDisabilitiesById;


    public String getInsertOrganization() {
        return insertOrganization;
    }

    public String getAllActiveUser() {
        return allActiveUser;
    }

    public String getAllInactiveUser() {
        return allInactiveUser;
    }


    public String getGetOrgUserByName() {
        return getOrgUserByName;
    }

    public String getAllUser() {
        return allUser;
    }

    public String getInsertUser() {
        return insertUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public String getOrgUserById() {
        return orgUserById;
    }

    public String getOrgUserByEmailId() {
        return orgUserByEmailId;
    }

    public String getOrgUserByName() {
        return orgUserByName;
    }

    public String getInsertUserPhoto() {
        return insertUserPhoto;
    }

    public String getUpdateUserPhoto() {
        return updateUserPhoto;
    }

    public String getUserPhotoById() {
        return userPhotoById;
    }

    public String getDeleteUserPhoto() {
        return deleteUserPhoto;
    }


    public String getGetAllOthers() {
        return getAllOthers;
    }

    public String getInsertOthers() {
        return insertOthers;
    }

    public String getUpdateOthers() {
        return updateOthers;
    }

    public String getGetOthersById() {
        return getOthersById;
    }

    public String getDeleteOthers() {
        return deleteOthers;
    }

    public String getUserAssignedRolesByUserId() {
        return UserAssignedRolesByUserId;
    }

    public String getAllUserAndRoles() {
        return allUserAndRoles;
    }

    public String getAssignRolesToUser() {
        return assignRolesToUser;
    }

    public String getUserAssignedModulesById() {
        return userAssignedModulesById;
    }

    public String getInsertUserModule() {
        return insertUserModule;
    }

    public String getUpdateUserModule() {
        return updateUserModule;
    }

    public String getInsertAudit() {
        return insertAudit;
    }

    public String getAuditDetailsByCurrentDate() {
        return auditDetailsByCurrentDate;
    }

    public String getAuditDetailsByDateRange() {
        return auditDetailsByDateRange;
    }

    public String getAuditDetailsByDate() {
        return auditDetailsByDate;
    }

    public String getInsertUserJoiningDetails() {
        return insertUserJoiningDetails;
    }

    public String getUpdateUserJoiningDetails() {
        return updateUserJoiningDetails;
    }


    public String getDeleteUserJoiningDetails() {
        return deleteUserJoiningDetails;
    }

    public String getUserJoiningDetailsById() {
        return userJoiningDetailsById;
    }

    public String getUserActiveJoiningDetails() {
        return userActiveJoiningDetails;
    }

    public String getInsertUserTrainingInfo() {
        return insertUserTrainingInfo;
    }

    public String getUpdateUserTrainingInfo() {
        return updateUserTrainingInfo;
    }

    public String getDeleteUserTrainingInfo() {
        return deleteUserTrainingInfo;
    }

    public String getUserTrainingInfoById() {
        return userTrainingInfoById;
    }

    public String getInsertUserHistory() {
        return insertUserHistory;
    }

    public String getUpdateUserHistory() {
        return updateUserHistory;
    }

    public String getDeleteUserHistory() {
        return deleteUserHistory;
    }

    public String getUserHistoryById() {
        return userHistoryById;
    }

    public String getInsertPreviousHistory() {
        return insertPreviousHistory;
    }

    public String getUpdateUserPreviousHistory() {
        return updateUserPreviousHistory;
    }

    public String getDeleteUserPreviousHistory() {
        return deleteUserPreviousHistory;
    }

    public String getUserPreviousHistoryById() {
        return userPreviousHistoryById;
    }

    public String getInsertUserEducationInfo() {
        return insertUserEducationInfo;
    }

    public String getUpdateUserEducationInfo() {
        return updateUserEducationInfo;
    }

    public String getDeleteUserEducationInfo() {
        return deleteUserEducationInfo;
    }

    public String getUserEducationInfoById() {
        return userEducationInfoById;
    }

    public String getAllgenerics() {
        return allgenerics;
    }

    public String getAllUserByRole() {
        return allUserByRole;
    }

    public String getGetAllRoles() {
        return getAllRoles;
    }

    public String getUpdateUserAssignedRoles() {
        return updateUserAssignedRoles;
    }

    public String getInsertTrainingGiven() {
        return insertTrainingGiven;
    }

    public String getDeleteTrainingGiven() {
        return deleteTrainingGiven;
    }

    public String getUpdateTrainingGiven() {
        return updateTrainingGiven;
    }

    public String getTrainingGevenById() {
        return trainingGevenById;
    }

    public String getInsertAchievements() {
        return insertAchievements;
    }

    public String getDeleteAchievements() {
        return deleteAchievements;
    }

    public String getUpdateAchievements() {
        return updateAchievements;
    }

    public String getAchievementsById() {
        return achievementsById;
    }

    public String getInsertDisabilities() {
        return insertDisabilities;
    }

    public String getUpdateDisabilities() {
        return updateDisabilities;
    }

    public String getDeleteDisabilities() {
        return deleteDisabilities;
    }

    public String getUserDisabilitiesById() {
        return userDisabilitiesById;
    }
}
