package com.smss.api.app.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:database/dev/branch.properties"})
@Component
public class BranchDB {
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


    public String getInsertOrganization() {
        return insertOrganization;
    }

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
}
