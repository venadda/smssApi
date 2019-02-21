package com.smss.api.system.controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smss.api.smssApi.apiclazz.AuditParam;
import com.smss.api.smssApi.apiclazz.BranchParam;
import com.smss.api.smssApi.apiclazz.OrganizationParam;
import com.smss.api.system.exception.NoDataFoundException;
import com.smss.api.system.models.*;
import com.smss.api.system.services.OrganizationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
@CrossOrigin
@RestController
@RequestMapping("/configure")
public class BranchController {
    private static Logger logger = LogManager.getLogger();
    @Autowired
    private OrganizationService orgService;

    /*
        function:Upload Bulk Organizations
        status : yellow
        Unit test:
        UAT:
     */
    @PostMapping("/ibulkOrganization")
    public ResponseEntity<List<Organization>> insertBulkOrganization(@RequestBody List<Organization> org) {

        List<Organization> porg = null;
        try {
            porg = orgService.insertBulkOrganization(org);
            if (Utils.isEmpty(porg.toArray()))
                throw new NoDataFoundException("No Data Found");
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }

        return new ResponseEntity(porg, HttpStatus.OK);
    }

    /*
        function: insert a organization
        status : green
        Unit test:
        UAT:
     */
    @PostMapping("/iorganization")
    public ResponseEntity<List<Organization>> addOrganization(@RequestBody Organization org) {

        List<Organization> porg = null;
        try {
            porg = orgService.addOrganization(org);
            if (Utils.isEmpty(porg.toArray()))
                throw new NoDataFoundException("No Data found");
        } catch (Exception e) {
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(porg, HttpStatus.OK);
    }

    /*
        function: delete organization
        status :yellow
        unit test:
        UAT:
     */
    @PostMapping("/dorganization")
    public ResponseEntity<List<Organization>> removeOrganization(@RequestBody Organization org)  {

        List<Organization> porg = null;
        try {
            porg = orgService.removeOrganization(org);
            if (Utils.isEmpty(porg.toArray())) {
                logger.debug("no data found for" + org.toString());
                throw new NoDataFoundException("No Data found with " + org.toString());
            }
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(porg, HttpStatus.OK);
    }

    /*
        function: update Organization
        status : Green
        unit test:red
        UAT:red
     */
    @PostMapping("/uorganization")
    public ResponseEntity<List<Organization>> updateOrganization(@RequestBody Organization org) {

        List<Organization> porg = null;
        try {
            porg = orgService.updateOrganization(org);
            if (Utils.isEmpty(porg.toArray()))
                throw new NoDataFoundException("No Data Found");
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }

        return new ResponseEntity(porg, HttpStatus.OK);
    }

    /*
        function : list all active organization
        status: yellow
        unit test:red
        UAT:red
     */
    @PostMapping("/demo1/lactiveOrganization")
    public ResponseEntity<List<Organization>> getActiveOrganization() {

        List<Organization> porg = null;

        try {
            porg = orgService.getActiveOrganization();
            if (Utils.isEmpty(porg.toArray()))
                throw new NoDataFoundException("No Data found");
        } catch (Exception e) {
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }

        return new ResponseEntity(porg, HttpStatus.OK);

    }

    @PostMapping("/demo2/lactiveOrganization")
    public ResponseEntity<List<Organization>> getActiveOrganization(@RequestBody String val)  {
        List<Organization> porg = null;
        try {
            porg = orgService.getActiveOrganization();
        }catch (Exception e){
            e.printStackTrace();
        }

        return new ResponseEntity(porg, HttpStatus.OK);

    }

    /*
            function : list all organizations
            status: green
            unit test:red
            uat:red
     */
    @CrossOrigin
    @PostMapping("/lorganization")
    public ResponseEntity<List<Organization>> getAllOrganization() {

        List<Organization> porg = null;
        try {
            porg = orgService.getAllOrganization();
            if (Utils.isEmpty(porg.toArray()))
                throw new NoDataFoundException("No Data found");
        } catch (Exception e) {
            throw new ConstraintViolationException("error", Collections.emptySet());
        }

        return new ResponseEntity(porg, HttpStatus.OK);
    }

    /*
        function : get organization by orgId
        status : green
        unit test: red
        UAT:red
     */
    @CrossOrigin
    @PostMapping("/lorganizationById")
    public ResponseEntity<List<Organization>> getOrganizationById(@RequestBody OrganizationParam org)  {

        List<Organization> rorg = null;
        try {
            rorg = orgService.getOrganizationById(org);
            if (Utils.isEmpty(rorg.toArray()))
                throw new NoDataFoundException();
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(rorg, HttpStatus.OK);
    }

    @PostMapping("/lauditDetailsByOrg")
    public ResponseEntity<List<Audit>> getAuditDetailsByOrg(@RequestBody AuditParam auditparm) {
        List<Audit> audit = null;
        try {
            audit = orgService.getAuditDetailsByOrg(auditparm.getOrgid());
            if (Utils.isEmpty(audit.toArray())) {
                throw new NoDataFoundException("No Data found");
            }
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity<>(audit, HttpStatus.OK);
    }

    @PostMapping("/lauditDetailsByUser")
    public ResponseEntity<List<Audit>> getAuditDetailsByUser(@RequestBody AuditParam auditparm) {
        List<Audit> audit = null;
        try {
            audit = orgService.getAuditDetailsByUser(auditparm.getOrgid(), auditparm.getId());
            if (Utils.isEmpty(audit.toArray()))
                throw new NoDataFoundException("No Data found");
        } catch (Exception e) {
            logger.debug(e.getMessage());
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity<>(audit, HttpStatus.OK);
    }

    @PostMapping("/ibranch")
    public ResponseEntity<List<Branch>> addBranch(@RequestBody Branch branch)  {
        List<Branch> branches = new ArrayList<Branch>();
        try{
            branches = orgService.branchInsert(branch);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(branches, HttpStatus.OK);
    }

    @PostMapping("/lbranch")
    public ResponseEntity<List<Branch>> getBranch(@RequestBody BranchParam param)  {
        List<Branch> branches = new ArrayList<Branch>();
        try{
            orgService.getActiveBranch(param);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(orgService, HttpStatus.OK);
    }

    @PostMapping("/lbranches")
    public ResponseEntity<List<Branch>> getAllBranch(@RequestBody BranchParam param)  {
        List<Branch> branchs = null;
        try {
            branchs = orgService.getAllBranch(param);
            if (Utils.isEmpty(branchs.toArray()))
                throw new NoDataFoundException("No Data found");
        } catch (Exception e) {
            throw new ConstraintViolationException("Error", Collections.emptySet());
        }
        return new ResponseEntity(branchs, HttpStatus.OK);
    }


    @PostMapping("/dbranch")
    public ResponseEntity<List<Branch>> branchDelete(@RequestBody BranchParam param)  {
        List<Branch> branches = null;
        try{
            branches = orgService.branchDelete(param);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(branches, HttpStatus.OK);
    }

    @PostMapping("/ubranch")
    public ResponseEntity<List<Branch>> branchUpdate(@RequestBody Branch branch)  {
        List<Branch> branches = null;
        try{
            branches=orgService.branchUpdate(branch);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return new ResponseEntity(branches, HttpStatus.OK);
    }

    @PostMapping("/lacitveBranch")
    public ResponseEntity<List<Branch>> getActiveBranch(@RequestBody BranchParam param)  {
        List<Branch> branches = null;
        try{
            branches=orgService.getActiveBranch(param);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return new ResponseEntity(branches, HttpStatus.OK);
    }

    @PostMapping("/lbranchById")
    public ResponseEntity<List<Branch>> getBranchById(@RequestBody BranchParam param)  {
        List<Branch> branches = null;
        try{
            branches=orgService.getBranchById(param);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }

        return new ResponseEntity(branches, HttpStatus.OK);
    }

    @PostMapping("/ibulkBranchs")
    public ResponseEntity<List<Branch>> insertBulkBranchs(@RequestBody List<Branch> branchs)  {
        List<Branch> branches = null;
        try{
            branches = orgService.insertBulkBranch(branchs);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(branches , HttpStatus.OK);
    }

    @PostMapping("/ubulkBranchs")
    public ResponseEntity<List<Branch>> updateBulkBranchs(@RequestBody List<Branch> branchs)  {
        List<Branch> branches = null;
        try{
            branches = orgService.updateBulkBranch(branchs);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(branches, HttpStatus.OK);
    }
    /* ----------------------------------Departments ---------------------------------------*/

    @PostMapping("/lactiveDepartment")
    public ResponseEntity<List<OrgDepartment>> getActiveDepartment(@RequestBody OrgDepartment dept)  {
        List<OrgDepartment> orgDepartments = null;
        try{
            orgDepartments= orgService.getActiveDepartment(dept);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return new ResponseEntity(orgDepartments, HttpStatus.OK);
    }

    @PostMapping("/nonActiveDepartment")
    public ResponseEntity<List<OrgDepartment>> getNonActiveDepartment(@RequestBody OrgDepartment dept)  {
        List<OrgDepartment> orgDepartments = null;
        try{
            orgDepartments=orgService.getNonActiveDepartment(dept);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDepartments, HttpStatus.OK);
    }

    @PostMapping("/ldepartment")
    public ResponseEntity<List<OrgDepartment>> getAllOrgDepartment(@RequestBody OrgDepartment dept)  {
        List<OrgDepartment> orgDepartments = null;
        try{
            orgDepartments = orgService.getAllOrgDepartment(dept);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDepartments, HttpStatus.OK);
    }

    /* ok */
    @PostMapping("/idepartment")
    public ResponseEntity<List<OrgDepartment>> insertOrgDepartment(@RequestBody OrgDepartment dept)  {
        List<OrgDepartment> orgDepartments = null;
        try{
            orgDepartments = orgService.insertOrgDepartment(dept);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDepartments , HttpStatus.OK);
    }

    @PostMapping("/udepartment")
    public ResponseEntity<List<OrgDepartment>> updateOrgDepartment(@RequestBody OrgDepartment dept)  {
        List<OrgDepartment> orgDepartments = null;
        try{
            orgDepartments  = orgService.updateOrgDepartment(dept);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDepartments , HttpStatus.OK);
    }

    @PostMapping("/ddepartment")
    public ResponseEntity<List<OrgDepartment>> deleteOrgDepartment(@RequestBody OrgDepartment dept)  {
        List<OrgDepartment> orgDepartments = null;
        try{
            orgDepartments = orgService.deleteOrgDepartment(dept);
        }catch(Exception e){
            logger.error(e.getMessage());
        }
        return new ResponseEntity(orgDepartments, HttpStatus.OK);
    }

    @PostMapping("/ldepartmentById")
    public ResponseEntity<List<OrgDepartment>> getDepartmentGetById(@RequestBody OrgDepartment dept)  {
        List<OrgDepartment> orgDepartments = null;
        try{
            orgDepartments=orgService.getDepartmentGetById(dept);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDepartments, HttpStatus.OK);
    }

    @PostMapping("/ldepartmentByName")
    public ResponseEntity<List<OrgDepartment>> getDepartmentGetByName(@RequestBody OrgDepartment dept)  {
        List<OrgDepartment> orgDepartments = null;
        try{
            orgDepartments = orgService.getDepartmentGetByName(dept);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDepartments, HttpStatus.OK);
    }

    /*----------------------------------- designation ----------------------------------*/
    @PostMapping("/lactiveDesign")
    public ResponseEntity<List<OrgDesignation>> getActiveDesignation(@RequestBody OrgDesignation design)  {
        List<OrgDesignation> orgDesignations = null;
        try{
            orgDesignations = orgService.getActiveDesignation(design);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDesignations, HttpStatus.OK);
    }

    @PostMapping("/lnonActiveDesign")
    public ResponseEntity<List<OrgDesignation>> getNonActiveDesignation(@RequestBody OrgDesignation design)  {
        List<OrgDesignation> orgDesignations = null;
        try{
            orgDesignations =orgService.getNonActiveDesignation(design);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDesignations, HttpStatus.OK);
    }

    @PostMapping("/ldisignation")
    public ResponseEntity<List<OrgDesignation>> getAllOrgDesignation(@RequestBody OrgDesignation design)  {
        List<OrgDesignation> orgDesignations = null;
        try{
            orgDesignations=orgService.getAllOrgDesignation(design);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDesignations , HttpStatus.OK);
    }

    @PostMapping("/idesignation")
    public ResponseEntity<List<OrgDesignation>> insertOrgDesignation(@RequestBody OrgDesignation desg)  {
        List<OrgDesignation> orgDesignations = null;
        try{
            orgDesignations =orgService.insertOrgDesignation(desg);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDesignations, HttpStatus.OK);
    }

    @PostMapping("/udesignation")
    public ResponseEntity<List<OrgDesignation>> updateOrgDesignation(@RequestBody OrgDesignation desg)  {
        List<OrgDesignation> orgDesignations = null;
        try{
            orgDesignations = orgService.updateOrgDesignation(desg);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDesignations , HttpStatus.OK);
    }

    @PostMapping("/ddesignation")
    public ResponseEntity<List<OrgDesignation>> deleteOrgDesignation(@RequestBody OrgDesignation desg)  {
        List<OrgDesignation> orgDesignations = null;
        try{
            orgDesignations = orgService.deleteOrgDesignation(desg);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDesignations, HttpStatus.OK);
    }

    @PostMapping("/ldesignationById")
    public ResponseEntity<List<OrgDesignation>> getDesignationGetById(@RequestBody OrgDesignation desg)  {
        List<OrgDesignation> orgDesignations = null;
        try{
            orgDesignations=orgService.getDesignationGetById(desg);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDesignations , HttpStatus.OK);
    }

    @PostMapping("/ldesignationByName")
    public ResponseEntity<List<OrgDesignation>> getDesignationGetByName(@RequestBody OrgDesignation desg)  {
        List<OrgDesignation> orgDesignations = null;
        try{
            orgDesignations= orgService.getDesignationGetByName(desg);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgDesignations, HttpStatus.OK);
    }

    /*-------------------------------------batchs----------------------------------------*/
    @PostMapping("/ibatch")
    public ResponseEntity<List<BatchesLookup>> insertBatch(@RequestBody BatchesLookup batch) {
        List<BatchesLookup> batchesLookup = null;
        try{
            batchesLookup=orgService.insertBatch(batch);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(batchesLookup, HttpStatus.OK);
    }

    @PostMapping("/ubatch")
    public ResponseEntity<List<BatchesLookup>> updateBatch(@RequestBody BatchesLookup batch)  {
        List<BatchesLookup> batchesLookup = null;
        try{
            batchesLookup =orgService.updateBatch(batch);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(batchesLookup, HttpStatus.OK);
    }

    @PostMapping("/dbatch")
    public ResponseEntity<List<BatchesLookup>> deleteBatch(@RequestBody BatchesLookup batch)  {
        List<BatchesLookup> batchesLookup = null;
        try{
            batchesLookup= orgService.deleteBatch(batch);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(batchesLookup, HttpStatus.OK);
    }

    @PostMapping("/lbatchByName")
    public ResponseEntity<List<BatchesLookup>> batchByName(@RequestBody BatchesLookup batch)  {
        List<BatchesLookup> batchesLookup = null;
        try{
            batchesLookup= orgService.batchByName(batch);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(batchesLookup, HttpStatus.OK);
    }

    @PostMapping("/lbatchById")
    public ResponseEntity<List<BatchesLookup>> batchById(@RequestBody BatchesLookup batch)  {
        List<BatchesLookup> batchesLookup = null;
        try{
            batchesLookup= orgService.batchById(batch);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(batchesLookup, HttpStatus.OK);
    }

    @PostMapping("/lbatchByOrgid")
    public ResponseEntity<List<BatchesLookup>> batchByOrgId(@RequestBody BatchesLookup batch)  {
        List<BatchesLookup> batchesLookup = null;
        try{
            batchesLookup= orgService.batchByOrgId(batch);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(batchesLookup, HttpStatus.OK);
    }

    @PostMapping("/lactiveBatch")
    public ResponseEntity<List<BatchesLookup>> activeBatches(@RequestBody BatchesLookup batch)  {
        List<BatchesLookup> batchesLookup = null;
        try{
            batchesLookup=orgService.activeBatches(batch);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(batchesLookup , HttpStatus.OK);
    }

    /*----------------------------------------------- course level ---------------------------------------*/
    /* testing pending */
    @PostMapping("/icourseLevel")
    public ResponseEntity<List<CourseLevelLookup>> insertCourseLevel(@RequestBody CourseLevelLookup course)  {
        List<CourseLevelLookup> courseLevelLookups = null;
        try{
            courseLevelLookups= orgService.insertCourseLevel(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseLevelLookups, HttpStatus.OK);
    }

    /* testing pending */
    @PostMapping("/ucourseLevel")
    public ResponseEntity<List<CourseLevelLookup>> updateCourseLevel(@RequestBody CourseLevelLookup course)  {
        List<CourseLevelLookup> courseLevelLookups = null;
        try{
            courseLevelLookups= orgService.updateCourseLevel(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseLevelLookups, HttpStatus.OK);
    }

    /* functionality pending */
    /*@PostMapping("/dcourseLevel")
    public List<CourseLevelLookup> deleteCourseLevel(@RequestBody CourseLevelLookup course) throws SQLException {
       return new ResponseEntity(orgService.deleteCourseLevel(course),HttpStatus.OK);
    }*/
    /* smoke testing done */
    @PostMapping("/lcourseLevelById")
    public ResponseEntity<List<CourseLevelLookup>> courseLevelByTitle(@RequestBody CourseLevelLookup course)  {
        List<CourseLevelLookup> courseLevelLookups = null;
        try{
            courseLevelLookups= orgService.courseLevelByTitle(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseLevelLookups, HttpStatus.OK);
    }

    /* smoke testing done */
    @PostMapping("/lcourseLevelByGroup")
    public ResponseEntity<List<CourseLevelLookup>> courseLevelByGroup(@RequestBody CourseLevelLookup course)  {
        List<CourseLevelLookup> courseLevelLookups = null;
        try{
            courseLevelLookups= orgService.courseLevelByGroup(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseLevelLookups, HttpStatus.OK);
    }

    /* smoke testing done */
    @PostMapping("/lcourseLevelByCountry")
    public ResponseEntity<List<CourseLevelLookup>> courseLevelByArea(@RequestBody CourseLevelLookup course)  {
        List<CourseLevelLookup> courseLevelLookups = null;
        try{
            courseLevelLookups= orgService.courseLevelByCounrty(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseLevelLookups, HttpStatus.OK);
    }
    /*-------------------------------------------course category -----------------------------------------*/

    /* testing pending */
    @PostMapping("/icourseCategory")
    public ResponseEntity<List<CourseCategory>> insertCourseCategory(@RequestBody CourseCategory course)  {
        List<CourseCategory> courseCategory = null;
        try{
            courseCategory=  orgService.insertCourseCategory(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseCategory, HttpStatus.OK);
    }

    /* testing pending */
    @PostMapping("/ucourseCategory")
    public ResponseEntity<List<CourseCategory>> updateCourseLevel(@RequestBody CourseCategory course)  {
        List<CourseCategory> courseCategory = null;
        try{
            courseCategory=  orgService.updateCourseCategory(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseCategory, HttpStatus.OK);
    }

    @PostMapping("/lcourseCategories")
    public ResponseEntity<List<CourseCategory>> courseCategories(@RequestBody CourseCategory course)  {
        List<CourseCategory> courseCategory = null;
        try{
            courseCategory=  orgService.courseCategories(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseCategory, HttpStatus.OK);
    }

    @PostMapping("/getBranchCourseClassById")
    public ResponseEntity<List<OrgClasses>> getBranchCourseClassById(@RequestBody ObjectNode courseClass)  {
        List<OrgClasses> orgclasses = null;
        try{
            orgclasses=  orgService.getBranchCourseClassById(courseClass);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgclasses,HttpStatus.OK);
    }
    @PostMapping("/getTermMapTermFee")
    public ResponseEntity<TermMapTermFee> getTermMapTermFee(@RequestBody ObjectNode object){
        List<TermMapTermFee> termMapTermFee = new ArrayList<TermMapTermFee>();
        try{
            termMapTermFee = orgService.getTermMapTermFee(object);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(termMapTermFee,HttpStatus.OK);
    }
    @PostMapping("/getTermFeeByTermList")
    public ResponseEntity<List<TermFees>> getTermFeeByTermList(@RequestBody TermFees termfees){
        List<TermFees> termFees = new ArrayList<TermFees>();
        try{
            termFees = orgService.getTermFeeByTermList(termfees);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(termFees,HttpStatus.OK);
    }
    /*-------------------------------------- course classes -------------------------------------*/
    @PostMapping("/icourseClasses")
    public ResponseEntity<List<CourseClasses>> insertCourseClass(@RequestBody CourseClasses classes)  {

        List<CourseClasses> courseclasses = null;
        try{
            courseclasses= orgService.insertCourseClass(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseclasses, HttpStatus.OK);
    }

    @PostMapping("/ucourseClasses")
    public ResponseEntity<List<CourseClasses>> updateCourseClass(@RequestBody CourseClasses classes)  {
        List<CourseClasses> courseclasses = null;
        try{
            courseclasses= orgService.updateCourseClass(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseclasses, HttpStatus.OK);
    }

    @PostMapping("/lcourseClassesByCode")
    public ResponseEntity<List<CourseClasses>> getCourseClassByCode(@RequestBody CourseClasses classes)  {
        List<CourseClasses> courseclasses = null;
        try{
            courseclasses=orgService.getCourseClassByCode(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseclasses , HttpStatus.OK);
    }

    @PostMapping("/lcourseClassesByStudyCode")
    public ResponseEntity<List<CourseClasses>> getCourseClassByStudyCode(@RequestBody CourseClasses classes)  {
        List<CourseClasses> courseclasses = null;
        try{
            courseclasses=orgService.getCourseClassByStudyCode(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseclasses, HttpStatus.OK);
    }

    /*--------------------------------- class subject ----------------------------*/
    @PostMapping("/iclassSubject")
    public ResponseEntity<List<ClassSubject>> insertClassSubject(@RequestBody ClassSubject subject)  {
        List<ClassSubject> classSubjects = null;
        try{
            classSubjects= orgService.insertClassSubject(subject);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity((List<ClassSubject>) classSubjects, HttpStatus.OK);
    }

    @PostMapping("/uclassSubject")
    public ResponseEntity<List<ClassSubject>> updateClassSubject(@RequestBody ClassSubject subject)  {
        List<ClassSubject> classSubjects = null;
        try{
            classSubjects=orgService.updateClassSubject(subject);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity((List<ClassSubject>)classSubjects , HttpStatus.OK);
    }

    @PostMapping("lclassSubjectById")
    public ResponseEntity<List<ClassSubject>> getClassSubjectById(@RequestBody ClassSubject subject)  {
        List<ClassSubject> classSubjects = null;
        try{
            classSubjects=orgService.getClassSubjectById(subject);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity((List<ClassSubject>) classSubjects , HttpStatus.OK);
    }

    @PostMapping("/lclassSubjectByClsId")
    public ResponseEntity<List<ClassSubject>> getClassSubjectByClsId(@RequestBody ClassSubject subject) {
        List<ClassSubject> classSubjects = null;
        try{
            classSubjects=orgService.getClassSubjectByClsId(subject);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity((List<ClassSubject>) classSubjects , HttpStatus.OK);
    }

    @PostMapping("/lclassSubject")
    public ResponseEntity<List<ClassSubject>> getClassSubject()  {
        List<ClassSubject> classSubjects = null;
        try{
            classSubjects= orgService.getClassSubject();
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity((List<ClassSubject>) classSubjects, HttpStatus.OK);
    }

    /*------------------------------- organization classes ------------------------------------*/
    @PostMapping("/iorgClasses")
    public ResponseEntity<List<OrgClasses>> insertOrgClasses(@RequestBody OrgClasses classes)  {
        List<OrgClasses> orgclasses = null;
        try{
            orgclasses=orgService.insertOrgClasses(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity((List<OrgClasses>) orgclasses , HttpStatus.OK);
    }

    @PostMapping("/uorgClasses")
    public ResponseEntity<List<OrgClasses>> updateOrgClass(@RequestBody OrgClasses classes)  {
        List<OrgClasses> orgclasses = null;
        try{
            orgclasses=orgService.updateOrgClass(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgclasses , HttpStatus.OK);
    }

    @PostMapping("/lbranchAacademicClasses")
    public ResponseEntity<List<OrgClasses>> getOrgClassByOrgID(@RequestBody OrgClasses classes)  {
        List<OrgClasses> orgclasses = null;
        try{
            orgclasses=orgService.getOrgClassByOrgID(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgclasses , HttpStatus.OK);
    }

    @PostMapping("/lorgClassesByClsId")
    public ResponseEntity<List<OrgClasses>> getOrgClassesByClsId(@RequestBody OrgClasses classes)  {
        List<OrgClasses> orgclasses = null;
        try{
            orgclasses=orgService.getOrgClassesByClsId(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity((List<OrgClasses>)orgclasses , HttpStatus.OK);
    }

    /*-----------------------------------------------study branch -------------------------------------*/


    @PostMapping("/istudyBranch")
    public ResponseEntity<List<StudyBranchLookup>> insertStudyBranch(@RequestBody StudyBranchLookup study)  {
        List<StudyBranchLookup> branchLookups = null;
        try{
            branchLookups=orgService.insertStudyBranch(study);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(branchLookups , HttpStatus.OK);
    }

    @PostMapping("/dStudyBranch")
    public ResponseEntity<List<StudyBranchLookup>> deleteStudyBranch(@RequestBody StudyBranchLookup study)  {
        List<StudyBranchLookup> branchLookups = null;
        try{
            branchLookups=orgService.deleteStudyBranch(study);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(branchLookups , HttpStatus.OK);
    }

    @PostMapping("/lstudyBranch")
    public ResponseEntity<List<StudyBranchLookup>> studyBranchList(@RequestBody StudyBranchLookup study)  {
        List<StudyBranchLookup> branchLookups = null;
        try{
            branchLookups=orgService.studyBranchList(study);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(branchLookups, HttpStatus.OK);
    }

    @PostMapping("/idistrict")
    public ResponseEntity<List<DistrictLookup>> insertDistrict(@RequestBody DistrictLookup district)  {
        List<DistrictLookup> districtLookup = null;
        try{
            districtLookup=orgService.insertDistrict(district);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(districtLookup , HttpStatus.OK);
    }

    @PostMapping("/udistrict")
    public ResponseEntity<List<DistrictLookup>> updateDistrict(@RequestBody DistrictLookup district)  {
        List<DistrictLookup> districtLookup = null;
        try{
            districtLookup=orgService.updateDistrict(district);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(districtLookup , HttpStatus.OK);
    }

    @PostMapping("/ddistrict")
    public ResponseEntity<List<DistrictLookup>> deleteDistrict(@RequestBody DistrictLookup district)  {
        List<DistrictLookup> districtLookup = null;
        try{
            districtLookup=orgService.deleteDistrict(district);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(districtLookup , HttpStatus.OK);
    }

    @PostMapping("/ldistrictById")
    public ResponseEntity<List<DistrictLookup>> districtById(@RequestBody DistrictLookup district)  {
        List<DistrictLookup> districtLookup = null;
        try{
            districtLookup=orgService.districtById(district);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(districtLookup , HttpStatus.OK);
    }

    @PostMapping("/ldistrictByName")
    public ResponseEntity<List<DistrictLookup>> districtByName(@RequestBody DistrictLookup district)  {
        List<DistrictLookup> districtLookup = null;
        try{
            districtLookup=orgService.districtByName(district);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(districtLookup , HttpStatus.OK);
    }

    @PostMapping("/ldistrictByState")
    public ResponseEntity<List<DistrictLookup>> districtByState(@RequestBody DistrictLookup district)  {
        List<DistrictLookup> districtLookup = null;
        try{
            districtLookup=orgService.districtByState(district);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(districtLookup , HttpStatus.OK);
    }

    @PostMapping("/imandal")
    public ResponseEntity<List<MandalLookup>> insertMandal(@RequestBody MandalLookup mandal)  {
        List<MandalLookup> mandalLookup= null;
        try{
            mandalLookup=orgService.insertMandal(mandal);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(mandalLookup , HttpStatus.OK);
    }

    @PostMapping("/umandal")
    public ResponseEntity<List<MandalLookup>> updateMandal(@RequestBody MandalLookup mandal)  {
        List<MandalLookup> mandalLookup= null;
        try{
            mandalLookup=orgService.updateMandal(mandal);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(mandalLookup , HttpStatus.OK);
    }

    @PostMapping("/dmandal")
    public ResponseEntity<List<MandalLookup>> deleteMandal(@RequestBody MandalLookup mandal)  {
        List<MandalLookup> mandalLookup= null;
        try{
            mandalLookup=orgService.deleteMandal(mandal);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(mandalLookup , HttpStatus.OK);
    }

    @PostMapping("/lmandalById")
    public ResponseEntity<List<MandalLookup>> mandalById(@RequestBody MandalLookup mandal)  {
        List<MandalLookup> mandalLookup= null;
        try{
            mandalLookup=orgService.mandalById(mandal);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(mandalLookup , HttpStatus.OK);
    }

    @PostMapping("/lmandalByName")
    public ResponseEntity<List<MandalLookup>> mandalByName(@RequestBody MandalLookup mandal)  {
        List<MandalLookup> mandalLookup = null;
        try{
            mandalLookup=orgService.mandalByName(mandal);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(mandalLookup , HttpStatus.OK);
    }

    @PostMapping("/lmandalByDistrict")
    public ResponseEntity<List<MandalLookup>> mandalByDistrict(@RequestBody MandalLookup mandal)  {
        List<MandalLookup> mandalookup = null;
        try{
            mandalookup=orgService.mandalByDistrict(mandal);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(mandalookup, HttpStatus.OK);
    }

    @PostMapping("/izone")
    public ResponseEntity<List<ZoneLookup>> insertZone(@RequestBody ZoneLookup zone)  {
        List<ZoneLookup> zonelookup = null;
        try{
            zonelookup=orgService.insertZone(zone);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(zonelookup , HttpStatus.OK);
    }

    @PostMapping("/uzone")
    public ResponseEntity<List<ZoneLookup>> updateZone(@RequestBody ZoneLookup zone)  {
        List<ZoneLookup> zonelookup = null;
        try{
            zonelookup=orgService.updateZone(zone);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(zonelookup , HttpStatus.OK);
    }

    @PostMapping("/dzone")
    public ResponseEntity<List<ZoneLookup>> deleteZone(@RequestBody ZoneLookup zone)  {
        List<ZoneLookup> zonelookup = null;
        try{
            zonelookup=orgService.deleteZone(zone);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(zonelookup , HttpStatus.OK);
    }

    @PostMapping("/lzoneById")
    public ResponseEntity<List<ZoneLookup>> zoneById(@RequestBody ZoneLookup zone)  {
        List<ZoneLookup> zonelookup = null;
        try{
            zonelookup=orgService.zoneById(zone);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(zonelookup , HttpStatus.OK);
    }

    @PostMapping("/lzoneByName")
    public ResponseEntity<List<ZoneLookup>> zoneByName(@RequestBody ZoneLookup zone)  {
        List<ZoneLookup> zonelookup = null;
        try{
            zonelookup=orgService.zoneByName(zone);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(zonelookup , HttpStatus.OK);
    }

    @PostMapping("/lzoneByState")
    public ResponseEntity<List<ZoneLookup>> zoneByState(@RequestBody ZoneLookup zone)  {
        List<ZoneLookup> zonelookup = null;
        try{
            zonelookup=orgService.zoneByState(zone);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(zonelookup , HttpStatus.OK);
    }

    @PostMapping("/icategory")
    public ResponseEntity<List<CategoryLookup>> insertCategory(@RequestBody CategoryLookup category)  {
        List<CategoryLookup> categoryLookup = null;
        try{
            categoryLookup=orgService.insertCategory(category);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(categoryLookup , HttpStatus.OK);
    }

    @PostMapping("/ucategory")
    public ResponseEntity<List<CategoryLookup>> updateCategory(@RequestBody CategoryLookup category)  {
        List<CategoryLookup> categoryLookup = null;
        try{
            categoryLookup=orgService.updateCategory(category);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(categoryLookup , HttpStatus.OK);
    }

    @PostMapping("/dcategory")
    public ResponseEntity<List<CategoryLookup>> deleteCategory(@RequestBody CategoryLookup category)  {
        List<CategoryLookup> categoryLookup = null;
        try{
            categoryLookup=orgService.deleteCategory(category);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(categoryLookup , HttpStatus.OK);
    }

    @PostMapping("/lcategoryByName")
    public ResponseEntity<List<CategoryLookup>> categoryByName(@RequestBody CategoryLookup category)  {
        List<CategoryLookup> categoryLookup = null;
        try{
            categoryLookup=orgService.categoryByName(category);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(categoryLookup , HttpStatus.OK);
    }

    @PostMapping("/lcategories")
    public ResponseEntity<List<CategoryLookup>> categories(@RequestBody CategoryLookup category)  {
        List<CategoryLookup> categoryLookup = null;
        try{
            categoryLookup=orgService.categories(category);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(categoryLookup , HttpStatus.OK);
    }

    /*-----------------------------------academic year -------------------------------------------*/

    @PostMapping("/lacademicYearByOrgId")
    public ResponseEntity<List<AcademicYear>> academicYearByOrgId(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.academicYearByOrgId(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/iacademicYear")
    public ResponseEntity<List<AcademicYear>> insertAcademicYear(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.insertAcademicYear(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/uacademicYear")
    public ResponseEntity<List<AcademicYear>> updateAcademicYear(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.updateAcademicYear(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/dacademicYear")
    public ResponseEntity<List<AcademicYear>> deleteAcademicYear(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.deleteAcademicYear(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/lacademicYearById")
    public ResponseEntity<List<AcademicYear>> academicYearById(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.academicYearById(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/lacadmeicYearByBatch")
    public ResponseEntity<List<AcademicYear>> academicYearByBatch(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.academicYearByBatch(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/lacademicYearByYear")
    public ResponseEntity<List<AcademicYear>> academicYearByYear(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.academicYearByYear(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/lactiveAcademicYear")
    public ResponseEntity<List<AcademicYear>> allActiveAcademicYear(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.allActiveAcademicYear(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/lacademicYearByCourse")
    public ResponseEntity<List<AcademicYear>> academicYearByCourse(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.academicYearByCourse(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/lacademicYear")
    public ResponseEntity<List<AcademicYear>> academicYear(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.academicYear(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears , HttpStatus.OK);
    }

    @PostMapping("/lactiveAdmissionYear")
    public ResponseEntity<List<AcademicYear>> aciveAdmissionYear(@RequestBody AcademicYear academic)  {
        List<AcademicYear> academicYears = null;
        try{
            academicYears=orgService.aciveAdmissionYear(academic);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(academicYears, HttpStatus.OK);
    }


    @PostMapping("/iterm")
    public ResponseEntity<List<Terms>> insertTerm(@RequestBody List<Terms> term)  {
        List<Terms> terms = null;
        try{
            terms=orgService.insertTerm(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(terms , HttpStatus.OK);
    }

    @PostMapping("/uterm")
    public ResponseEntity<List<Terms>> updateTerm(@RequestBody Terms term)  {
        List<Terms> terms = null;
        try{
            terms=orgService.updateTerm(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(terms , HttpStatus.OK);
    }

    @PostMapping("/dterm")
    public ResponseEntity<List<Terms>> deleteTerm(@RequestBody Terms term)  {
        List<Terms> terms = null;
        try{
            terms=orgService.deleteTerm(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(terms , HttpStatus.OK);
    }

    @PostMapping("/dterms")
    public ResponseEntity<List<Terms>> deleteClassTerm(@RequestBody List<Terms> term)  {
        List<Terms> terms = null;
        try{
            terms=orgService.deleteTermList(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(terms , HttpStatus.OK);
    }
    @PostMapping("/ltermByAcademicYear")
    public ResponseEntity<List<Terms>> termByAacademicYear(@RequestBody Terms term)  {
        List<Terms> terms = null;
        try{
            terms=orgService.termByAacademicYear(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(terms , HttpStatus.OK);
    }

    @PostMapping("/ltermById")
    public ResponseEntity<List<Terms>> termById(@RequestBody Terms term)  {
        List<Terms> terms = null;
        try{
            terms=orgService.termById(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(terms , HttpStatus.OK);
    }

    @PostMapping("/getTermByAyCourseCategory")
    public ResponseEntity<List<Terms>> getTermByAyCourseCategory(@RequestBody Terms terms) {
        List<Terms> listterms = new ArrayList<Terms>();
        try{
            listterms = orgService.getTermByAyCourseCategory(terms);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(listterms,HttpStatus.OK);
    }
    @PostMapping("/getTermsAyCourseClsCategory")
    public ResponseEntity<List<Terms>> getTermsAyCourseClsCategory(@RequestBody Terms terms){
        List<Terms> listterms = new ArrayList<Terms>();
        try{
            listterms = orgService.getTermsAyCourseClsCategory(terms);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(listterms,HttpStatus.OK);
    }
    @PostMapping("/getTermsAyCourseClass")
    public ResponseEntity<List<Terms>> getTermsByAyCourseClass(@RequestBody Terms terms){
        List<Terms> listterms = new ArrayList<Terms>();
        try{
            listterms = orgService.getTermsByAyCourseClass(terms);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(listterms,HttpStatus.OK);
    }
    @PostMapping("/insertFeeHeaders")
    public ResponseEntity<List<FeeHeaders>> insertFeeHeaders(@RequestBody FeeHeaders feeheader) {
        List<FeeHeaders> headers = null;
        try{
                headers = orgService.insertFeeHeaders(feeheader);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(headers,HttpStatus.OK);
    }
    @PostMapping("/updateFeeHeaders")
    public ResponseEntity<List<FeeHeaders>> updateFeeHeaders(@RequestBody FeeHeaders feeheader) {
        List<FeeHeaders> feeHeaders = null;
        try{
            feeHeaders = orgService.updateFeeHeaders(feeheader);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity(feeHeaders,HttpStatus.OK);
    }
    @PostMapping("/deleteFeeHeaders")
    public ResponseEntity<List<FeeHeaders>> deleteFeeHeaders(@RequestBody FeeHeaders feeheader) {
        List<FeeHeaders> feeHeaders = null;
        try {
            feeHeaders = orgService.deleteFeeHeaders(feeheader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(feeHeaders, HttpStatus.OK);
    }
    @PostMapping("/deleteFeeHeaderList")
    public ResponseEntity<List<FeeHeaders>> deleteFeeHeaders(@RequestBody List<FeeHeaders> feeheader) {
        List<FeeHeaders> feeHeaders = null;
        List<FeeHeaders> fees = new ArrayList<FeeHeaders>();
        try {
            for(FeeHeaders fee:feeheader){
                if(fee.getFh_id() !=0)
                    fees.add(fee);
            }
            if(fees.size()>0)
                 feeHeaders = orgService.deleteFeeHeaderList(fees);
            else
                feeHeaders = orgService.feeHeadersList(feeheader.get(0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(feeHeaders, HttpStatus.OK);
    }
    @PostMapping("/feeheadersList")
    public ResponseEntity<List<FeeHeaders>> feeHeadersList(@RequestBody FeeHeaders feeheader){
            List<FeeHeaders> feeHeaders = null;
            try {
                feeHeaders = orgService.feeHeadersList(feeheader);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new ResponseEntity(feeHeaders, HttpStatus.OK);
        }
    @PostMapping("/insertFeeHeadersList")
    public ResponseEntity<List<FeeHeaders>> insertFeeHeadersList(@RequestBody List<FeeHeaders> feeheader) {
        List<FeeHeaders> feeHeaders = null;
        try {

                feeHeaders = orgService.insertFeeHeaderList(feeheader);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(feeHeaders, HttpStatus.OK);
    }

    @PostMapping("/insertTermFee")
    public ResponseEntity<List<TermFees>> insertTermFee(@RequestBody TermFees termfee) {
        List<TermFees> termfees = null;
        try {
            termfees = orgService.insertTermFee(termfee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(termfee, HttpStatus.OK);
    }
    @PostMapping("/updateTermFee")
    public ResponseEntity<List<TermFees>>  updateTermFee(@RequestBody TermFees termfee) {
        List<TermFees> termfees = null;
        try {
            termfees = orgService.updateTermFee(termfee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(termfee, HttpStatus.OK);
    }
    @PostMapping("/deleteTermFee")
    public ResponseEntity<List<TermFees>>  deleteTermFee(@RequestBody TermFees termfee) {
        List<TermFees> termfees = null;
        try {
            termfees = orgService.deleteTermFee(termfee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(termfee, HttpStatus.OK);
    }
    @PostMapping("/termFeeList")
    public ResponseEntity<List<TermFees>>  termFeeList(@RequestBody TermFees termfee) {
        List<TermFees> termfees = null;
        try {
            termfees = orgService.termFeeList(termfee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(termfee, HttpStatus.OK);
    }

    @PostMapping("/ltermByTitle")
    public ResponseEntity<List<Terms>> termByTitle(@RequestBody Terms term)  {
        List<Terms> terms = null;
        try{
            terms = orgService.termByTitle(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(terms , HttpStatus.OK);
    }

    @PostMapping("/icourses")
    public ResponseEntity<List<CoursesLookup>> insertCourses(@RequestBody CoursesLookup course)  {
        List<CoursesLookup> courseslookup = null;
        try{
            courseslookup = orgService.insertCourses(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseslookup , HttpStatus.OK);
    }

    @PostMapping("/ucourses")
    public ResponseEntity<List<CoursesLookup>> updateCourses(@RequestBody CoursesLookup course)  {
        List<CoursesLookup> courseslookup = null;
        try{
            courseslookup = orgService.updateCourses(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseslookup , HttpStatus.OK);
    }

    @PostMapping("/dcourses")
    public ResponseEntity<List<CoursesLookup>> deleteCourses(@RequestBody CoursesLookup course)  {
        List<CoursesLookup> courseslookup = null;
        try{
            courseslookup = orgService.deleteCourses(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseslookup , HttpStatus.OK);
    }

    @PostMapping("/lcourseById")
    public ResponseEntity<List<CoursesLookup>> coursesById(@RequestBody CoursesLookup course)  {
        List<CoursesLookup> courseslookup = null;
        try{
            courseslookup = orgService.coursesById(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseslookup , HttpStatus.OK);
    }

    @PostMapping("/lcoursesByTitle")
    public ResponseEntity<List<CoursesLookup>> coursesByTitle(@RequestBody CoursesLookup course)  {
        List<CoursesLookup> courseslookup = null;
        try{
            courseslookup = orgService.coursesByTitle(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseslookup , HttpStatus.OK);
    }

    @PostMapping("/lcourseByShortTitle")
    public ResponseEntity<List<CoursesLookup>> coursesByStitle(@RequestBody CoursesLookup course)  {
        List<CoursesLookup> courseslookup = null;
        try{
            courseslookup = orgService.coursesByStitle(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseslookup , HttpStatus.OK);
    }

    @PostMapping("/lcoursesByCourseLevel")
    public ResponseEntity<List<CoursesLookup>> coursesByCourseLevel(@RequestBody CoursesLookup course)  {
        List<CoursesLookup> courseslookup = null;
        try{
            courseslookup = orgService.coursesByCourseLevel(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseslookup , HttpStatus.OK);
    }
    @PostMapping("/activeAyBranchClasses")
    public ResponseEntity<List<OrgClasses>> activeAyBranchClasses(@RequestBody OrgClasses classes) {
        List<OrgClasses> orgClasses = null;
        try{
            orgClasses = orgService.activeAyBranchClasses(classes);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(orgClasses,HttpStatus.OK);
    }
    @PostMapping("/lcoursesByBranch")
    public ResponseEntity<List<CoursesLookup>> coursesByBranch(@RequestBody CoursesLookup course)  {
        List<CoursesLookup> courseslookup = null;
        try{
            courseslookup=orgService.coursesByBranch(course);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(courseslookup , HttpStatus.OK);
    }

    @PostMapping("/itermList")
    public ResponseEntity<List<TermLookUp>> insertTermLookup(@RequestBody TermLookUp term)  {
        List<TermLookUp> termlookups = null;
        try{
            termlookups = orgService.insertTermLookup(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(termlookups , HttpStatus.OK);
    }

    @PostMapping("/dtermList")
    public ResponseEntity<List<TermLookUp>> deleteTermLookUp(@RequestBody TermLookUp term)  {
        List<TermLookUp> termlookups = null;
        try{
            termlookups = orgService.deleteTermLookUp(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(termlookups , HttpStatus.OK);
    }

    @PostMapping("/utermList")
    public ResponseEntity<List<TermLookUp>> updateTermLookUp(@RequestBody TermLookUp term)  {
        List<TermLookUp> termlookups = null;
        try{
            termlookups=orgService.updateTermLookUp(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(termlookups , HttpStatus.OK);
    }

    @PostMapping("/ltermListByTitle")
    public ResponseEntity<List<TermLookUp>> getTermLookUpTitle(@RequestBody TermLookUp term)  {
        List<TermLookUp> termlookups = null;
        try{
            termlookups=orgService.getTermLookUpTitle(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(termlookups , HttpStatus.OK);

    }

    @PostMapping("/ltermList")
    public ResponseEntity<List<TermLookUp>> getTermLookUps(@RequestBody TermLookUp term)  {
        List<TermLookUp> termlookups = null;
        try{
            termlookups =orgService.getTermLookUps(term);
        }catch(Exception e){
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return new ResponseEntity(termlookups , HttpStatus.OK);
    }


}
