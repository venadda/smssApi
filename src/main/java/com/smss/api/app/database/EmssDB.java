package com.smss.api.app.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:database/dev/emss.properties"})
@Component
public class EmssDB {
    @Value("${ADMISSION_YEAR_INSERT}")
    private String admissionYearInsert;
    @Value("${ADMISSION_YEAR_UPDATE}")
    private String admissionYearUpdate;
    @Value("${ADMISSION_YEAR_DELETE}")
    private String admissionYearDelete;
    @Value("${ADMISSION_YEAR_GET_ACTIVE_YEAR}")
    private String admissionYearGetActiveYear;
    @Value("${ADMISSION_YEAR_GET_ALL}")
    private String admissionYearGetAll;

    @Value("${ENROLLMENT_INSERT}")
    private String insertStudentEnrollment;
    @Value("${ENROLLMENT_DELETE}")
    private String deleteEnrolledStudent;
    @Value("${ENROLLMENT_UPDATE}")
    private String updateStudentEnrolled;
    @Value("${GET_ENROLLED_STUDENT}")
    private String enrolledStudentList;
    @Value("${GET_ENROLLED_STUDENT_BY_COURSE}")
    private String enrolledStudentByCourse;
    @Value("${GET_ENROLLED_STUDENT_BY_ID}")
    private String enrolledStudentById;


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

   /* @Value("${INSERTUSER}")
    private String insertUser;
    @Value("${UPDATEUSER}")
    private String updateUser;*/
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
    @Value("${STDACADHISTORY_INSERT_1}")
    private String insertStudentAcademicHistory;
    @Value("${STDACADHISTORY_UPDATE_1}")
    private String updateStudentAcademicHistory;
    @Value("${STDACADHISTORY_DELETE}")
     private String deleteStudentAcademicHistory;
    @Value("${STDACADHISTORY_BY_ID}")
    private String studentAcademicHistoryById;
    @Value("${STDCLSSEC_INSERT}")
    private String insertStudentClassSection;
    @Value("${STDCLSSEC_UPDATE}")
    private String updateStudentClassSection;
    @Value("${STDCLSSEC_DELETE}")
    private String deleteStudentClassSection;
    @Value("${STD_CLSSEC_GET_ID}")
    private String studentClassSectionById;
    @Value("${PARENT_INSERT}")
    private String insertParent;
    @Value("${PARENT_UPDATE_1}")
    private String updateParent;
    @Value("${STUDENT_INSERT}")
    private String insertStudent;
    @Value("${STUDENT_UPDATE}")
    private String updateStudent;
    @Value("${STUDENT_DELETE}")
    private String deleteStudent;
    @Value("${STUDENT_PARENT_BY_CLASS}")
    private String studentByClass;
    @Value("${STUDENTS_LIST_BY_CLASS}")
    private String studentsListByClass;
    @Value("${STIDENT_COUNT_BY_CLASSES}")
    private String studentCountByClasses;
    @Value("${PARENT_SEARCH_NAME_CONTACT}")
    private String parentSearchByNameAndContact;


    @Value("${INSERT_ORGANIZATION}")
    private String insertOrganization;
    @Value("${UPDATE_ORGANIZATION}")
    private String updateOrganization;
    @Value("${DELETE_ORGANIZATION}")
    private String deleteOrganization;
    @Value("${ACTIVE_ORGANIZATION}")
    private String getActiveOrganization;
    @Value("${ALL_ORGANIZATION}")
    private String getAllOrganization;
    @Value("${GET_ORGANIZATION_BY_ID}")
    private String getOrganizationById;

    @Value("$(GET_AUDIT_DETAILS_BY_ORG}")
    private String auditDetailsByOrg;
    @Value("$(GET_AUDIT_DETAILS_BY_USER}")
    private String auditDetailsByUser;

    @Value("${BRANCH_INSERT}")
    private String branchInsert;
    @Value("${BRANCH_DELETE}")
    private String branchDelete;
    @Value("${BRANCH_UPDATE}")
    private String branchUpdate;
    @Value("${GET_ACTIVE_BRANCH}")
    private String getActiveBranch;
    @Value("${GET_ALL_BRANCH}")
    private String getAllBranch;
    @Value("${GET_BRANCH_BY_ID}")
    private String getBranchById;


    @Value("${ACTIVE_DEPARTMENT}")
    private String activeDepartment;
    @Value("${NON_ACTIVE_DEPARTMENT}")
    private String nonActiveDepartment;
    @Value("${ALL_ORG_DEPARTMENT}")
    private String allOrgDepartment;
    @Value("${INSERT_ORG_DEPARTMENT}")
    private String insertOrgDepartment;
    @Value("${UPDATE_ORG_DEPARTMENT}")
    private String updateOrgDepartment;
    @Value("${DELETE_ORG_DEPARTMENT}")
    private String deleteOrgDepartment;
    @Value("${DEPARTMENT_GET_BY_ID}")
    private String departmentGetById;
    @Value("${DEPARTMENT_GET_BY_NAME}")
    private String departmentGetByName;
    @Value("${ACTIVE_DESIGNATION}")
    private String activeDesignation;
    @Value("${NON_ACTIVE_DESIGNATION}")
    private String nonActiveDesignation;
    @Value("${ALL_ORG_DESIGNATION}")
    private String allOrgDesignation;
    @Value("${INSERT_ORG_DESIGNATION}")
    private String insertOrgDesignation;
    @Value("${UPDATE_ORG_DESIGNATION}")
    private String updateOrgDesignation;
    @Value("${DELETE_ORG_DESIGNATION}")
    private String deleteOrgDesignation;
    @Value("${DESIGNATION_GET_BY_ID}")
    private String designationGetById;
    @Value("${DESIGNATION_GET_BY_NAME}")
    private String designationGetByName;


    @Value("${INSERT_BATCH}")
    private String insertBatch;
    @Value("${UPDATE_BATCH}")
    private String updateBatch;
    @Value("${DELETE_BATCH}")
    private String deleteBatch;
    @Value("${GET_BATCH_BY_NAME}")
    private String batchByName;
    @Value("${GET_BATCH_BY_ID}")
    private String batchById;
    @Value("${GET_BATCH_BY_ORGID}")
    private String batchByOrgId;
    @Value("${GET_ACTIVE_BATCH}")
    private String activeBatches;
    @Value("${GET_BATCH_BY_YEAR}")
    private String batchByYear;
    @Value("${GET_ACTIVE_AY_BRANCH_CLASSES}")
    private String activeAyBranchClasses;
    @Value("${INSERT_LEVEL}")
    private String insertCourseLevel;
    @Value("${COURSE_LEVEL_UPDATE}")
    private String updateCourseLevel;



    @Value("${GET_COURSE_LEVEL_BY_COUNTRY}")
    private String courseLevelByCounrty;

    @Value("${GET_COURSE_LEVEL_BY_GROUP}")
    private String courseLevelByGroup;
    @Value("${GET_COURSE_LEVEL_BY_TITLE}")
    private String courseLevelByTitle;
    @Value("${GET_COURSECATEGORIES}")
    private String courseCategories;
    @Value("${INSERT_COURSECATEGORY}")
    private String insertCourseCategories;
    @Value("${UPDATE_COURSECATEGORY}")
    private String updateCourseCategory;

    @Value("${INSER_COURSE_STUDY}")
    private String insertCourseStudy;
    @Value("${UPDATE_COURSE_STUDY}")
    private String updateCourseStudy;
    @Value("${GET_COURSE_STUDY_BY_CC_CL}")
    private String courseStudyByCcCl;
    @Value("${GET_COURSE_STUDY_BY_CC}")
    private String courseStudyByCc;
    @Value("${GET_COURSE_STUDY_BY_ID}")
    private String courseStudyById;

    @Value("${INSERT_COURSE_CLASS}")
    private String insertCourseClass;
    @Value("${UPDATE_COURSE_CLASS}")
    private String updateCourseClass;
    @Value("${DELETE_COURSE_CLASS}")
    private String deleteCourseClass;
    @Value("${GET_COURSE_CLASS_ID}")
    private String courseClassId;
    @Value("${GET_COURSE_CLASS_STUDY}")
    private String courseClassByStudyCode;

    @Value("${GET_BRANCH_COURSE_CLASS_ID}")
    private String branchCourseClassById;
    @Value("${GET_TERM_MAP_TERM_FEE}")
    private String termMapTermFee;
    @Value("${INSERT_COURSE_SUBJECT}")
    private String insertCourseSubject;
    @Value("${UPDATE_COURSE_SUBJECT}")
    private String updateCourseSubject;
    @Value("${GET_COURSE_SUBJECT_ID}")
    private String courseSubjectId;
    @Value("${GET_COURSE_SUBJECT_CLS_ID}")
    private String courseSubjectClsId;
    @Value("${GET_COURSE_CLASS_SUBJECTS}")
    private String courseClassSubjects;

    @Value("${INSERT_BRANCH_CLASSES}")
    private String insertOrgClasses;
    @Value("${UPDATE_BRANCH_CLASSES}")
    private String updateOrgClasses;
    @Value("${GET_BRANCH_CLASSES}")
    private String orgClasses;
    @Value("${GET_BRANCH_CLASSES_BY_CLS}")
    private String orgClassesByCls;

    @Value("${INSERT_CLASS_SUBJECT}")
    private String insertClassSubject;
    @Value("${UPDATE_CLASS_SUBJECT}")
    private String updateClassSubject;
    @Value("${GET_CLASS_SUBJECT}")
    private String classSubject;



    @Value("${INSERT_STUDYBRANCH}")
    private String insertStudyBranch;
    @Value("${DELETE_STUDYBRANCH}")
    private String deleteStudyBranch;
    @Value("${GET_STUDYBRANCH_LIST}")
    private String studyBranchList;

    @Value("${INSERT_DISTRICT}")
    private String insertDistrict;
    @Value("${UPDATE_DISTRICT}")
    private String updateDistrict;

    @Value("${DELETE_DISTRICT}")
    private String deleteDistrict;
    @Value("${GET_DISTRICT_BY_ID}")
    private String districtById;
    @Value("${GET_DISTRICT_BY_NAME}")
    private String districtByName;
    @Value("${GET_DISTRICT_BY_STATE}")
    private String districtByState;
    @Value("${INSERT_MANDAL}")
    private String insertMandal;
    @Value("${UPDATE_MANDAL}")
    private String updateMandal;


    @Value("${DELETE_MANDAL}")
    private String deleteMandal;
    @Value("${GET_MANDAL_BY_ID}")
    private String mandalById;
    @Value("${GET_MANDAL_BY_NAME}")
    private String mandalByName;
    @Value("${GET_MANDAL_BY_DISTRICT}")
    private String mandalByDistrict;
    @Value("${INSERT_ZONE}")
    private String insertZone;
    @Value("${UPDATE_ZONE}")
    private String updateZone;
    @Value("${DELETE_ZONE}")
    private String deleteZone;
    @Value("${GET_ZONE_BY_ID}")
    private String zoneById;
    @Value("${GET_ZONE_BY_NAME}")
    private String zoneByName;
    @Value("${GET_ZONE_BY_STATE}")
    private String zoneByState;
    @Value("${INSERT_CATEGORY}")
    private String insertCategory;
    @Value("${UPDATE_CATEGORY}")
    private String updateCategory;
    @Value("${DELETE_CATEGORY}")
    private String deleteCategory;
    @Value("${GET_CATEGORY_BY_NAME}")
    private String categoryByName;
    @Value("${GET_CATEGORIES}")
    private String categories;


    @Value("${INSERT_AY}")
    private String insertAcademicYear;
    @Value("${UPDATE_AY}")
    private String updateAcademicYear;
    @Value("${DELETE_AY}")
    private String deleteAcademicYear;
    @Value("${GET_AY_BY_ORG_ID}")
    private String academicYearByOrgId;

    @Value("${GET_AY_BY_ID}")
    private String academicYearById;
    @Value("${GET_AY_BY_BATCH_ID}")
    private String academicYearByBatch;
    @Value("${GET_AY_BY_YEAR}")
    private String academicYearByYear;
    @Value("${GET_AY_BY_COURSELEVEL}")
    private String academicYearByCourse;
    @Value("${GET_ALL_AY}")
    private String academicYear;


    @Value("${INSERT_COURSES}")
    private String insertCourses;
    @Value("${UPDATE_COURSES}")
    private String updateCourses;
    @Value("${DELETE_COURSES}")
    private String deleteCourses;
    @Value("${GET_COURSES_BY_ID}")
    private String coursesById;
    @Value("${GET_COURSES_BY_TITLE}")
    private String coursesByTitle;
    @Value("${GET_COURSES_BY_STITLE}")
    private String coursesByStitle;
    @Value("${GET_COURSES_BY_CLEVEL}")
    private String coursesByCourseLevel;
    @Value("${GET_COURSES_BY_BRANCH}")
    private String coursesByBranch;

    @Value("${GET_ACTIVE_ADMISSION_YEAR}")
    private String aciveAdmissionYear;
    @Value("${GET_ALL_ACTIVE_AY}")
    private String allActiveAcademicYear;
    @Value("${INSERT_DESIGNCAT}")
    private String insertDesignationCategory;
    @Value("${DELETE_DESIGNCAT}")
    private String updateDesignationCategory;
    @Value("${UPDATE_DESIGNCAT}")
    private String deleteDesignationCategory;
    @Value("${GET_ACTIVE_DESIGNCAT}")
    private String activeDesignationCategory;
    @Value("${GET_ALL_DESIGNCAT}")
    private String listDesignationCategory;

    @Value("${GET_STUDENT_BY_ID}")
    private String studentById;
    @Value("${GET_STUDENT_BY_NAME}")
    private String studentByName;
    private String allActiveUser;
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

    @Value("${INSERT_STUDENT_DISABILITIES}")
    private String insertStudentDisabilities;
    @Value("${UPDATE_STUDENT_DISABILITIES}")
    private String updateStudentDisabilities;
    @Value("${DELETE_STUDENT_DISABILITIES}")
    private String deleteStudentDisabilities;
    @Value("${GET_STUDENT_DISABILITIES_BY_ID}")
    private String userStudentDisabilitiesById;

     @Value("${INSERT_TERMLOOKUP}")
     private String insertTermLookup;
     @Value("${DELETE_TERMLOOKUP}")
     private String deleteTermLookUp;
     @Value("${UPDATE_TERMLOOKUP}")
     private String updateTermLookUp;
     @Value("${GET_TERMLOOKUP_TITLE}")
     private String getTermLookUpByTitle;
     @Value("${GET_TERMLOOKUPS}")
     private String getTermLookUps;

     @Value("${INSERT_TERM}")
     private String insertTerm;
     @Value("${UPDATE_TERM}")
     private String updateTerm;
     @Value("${DELETE_TERM}")
     private String deleteTerm;
     @Value("${GET_TERMS_AY}")
     private String termByAacademicYear;
     @Value("${GET_TERM_ID}")
     private String termById;
     @Value("${GET_TERM_TITLE}")
     private String termByTitle;
     @Value("${GET_TERMS_AY_COURSE_CATEGORY}")
     private String termsAyCourseCategory;
     @Value("${GET_TERMS_AY_COURSE_CLASS}")
     private String termsAyCourseClass;
     @Value("${GET_TERMS_AY_COURSE_CLS_CATEGORY}")
     private String termsAyCourseClsCategory;

     @Value("${INSERT_FEE_HEADERS}")
     private String insertFeeHeaders;
     @Value("${UPDATE_FEE_HEADERS}")
     private String updateFeeHeaders;
     @Value("${DELETE_FEE_HEADERS}")
     private String deleteFeeHeaders;
     @Value("${GET_FEE_HEADERS}")
     private String feeHeadersList;

    @Value("${INSERT_TERM_FEE}")
    private String insertTermFee;
    @Value("${UPDATE_TERM_FEE}")
    private String updateTermFee;
    @Value("${DELETE_TERM_FEE}")
    private String deleteTermFee;
    @Value("${GET_TERM_FEE_LIST}")
    private String termFeeList;
    @Value("${GET_TERM_FEE_BY_TERM_LIST}")
    private String termFeeByTermList;

 public String getInsertStudentEnrollment() {
        return insertStudentEnrollment;
    }

    public String getEnrolledStudentByCourse() {
        return enrolledStudentByCourse;
    }

    public String getDeleteEnrolledStudent() {
        return deleteEnrolledStudent;
    }

    public String getUpdateStudentEnrolled() {
        return updateStudentEnrolled;
    }

    public String getEnrolledStudentList() {
        return enrolledStudentList;
    }

    public String getEnrolledStudentById() {
        return enrolledStudentById;
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

    /*public String getInsertUser() {
        return insertUser;
    }*/

    /*public String getUpdateUser() {
        return updateUser;
    }*/

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

   /* public String getInsertOrganization() {
        return insertOrganization;
    }*/

    public String getUpdateOrganization() {
        return updateOrganization;
    }

    public String getDeleteOrganization() {
        return deleteOrganization;
    }

    public String getGetActiveOrganization() {
        return getActiveOrganization;
    }

    public String getGetAllOrganization() {
        return getAllOrganization;
    }

    public String getGetOrganizationById() {
        return getOrganizationById;
    }


    public String getAuditDetailsByOrg() {
        return auditDetailsByOrg;
    }

    public String getAuditDetailsByUser() {
        return auditDetailsByUser;
    }

    public String getBranchInsert() {
        return branchInsert;
    }

    public String getBranchDelete() {
        return branchDelete;
    }

    public String getBranchUpdate() {
        return branchUpdate;
    }

    public String getGetActiveBranch() {
        return getActiveBranch;
    }

    public String getGetAllBranch() {
        return getAllBranch;
    }

    public String getGetBranchById() {
        return getBranchById;
    }


    public String getActiveDepartment() {
        return activeDepartment;
    }

    public String getNonActiveDepartment() {
        return nonActiveDepartment;
    }

    public String getAllOrgDepartment() {
        return allOrgDepartment;
    }

    public String getInsertOrgDepartment() {
        return insertOrgDepartment;
    }

    public String getUpdateOrgDepartment() {
        return updateOrgDepartment;
    }

    public String getDeleteOrgDepartment() {
        return deleteOrgDepartment;
    }

    public String getDepartmentGetById() {
        return departmentGetById;
    }

    public String getDepartmentGetByName() {
        return departmentGetByName;
    }

    public String getActiveDesignation() {
        return activeDesignation;
    }

    public String getNonActiveDesignation() {
        return nonActiveDesignation;
    }

    public String getAllOrgDesignation() {
        return allOrgDesignation;
    }

    public String getInsertOrgDesignation() {
        return insertOrgDesignation;
    }

    public String getUpdateOrgDesignation() {
        return updateOrgDesignation;
    }

    public String getDeleteOrgDesignation() {
        return deleteOrgDesignation;
    }

    public String getDesignationGetById() {
        return designationGetById;
    }

    public String getDesignationGetByName() {
        return designationGetByName;
    }

    public String getInsertBatch() {
        return insertBatch;
    }

    public String getUpdateBatch() {
        return updateBatch;
    }

    public String getDeleteBatch() {
        return deleteBatch;
    }

    public String getBatchByName() {
        return batchByName;
    }

    public String getBatchById() {
        return batchById;
    }

    public String getBatchByOrgId() {
        return batchByOrgId;
    }

    public String getBatchByYear() {
        return batchByYear;
    }

    public String getInsertCourseLevel() {
        return insertCourseLevel;
    }

    public String getUpdateCourseLevel() {
        return updateCourseLevel;
    }



    public String getCourseLevelByCounrty() {
        return courseLevelByCounrty;
    }

    public String getCourseLevelByGroup() {
        return courseLevelByGroup;
    }

    public String getCourseLevelByTitle() {
        return courseLevelByTitle;
    }

    public String getCourseCategories() {
        return courseCategories;
    }

    public String getInsertCourseCategories() {
        return insertCourseCategories;
    }

    public String getUpdateCourseCategory() {
        return updateCourseCategory;
    }

    public String getInsertCourseStudy() {
        return insertCourseStudy;
    }

    public String getUpdateCourseStudy() {
        return updateCourseStudy;
    }

    public String getCourseStudyByCcCl() {
        return courseStudyByCcCl;
    }

    public String getCourseStudyByCc() {
        return courseStudyByCc;
    }

    public String getCourseStudyById() {
        return courseStudyById;
    }

    public String getInsertCourseClass() {
        return insertCourseClass;
    }

    public String getUpdateCourseClass() {
        return updateCourseClass;
    }

    public String getDeleteCourseClass() {
        return deleteCourseClass;
    }

    public String getCourseClassId() {
        return courseClassId;
    }

    public String getCourseClassByStudyCode() {
        return courseClassByStudyCode;
    }

    public String getInsertCourseSubject() {
        return insertCourseSubject;
    }

    public String getUpdateCourseSubject() {
        return updateCourseSubject;
    }

    public String getCourseSubjectId() {
        return courseSubjectId;
    }

    public String getCourseSubjectClsId() {
        return courseSubjectClsId;
    }

    public String getCourseClassSubjects() {
        return courseClassSubjects;
    }

    public String getInsertOrgClasses() {
        return insertOrgClasses;
    }

    public String getUpdateOrgClasses() {
        return updateOrgClasses;
    }

    public String getOrgClasses() {
        return orgClasses;
    }

    public String getOrgClassesByCls() {
        return orgClassesByCls;
    }

    public String getInsertClassSubject() {
        return insertClassSubject;
    }

    public String getUpdateClassSubject() {
        return updateClassSubject;
    }

    public String getClassSubject() {
        return classSubject;
    }

    public String getInsertStudyBranch() {
        return insertStudyBranch;
    }

    public String getDeleteStudyBranch() {
        return deleteStudyBranch;
    }

    public String getStudyBranchList() {
        return studyBranchList;
    }

    public String getInsertDistrict() {
        return insertDistrict;
    }

    public String getUpdateDistrict() {
        return updateDistrict;
    }

    public String getDeleteDistrict() {
        return deleteDistrict;
    }

    public String getDistrictById() {
        return districtById;
    }

    public String getDistrictByName() {
        return districtByName;
    }

    public String getDistrictByState() {
        return districtByState;
    }

    public String getInsertMandal() {
        return insertMandal;
    }

    public String getMandalByDistrict() {
        return mandalByDistrict;
    }

    public String getUpdateMandal() {
        return updateMandal;
    }

    public String getDeleteMandal() {
        return deleteMandal;
    }

    public String getMandalById() {
        return mandalById;
    }

    public String getMandalByName() {
        return mandalByName;
    }

    public String getInsertZone() {
        return insertZone;
    }

    public String getUpdateZone() {
        return updateZone;
    }

    public String getDeleteZone() {
        return deleteZone;
    }

    public String getZoneById() {
        return zoneById;
    }

    public String getZoneByName() {
        return zoneByName;
    }

    public String getInsertCategory() {
        return insertCategory;
    }

    public String getUpdateCategory() {
        return updateCategory;
    }

    public String getDeleteCategory() {
        return deleteCategory;
    }

    public String getCategoryByName() {
        return categoryByName;
    }

    public String getAcademicYearByOrgId() {
        return academicYearByOrgId;
    }

    public String getInsertAcademicYear() {
        return insertAcademicYear;
    }

    public String getUpdateAcademicYear() {
        return updateAcademicYear;
    }

    public String getDeleteAcademicYear() {
        return deleteAcademicYear;
    }

    public String getAcademicYearById() {
        return academicYearById;
    }

    public String getAcademicYearByBatch() {
        return academicYearByBatch;
    }

    public String getAcademicYearByYear() {
        return academicYearByYear;
    }

    public String getAcademicYearByCourse() {
        return academicYearByCourse;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getInsertTerm() {
        return insertTerm;
    }

    public String getUpdateTerm() {
        return updateTerm;
    }

    public String getDeleteTerm() {
        return deleteTerm;
    }

    public String getTermByAacademicYear() {
        return termByAacademicYear;
    }

    public String getTermById() {
        return termById;
    }

    public String getTermByTitle() {
        return termByTitle;
    }

    public String getInsertCourses() {
        return insertCourses;
    }

    public String getUpdateCourses() {
        return updateCourses;
    }

    public String getDeleteCourses() {
        return deleteCourses;
    }

    public String getCoursesById() {
        return coursesById;
    }

    public String getCoursesByTitle() {
        return coursesByTitle;
    }

    public String getCoursesByStitle() {
        return coursesByStitle;
    }

    public String getCoursesByCourseLevel() {
        return coursesByCourseLevel;
    }

    public String getCoursesByBranch() {
        return coursesByBranch;
    }

    public String getAciveAdmissionYear() {
        return aciveAdmissionYear;
    }

    public String getInsertTermLookup() {
        return insertTermLookup;
    }

    public String getDeleteTermLookUp() {
        return deleteTermLookUp;
    }

    public String getUpdateTermLookUp() {
        return updateTermLookUp;
    }

    public String getGetTermLookUpTitle() {
        return getTermLookUpByTitle;
    }

    public String getGetTermLookUps() {
        return getTermLookUps;
    }

    public String getZoneByState() {
        return zoneByState;
    }

    public String getCategories() {
        return categories;
    }

    public String getAllActiveAcademicYear() {
        return allActiveAcademicYear;
    }

    public String getActiveBatches() {
        return activeBatches;
    }

    public String getGetTermLookUpByTitle() {
        return getTermLookUpByTitle;
    }

    public String getInsertDesignationCategory() {
        return insertDesignationCategory;
    }

    public String getUpdateDesignationCategory() {
        return updateDesignationCategory;
    }

    public String getDeleteDesignationCategory() {
        return deleteDesignationCategory;
    }

    public String getActiveDesignationCategory() {
        return activeDesignationCategory;
    }

    public String getListDesignationCategory() {
        return listDesignationCategory;
    }

    public String getStudentById() {
        return studentById;
    }

    public String getStudentByName() {
        return studentByName;
    }

    public String getInsertStudent() {
        return insertStudent;
    }

    public String getDeleteStudent() {
        return deleteStudent;
    }




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

 public String getAllOrgAuthorizedUsers() {
  return allOrgAuthorizedUsers;
 }

 public String getInsertStudentAcademicHistory() {
  return insertStudentAcademicHistory;
 }

 public String getUpdateStudentAcademicHistory() {
  return updateStudentAcademicHistory;
 }

 public String getDeleteStudentAcademicHistory() {
  return deleteStudentAcademicHistory;
 }

 public String getStudentAcademicHistoryById() {
  return studentAcademicHistoryById;
 }

 public String getInsertStudentClassSection() {
  return insertStudentClassSection;
 }

 public String getUpdateStudentClassSection() {
  return updateStudentClassSection;
 }

 public String getDeleteStudentClassSection() {
  return deleteStudentClassSection;
 }

 public String getStudentClassSectionById() {
  return studentClassSectionById;
 }

 public String getInsertParent() {
  return insertParent;
 }

    public String getStudentsListByClass() {
        return studentsListByClass;
    }

    public String getUpdateParent() {
  return updateParent;
 }

 public String getUpdateStudent() {
  return updateStudent;
 }

 public String getStudentByClass() {
  return studentByClass;
 }

 public String getStudentCountByClasses() {
  return studentCountByClasses;
 }

    public String getAdmissionYearInsert() {
        return admissionYearInsert;
    }

    public String getAdmissionYearUpdate() {
        return admissionYearUpdate;
    }

    public String getAdmissionYearDelete() {
        return admissionYearDelete;
    }

    public String getAdmissionYearGetActiveYear() {
        return admissionYearGetActiveYear;
    }

    public String getAdmissionYearGetAll() {
        return admissionYearGetAll;
    }

    public String getInsertStudentDisabilities() {
        return insertStudentDisabilities;
    }

    public String getUpdateStudentDisabilities() {
        return updateStudentDisabilities;
    }

    public String getDeleteStudentDisabilities() {
        return deleteStudentDisabilities;
    }

    public String getUserStudentDisabilitiesById() {
        return userStudentDisabilitiesById;
    }

    public String getBranchCourseClassById() {
        return branchCourseClassById;
    }

 public String getParentSearchByNameAndContact() {
  return parentSearchByNameAndContact;
 }

 public String getTermsAyCourseCategory() {
  return termsAyCourseCategory;
 }

 public String getTermsAyCourseClass() {
  return termsAyCourseClass;
 }

 public String getInsertFeeHeaders() {
  return insertFeeHeaders;
 }

 public String getUpdateFeeHeaders() {
  return updateFeeHeaders;
 }

 public String getDeleteFeeHeaders() {
  return deleteFeeHeaders;
 }

 public String getFeeHeadersList() {
  return feeHeadersList;
 }

 public String getInsertTermFee() {
  return insertTermFee;
 }

 public String getUpdateTermFee() {
  return updateTermFee;
 }

 public String getDeleteTermFee() {
  return deleteTermFee;
 }

 public String getTermFeeList() {
  return termFeeList;
 }

 public String getActiveAyBranchClasses() {
  return activeAyBranchClasses;
 }

 public String getTermMapTermFee() {
  return termMapTermFee;
 }

 public String getTermFeeByTermList() {
  return termFeeByTermList;
 }

 public String getTermsAyCourseClsCategory() {
  return termsAyCourseClsCategory;
 }
}
