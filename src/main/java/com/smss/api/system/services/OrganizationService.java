package com.smss.api.system.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smss.api.smssApi.apiclazz.BranchParam;
import com.smss.api.smssApi.apiclazz.OrganizationParam;
import com.smss.api.system.daos.OrganizationDAO;
import com.smss.api.system.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationDAO organization;


    public List<Organization> getActiveOrganization() throws SQLException {
        return organization.getActiveOrganization();
    }


    public List<Organization> addOrganization(Organization org) throws SQLException {
        return organization.addOrganization(org);
    }


    public List<Organization> removeOrganization(Organization org) throws SQLException {
        return organization.removeOrganization(org);
    }


    public List<Organization> getAllOrganization() throws SQLException {
        return organization.getAllOrganization();
    }


    public List<Organization> updateOrganization(Organization org) throws SQLException {
        return organization.updateOrganization(org);
    }


    public List<Organization> getOrganizationById(OrganizationParam org) throws SQLException {
        return organization.getOrganizationById(org);
    }


    public List<Organization> insertBulkOrganization(List<Organization> orgs) throws SQLException {
        return organization.insertBulkOrganization(orgs);
    }


    public List<Organization> updateBulkOrganization(List<Organization> orgs) throws SQLException {
        return organization.insertBulkOrganization(orgs);
    }


    public List<Organization> deleteBulkOrganization(List<Organization> orgs) throws SQLException {
        return organization.deleteBulkOrganization(orgs);
    }

    public List<Audit> getAuditDetailsByOrg(int orgid) throws SQLException{
        return organization.getAuditDetailsByOrg(orgid);
    }

    public List<Audit> getAuditDetailsByUser(int orgid,int userid) throws SQLException{
        return organization.getAuditDetailsByUser(orgid,userid);
    }



    public List<Branch> branchInsert(Branch branch) throws SQLException {
        return organization.branchInsert(branch);
    }


    public List<Branch> branchDelete(BranchParam param) throws SQLException {
        return organization.branchDelete(param);

    }


    public List<Branch> branchUpdate(Branch branch) throws SQLException {
        return organization.branchUpdate(branch);
    }


    public List<Branch> getActiveBranch(BranchParam param) throws SQLException {
        return organization.getActiveBranch(param);
    }


    public List<Branch> getAllBranch(BranchParam param) throws SQLException {
        return organization.getAllBranch(param);
    }


    public List<Branch> getBranchById(BranchParam param) throws SQLException {
        return organization.getBranchById(param);
    }


    public List<Branch> insertBulkBranch(List<Branch> branchs) throws SQLException {
        return organization.insertBulkBranch(branchs);
    }


    public List<Branch> updateBulkBranch(List<Branch> branchs) throws SQLException {
        return organization.updateBulkBranch(branchs);
    }


    public List<Branch> deleteBulkBranch(List<Branch> branchs) throws SQLException {
        return organization.deleteBulkBranch(branchs);
    }


    public List<OrgDepartment> getActiveDepartment(OrgDepartment dept) throws SQLException {
        return organization.getActiveDepartment(dept);
    }


    public List<OrgDepartment> getNonActiveDepartment(OrgDepartment dept) throws SQLException {
        return organization.getNonActiveDepartment(dept);
    }


    public List<OrgDepartment> getAllOrgDepartment(OrgDepartment dept) throws SQLException {
        return organization.getAllOrgDepartment(dept);
    }


    public List<OrgDepartment> insertOrgDepartment(OrgDepartment dept) throws SQLException {
        return organization.insertOrgDepartment(dept);
    }


    public List<OrgDepartment> updateOrgDepartment(OrgDepartment dept) throws SQLException {
        return organization.updateOrgDepartment(dept);
    }


    public List<OrgDepartment> deleteOrgDepartment(OrgDepartment dept) throws SQLException {
        return organization.deleteOrgDepartment(dept);
    }


    public List<OrgDepartment> getDepartmentGetById(OrgDepartment dept) throws SQLException {
        return organization.getDepartmentGetById(dept);
    }


    public List<OrgDepartment> getDepartmentGetByName(OrgDepartment dept) throws SQLException {
        return organization.getDepartmentGetByName(dept);
    }


    public List<OrgDepartment> insertBulkDepartment(List<OrgDepartment> dept) throws SQLException {
        return organization.insertBulkDepartment(dept);
    }


    public List<OrgDepartment> updateBulkDepartment(List<OrgDepartment> dept) throws SQLException {
        return organization.updateBulkDepartment(dept);
    }


    public List<OrgDepartment> deleteBulkDepartment(List<OrgDepartment> dept) throws SQLException {
        return organization.deleteBulkDepartment(dept);
    }


    public List<OrgDesignation> getActiveDesignation(OrgDesignation design) throws SQLException {
        return organization.getActiveDesignation(design);
    }


    public List<OrgDesignation> getNonActiveDesignation(OrgDesignation design) throws SQLException {
        return organization.getNonActiveDesignation(design);
    }


    public List<OrgDesignation> getAllOrgDesignation(OrgDesignation design) throws SQLException {
        return organization.getAllOrgDesignation(design);
    }


    public List<OrgDesignation> insertOrgDesignation(OrgDesignation desg) throws SQLException {
        return organization.insertOrgDesignation(desg);
    }


    public List<OrgDesignation> updateOrgDesignation(OrgDesignation desg) throws SQLException {
        return organization.updateOrgDesignation(desg);
    }


    public List<OrgDesignation> deleteOrgDesignation(OrgDesignation design) throws SQLException {
        return organization.deleteOrgDesignation(design);
    }


    public List<OrgDesignation> getDesignationGetById(OrgDesignation design) throws SQLException {
        return organization.getDesignationGetById(design);
    }


    public List<OrgDesignation> getDesignationGetByName(OrgDesignation design) throws SQLException {
        return organization.getDesignationGetByName(design);
    }


    public List<OrgDesignation> insertBulkDesignation(List<OrgDesignation> design) throws SQLException {
        return organization.insertBulkDesignation(design);
    }


    public List<OrgDesignation> updateBulkDesignation(List<OrgDesignation> design) throws SQLException {
        return organization.updateBulkDesignation(design);
    }


    public List<OrgDesignation> deleteBulkDesignation(List<OrgDesignation> design) throws SQLException {
        return organization.deleteBulkDesignation(design);
    }


    public List<BatchesLookup> insertBatch(BatchesLookup batch) throws SQLException {
        return organization.insertBatch(batch);
    }


    public List<BatchesLookup> updateBatch(BatchesLookup batch) throws SQLException {
        return organization.updateBatch(batch);
    }


    public List<BatchesLookup> deleteBatch(BatchesLookup batch) throws SQLException {
        return organization.deleteBatch(batch);
    }


    public List<BatchesLookup> batchByName(BatchesLookup batch) throws SQLException {
        return organization.batchByName(batch);
    }


    public List<BatchesLookup> batchById(BatchesLookup batch) throws SQLException {
        return organization.batchById(batch);
    }


    public List<BatchesLookup> batchByOrgId(BatchesLookup batch) throws SQLException {
        return organization.batchByOrgId(batch);
    }


    public List<BatchesLookup> activeBatches(BatchesLookup batch) throws SQLException {
        return organization.activeBatches(batch);
    }


    public List<BatchesLookup> insertBulkBatches(List<BatchesLookup> batches) throws SQLException {
        return organization.insertBulkBatches(batches);
    }


    public List<BatchesLookup> updateBulkBatches(List<BatchesLookup> batches) throws SQLException {
        return organization.updateBulkBatches(batches);
    }


    public List<BatchesLookup> deleteBulkBatches(List<BatchesLookup> batches) throws SQLException {
        return organization.deleteBulkBatches(batches);
    }


    public List<CourseLevelLookup> insertCourseLevel(CourseLevelLookup course) throws SQLException {
        return organization.insertCourseLevel(course);
    }


    public List<CourseLevelLookup> updateCourseLevel(CourseLevelLookup course) throws SQLException {
        return organization.updateCourseLevel(course);
    }


/*
    public List<CourseLevelLookup> deleteCourseLevel(CourseLevelLookup course) throws SQLException {
        return organization.deleteCourseLevel(course);
    }
*/


    public List<CourseLevelLookup> courseLevelByTitle(CourseLevelLookup course) throws SQLException {
        return organization.courseLevelByTitle(course);
    }

    public List<CourseLevelLookup> courseLevelByGroup(CourseLevelLookup course) throws SQLException {
        return organization.courseLevelByGroup(course);
    }
    public List<CourseLevelLookup> courseLevelByCounrty(CourseLevelLookup course) throws SQLException {
        return organization.courseLevelByCounrty(course);
    }


    public List<CourseLevelLookup> inserrtBulkcourseLevel(List<CourseLevelLookup> courses) throws SQLException {
        return organization.inserrtBulkcourseLevel(courses);
    }


    public List<CourseLevelLookup> updateBulkcourseLevel(List<CourseLevelLookup> courses) throws SQLException {
        return organization.updateBulkcourseLevel(courses);
    }
/*---------------------------------- course category ----------------------------------------------*/
    public List<CourseCategory> insertCourseCategory(CourseCategory course) throws SQLException {

        return (List<CourseCategory>) organization.insertCourseCategory(course);
    }


    public List<CourseCategory> updateCourseCategory(CourseCategory course) throws SQLException {

        return (List<CourseCategory>) organization.updateCourseCategory(course);
    }


    public List<CourseCategory> courseCategories(CourseCategory course) throws SQLException {
        return (List<CourseCategory>) organization.courseCategories(course);
    }

    public List<OrgClasses> getBranchCourseClassById(ObjectNode courseClass) throws Exception {
        return (List<OrgClasses>) organization.getBranchCourseClassById(courseClass);
    }
    public List<TermMapTermFee> getTermMapTermFee(ObjectNode object) throws Exception {
        return organization.getTermMapTermFee(object);
    }
    public List<TermFees> getTermFeeByTermList(TermFees termFees) throws Exception {
        return organization.getTermFeeByTermList(termFees);
    }
/*
    public List<CourseLevelLookup> deleteBulkcourseLevel(List<CourseLevelLookup> courses) throws SQLException {
        return organization.deleteBulkcourseLevel(courses);
    }
*/

    public List<CourseClasses> insertCourseClass(CourseClasses classes) throws SQLException{


        return organization.insertCourseClass(classes);
    }
    public List<CourseClasses> updateCourseClass(CourseClasses classes) throws SQLException{
        return organization.updateCourseClass(classes);
    }

    public List<CourseClasses> getCourseClassByCode(CourseClasses classes)throws SQLException{
       return organization.getCourseClassByCode(classes);
    }
    public List<CourseClasses> getCourseClassByStudyCode(CourseClasses classes)throws SQLException{
        return organization.getCourseClassByStudyCode(classes);
    }
    /*--------------------------------------- class subjects -------------------------------*/

    public List<ClassSubject> insertClassSubject(ClassSubject subject)throws SQLException{
        return (List<ClassSubject>) organization.insertClassSubject(subject);
    }

    public List<ClassSubject> updateClassSubject(ClassSubject subject)throws SQLException{

        return (List<ClassSubject>) organization.updateClassSubject(subject);
    }

    public List<ClassSubject> getClassSubjectById(ClassSubject subject) throws SQLException{
        return (List<ClassSubject>) organization.getClassSubjectById(subject);
    }

    public List<ClassSubject> getClassSubjectByClsId(ClassSubject subject)throws SQLException{

        return (List<ClassSubject>) organization.getClassSubjectByClsId(subject);
    }
    public List<ClassSubject> getClassSubject()throws SQLException{

        return (List<ClassSubject>) organization.getClassSubject();
    }
    /*--------------------------------------------- organizaiton classes -------------------*/
    public List<OrgClasses> insertOrgClasses(OrgClasses classes) throws SQLException{

        return (List<OrgClasses>)  organization.insertOrgClasses(classes);
    }

    public List<OrgClasses> updateOrgClass(OrgClasses classes)throws SQLException{
        return organization.updateOrgClass(classes);
    }

    public List<OrgClasses> getOrgClassByOrgID(OrgClasses classes)throws SQLException{
       return organization.getOrgClassByOrgID(classes);
    }

    public List<OrgClasses> getOrgClassesByClsId(OrgClasses classes)throws SQLException{

        return (List<OrgClasses>) organization.getOrgClassesByClsId(classes);
    }
    /*--------------------------------------study branch --------------------------------------------*/
    public List<StudyBranchLookup> insertStudyBranch(StudyBranchLookup study) throws SQLException {
        return organization.insertStudyBranch(study);
    }


    public List<StudyBranchLookup> deleteStudyBranch(StudyBranchLookup study) throws SQLException {
        return organization.deleteStudyBranch(study);
    }


    public List<StudyBranchLookup> studyBranchList(StudyBranchLookup study) throws SQLException {
        return organization.studyBranchList(study);
    }


    public List<StudyBranchLookup> insertBulkstudyBranch(List<StudyBranchLookup> studys) throws SQLException {
        return organization.insertBulkstudyBranch(studys);
    }


    public List<StudyBranchLookup> updateBulkstudyBranch(List<StudyBranchLookup> studys) throws SQLException {
        return organization.updateBulkstudyBranch(studys);
    }


    public List<StudyBranchLookup> deleteBulkstudyBranch(List<StudyBranchLookup> studys) throws SQLException {
        return organization.deleteBulkstudyBranch(studys);
    }


    public List<DistrictLookup> insertDistrict(DistrictLookup district) throws SQLException {
        return organization.insertDistrict(district);
    }


    public List<DistrictLookup> updateDistrict(DistrictLookup district) throws SQLException {
        return organization.updateDistrict(district);
    }


    public List<DistrictLookup> deleteDistrict(DistrictLookup district) throws SQLException {
        return organization.deleteDistrict(district);
    }


    public List<DistrictLookup> districtById(DistrictLookup district) throws SQLException {
        return organization.districtById(district);
    }


    public List<DistrictLookup> districtByName(DistrictLookup district) throws SQLException {
        return organization.districtByName(district);
    }


    public List<DistrictLookup> districtByState(DistrictLookup district) throws SQLException {
        return organization.districtByState(district);
    }


    public List<DistrictLookup> insertBulkDistrict(List<DistrictLookup> districts) throws SQLException {
        return organization.insertBulkDistrict(districts);
    }


    public List<DistrictLookup> updateBulkDistrict(List<DistrictLookup> districts) throws SQLException {
        return organization.updateBulkDistrict(districts);
    }


    public List<DistrictLookup> deleteBulkDistrict(List<DistrictLookup> districts) throws SQLException {
        return organization.deleteBulkDistrict(districts);
    }


    public List<MandalLookup> insertMandal(MandalLookup mandal) throws SQLException {
        return organization.insertMandal(mandal);
    }


    public List<MandalLookup> updateMandal(MandalLookup mandal) throws SQLException {
        return organization.updateMandal(mandal);
    }


    public List<MandalLookup> deleteMandal(MandalLookup mandal) throws SQLException {
        return organization.deleteMandal(mandal);
    }


    public List<MandalLookup> mandalById(MandalLookup mandal) throws SQLException {
        return organization.mandalById(mandal);
    }


    public List<MandalLookup> mandalByName(MandalLookup mandal) throws SQLException {
        return organization.mandalByName(mandal);
    }


    public List<MandalLookup> mandalByDistrict(MandalLookup mandal) throws SQLException {
        return organization.mandalByDistrict(mandal);
    }


    public List<MandalLookup> insertBulkMandal(List<MandalLookup> mandals) throws SQLException {
        return organization.insertBulkMandal(mandals);
    }


    public List<MandalLookup> updateBulkMandal(List<MandalLookup> mandals) throws SQLException {
        return organization.updateBulkMandal(mandals);
    }


    public List<MandalLookup> deleteBulkMandal(List<MandalLookup> mandals) throws SQLException {
        return organization.deleteBulkMandal(mandals);
    }


    public List<ZoneLookup> insertZone(ZoneLookup zone) throws SQLException {
        return organization.insertZone(zone);
    }


    public List<ZoneLookup> updateZone(ZoneLookup zone) throws SQLException {
        return organization.updateZone(zone);
    }


    public List<ZoneLookup> deleteZone(ZoneLookup zone) throws SQLException {
        return organization.deleteZone(zone);
    }


    public List<ZoneLookup> zoneById(ZoneLookup zone) throws SQLException {
        return organization.zoneById(zone);
    }


    public List<ZoneLookup> zoneByName(ZoneLookup zone) throws SQLException {
        return organization.zoneByName(zone);
    }


    public List<ZoneLookup> zoneByState(ZoneLookup zone) throws SQLException {
        return organization.zoneByState(zone);
    }


    public List<ZoneLookup> insertBulkZone(List<ZoneLookup> zones) throws SQLException {
        return organization.insertBulkZone(zones);
    }


    public List<ZoneLookup> updateBulkZone(List<ZoneLookup> zones) throws SQLException {
        return organization.updateBulkZone(zones);
    }


    public List<ZoneLookup> deleteBulkZone(List<ZoneLookup> zones) throws SQLException {
        return organization.deleteBulkZone(zones);
    }


    public List<CategoryLookup> insertCategory(CategoryLookup category) throws SQLException {
        return organization.insertCategory(category);
    }


    public List<CategoryLookup> updateCategory(CategoryLookup category) throws SQLException {
        return organization.updateCategory(category);
    }


    public List<CategoryLookup> deleteCategory(CategoryLookup category) throws SQLException {
        return organization.deleteCategory(category);
    }


    public List<CategoryLookup> categoryByName(CategoryLookup category) throws SQLException {
        return organization.categoryByName(category);
    }


    public List<CategoryLookup> categories(CategoryLookup category) throws SQLException {
        return organization.categories(category);
    }


    public List<CategoryLookup> insertBulkcategory(List<CategoryLookup> categories) throws SQLException {
        return organization.insertBulkcategory(categories);
    }


    public List<CategoryLookup> updateBulkcategory(List<CategoryLookup> categories) throws SQLException {
        return organization.updateBulkcategory(categories);
    }


    public List<CategoryLookup> deleteBulkcategory(List<CategoryLookup> categories) throws SQLException {
        return organization.deleteBulkcategory(categories);
    }


    public List<AcademicYear> insertAcademicYear(AcademicYear academic) throws SQLException {
        return organization.insertAcademicYear(academic);
    }


    public List<AcademicYear> updateAcademicYear(AcademicYear academic) throws SQLException {
        return organization.updateAcademicYear(academic);
    }


    public List<AcademicYear> deleteAcademicYear(AcademicYear academic) throws SQLException {
        return organization.deleteAcademicYear(academic);
    }


    public List<AcademicYear> academicYearById(AcademicYear academic) throws SQLException {
        return organization.academicYearById(academic);
    }

    public List<AcademicYear> academicYearByOrgId(AcademicYear academic) throws SQLException {
        return organization.academicYearByOrgId(academic);
    }
    public List<AcademicYear> academicYearByBatch(AcademicYear academic) throws SQLException {
        return organization.academicYearByBatch(academic);
    }


    public List<AcademicYear> academicYearByYear(AcademicYear academic) throws SQLException {
        return organization.academicYearByYear(academic);
    }


    public List<AcademicYear> academicYearByCourse(AcademicYear academic) throws SQLException {
        return organization.academicYearByCourse(academic);
    }


    public List<AcademicYear> academicYear(AcademicYear academic) throws SQLException {
        return organization.academicYear(academic);
    }


    public List<AcademicYear> aciveAdmissionYear(AcademicYear academic) throws SQLException {
        return organization.aciveAdmissionYear(academic);
    }


    public List<AcademicYear> allActiveAcademicYear(AcademicYear academic) throws SQLException {
        return organization.allActiveAcademicYear(academic);
    }


    public List<AcademicYear> insertBulkAcademicYear(List<AcademicYear> academics) throws SQLException {
        return organization.insertBulkAcademicYear(academics);
    }


    public List<AcademicYear> updateBulkAcademicYear(List<AcademicYear> academics) throws SQLException {
        return organization.updateBulkAcademicYear(academics);
    }


    public List<AcademicYear> deleteBulkAcademicYear(List<AcademicYear> academics) throws SQLException {
        return organization.deleteBulkAcademicYear(academics);
    }


    public List<Terms> insertTerm(List<Terms> term) throws Exception {
        return organization.insertTerm(term);
    }


    public List<Terms> updateTerm(Terms term) throws SQLException {
        return organization.updateTerm(term);
    }


    public List<Terms> deleteTerm(Terms term) throws SQLException {
        return organization.deleteTerm(term);
    }
    public List<Terms> deleteTermList(List<Terms> terms) throws SQLException {
        return organization.deleteTermList(terms);
    }


    public List<Terms> termByAacademicYear(Terms term) throws SQLException {
        return organization.termByAacademicYear(term);
    }


    public List<Terms> termById(Terms term) throws SQLException {
        return organization.termById(term);
    }


    public List<Terms> termByTitle(Terms term) throws SQLException {
        return organization.termByTitle(term);
    }

    public List<Terms> getTermByAyCourseCategory( Terms terms) throws Exception{
        return organization.getTermByAyCourseCategory(terms);
    }
    public List<Terms> getTermsAyCourseClsCategory( Terms terms) throws Exception{
        return organization.getTermsAyCourseClsCategory(terms);
    }

    public List<Terms> getTermsByAyCourseClass(Terms terms) throws Exception{
        return organization.getTermsByAyCourseClass(terms);
    }

    public List<Terms> insertBulkTerm(List<Terms> terms) throws SQLException {
        return organization.insertBulkTerm(terms);
    }


    public List<Terms> updateBulkTerm(List<Terms> terms) throws SQLException {
        return organization.updateBulkTerm(terms);
    }


    public List<Terms> deleteBulkTerm(List<Terms> terms) throws SQLException {
        return organization.deleteBulkTerm(terms);
    }

    public List<FeeHeaders> updateFeeHeaders(FeeHeaders feeheader) throws Exception {
        return organization.updateFeeHeaders(feeheader);
    }
    public List<FeeHeaders> deleteFeeHeaders(FeeHeaders feeheader) throws Exception {
        return organization.deleteFeeHeaders(feeheader);
    }
    public List<FeeHeaders> deleteFeeHeaderList(List<FeeHeaders> feeheader) throws Exception {
        return organization.deleteFeeHeaderList(feeheader);
    }
    public List<FeeHeaders> insertFeeHeaderList(List<FeeHeaders> feeheader) throws Exception {
        return organization.insertFeeHeaderList(feeheader);
    }
    public List<FeeHeaders> feeHeadersList(FeeHeaders feeheader) throws Exception {
        return organization.feeHeadersList(feeheader);
    }
    public List<TermFees> insertTermFee(TermFees termfee) throws Exception {
        return organization.insertTermFee(termfee);
    }
    public List<TermFees> updateTermFee(TermFees termfee) throws Exception {
        return organization.updateTermFee(termfee);
    }
    public List<TermFees> deleteTermFee(TermFees termfee) throws Exception {
        return organization.deleteTermFee(termfee);
    }
    public List<TermFees> termFeeList(TermFees termfee) throws Exception {
        return organization.termFeeList(termfee);
    }


    public List<FeeHeaders> insertFeeHeaders(FeeHeaders feeheader) throws SQLException{
        return organization.insertFeeHeaders(feeheader);
    }
    public List<CoursesLookup> insertCourses(CoursesLookup course) throws SQLException {
        return organization.insertCourses(course);
    }


    public List<CoursesLookup> updateCourses(CoursesLookup course) throws SQLException {
        return organization.updateCourses(course);
    }


    public List<CoursesLookup> deleteCourses(CoursesLookup course) throws SQLException {
        return organization.deleteCourses(course);
    }


    public List<CoursesLookup> coursesById(CoursesLookup course) throws SQLException {
        return organization.coursesById(course);
    }


    public List<CoursesLookup> coursesByTitle(CoursesLookup course) throws SQLException {
        return organization.coursesByTitle(course);
    }


    public List<CoursesLookup> coursesByStitle(CoursesLookup course) throws SQLException {
        return organization.coursesByStitle(course);
    }


    public List<CoursesLookup> coursesByCourseLevel(CoursesLookup course) throws SQLException {
        return organization.coursesByCourseLevel(course);
    }
    public List<OrgClasses> activeAyBranchClasses(OrgClasses classes) throws Exception{
        return organization.activeAyBranchClasses(classes);
    }

    public List<CoursesLookup> coursesByBranch(CoursesLookup course) throws SQLException {
        return organization.coursesByBranch(course);
    }


    public List<CoursesLookup> insertBulkCourses(List<CoursesLookup> courses) throws SQLException {
        return organization.insertBulkCourses(courses);
    }


    public List<CoursesLookup> updateBulkCourses(List<CoursesLookup> courses) throws SQLException {
        return organization.updateBulkCourses(courses);
    }


    public List<CoursesLookup> deleteBulkCourses(List<CoursesLookup> courses) throws SQLException {
        return organization.deleteBulkCourses(courses);
    }


    public List<TermLookUp> insertTermLookup(TermLookUp term) throws SQLException {
        return organization.insertTermLookup(term);
    }


    public List<TermLookUp> deleteTermLookUp(TermLookUp term) throws SQLException {
        return organization.deleteTermLookUp(term);
    }


    public List<TermLookUp> updateTermLookUp(TermLookUp term) throws SQLException {
        return organization.updateTermLookUp(term);
    }


    public List<TermLookUp> getTermLookUpTitle(TermLookUp term) throws SQLException {
        return organization.getTermLookUpTitle(term);
    }


    public List<TermLookUp> getTermLookUps(TermLookUp term) throws SQLException {
        return organization.getTermLookUps(term);
    }


    public List<TermLookUp> insertBulkTermLookUp(List<TermLookUp> terma) throws SQLException {
        return organization.insertBulkTermLookUp(terma);
    }


    public List<TermLookUp> updateBulkTermLookUp(List<TermLookUp> terma) throws SQLException {
        return organization.updateBulkTermLookUp(terma);
    }


    public List<TermLookUp> deleteBulkTermLookUp(List<TermLookUp> terma) throws SQLException {
        return organization.deleteBulkTermLookUp(terma);
    }


    public List<DesignationCategory> insertDesignationCategory(DesignationCategory dcat) throws SQLException {
        return organization.insertDesignationCategory(dcat);
    }


    public List<DesignationCategory> updateDesignationCategory(DesignationCategory dcat) throws SQLException {
        return organization.updateDesignationCategory(dcat);
    }


    public List<DesignationCategory> deleteDesignationCategory(DesignationCategory dcat) throws SQLException {
        return organization.deleteDesignationCategory(dcat);
    }


    public List<DesignationCategory> activeDesignationCategory(DesignationCategory dcat) throws SQLException {
        return organization.activeDesignationCategory(dcat);
    }


    public List<DesignationCategory> listDesignationCategory(DesignationCategory dcat) throws SQLException {
        return organization.listDesignationCategory(dcat);
    }


    public List<DesignationCategory> insertBulkDesignationCategory(List<DesignationCategory> dcats) throws SQLException {
        return organization.insertBulkDesignationCategory(dcats);
    }


    public List<DesignationCategory> updateBulkDesignationCategory(List<DesignationCategory> dcats) throws SQLException {
        return organization.updateBulkDesignationCategory(dcats);
    }


    public List<DesignationCategory> deleteBulkDesignationCategory(List<DesignationCategory> dcats) throws SQLException {
        return organization.deleteBulkDesignationCategory(dcats);
    }

}
