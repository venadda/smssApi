package com.smss.api.system.services;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smss.api.smssApi.apiclazz.*;
import com.smss.api.smssApi.model.user.Userphoto;
import com.smss.api.system.daos.UserDao;
import com.smss.api.system.mapper.*;
import com.smss.api.system.models.*;
import org.hibernate.mapping.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Autowired
    public UserDao userDao;

    public TeacherDetails getTeacherDetails(EmployeeParam emp) throws Exception{
       return userDao.getUserDetails(emp);
    }
    public void insertTeacher(ObjectNode object) throws Exception{
         userDao.insertTeacher(object);
    }
    public List<Employee> getOrgUserByName(EmployeeParam emp)throws Exception {
        return userDao.getOrgUserByName(emp);
    }

    public List<Employee> allUser(EmployeeParam emp) throws Exception{
        return userDao.allUser(emp);
    }
    public List<Employee> allUserByRole(EmployeeParam emp) throws Exception {
        System.out.println(userDao.allUserByRole(emp));
        return userDao.allUserByRole(emp);
    }
    public boolean insertUser(Employee emp) throws Exception {
        return userDao.insertUser(emp);
    }

    public boolean updateUser(Employee emp) throws Exception {
        return userDao.updateUser(emp);
    }

    public List<Employee> deleteUser(EmployeeParam emp) throws Exception {
        return userDao.deleteUser(emp);
    }

    public List<Employee> orgUserById(EmployeeParam emp) throws Exception {
        return userDao.orgUserById(emp);
    }

    public List<Employee> orgUserByEmailId(EmployeeParam emp) throws Exception {
        return userDao.orgUserByEmailId(emp);
    }

    public List<Employee> insertBulkUser(List<Employee> emps) throws Exception {
        return userDao.insertBulkUsers(emps);
    }

    public List<Employee> updateBulkUser(List<Employee> emps) throws Exception {
        return userDao.updateBulkUsers(emps);
    }


    public List<Userphoto> insertUserPhoto() throws Exception {
        return null;
    }

    public List<Userphoto> updateUserPhoto() throws Exception {
        return null;
    }

    public List<Userphoto> userPhotoById()throws Exception {
        return null;
    }

    public List<Userphoto> deleteUserPhoto()throws Exception {
        return null;
    }

    public List<Others> getAllOthers(EmployeeParam other)throws Exception {
        return userDao.getAllOthers(other);
    }

    public List<Others> insertOthers(Others others) throws Exception{
        return userDao.insertOthers(others);
    }

    public List<Others> updateOthers(Others others) throws Exception {
        return userDao.updateOthers(others);
    }

    public List<Others> getOthersById(EmployeeParam param) throws Exception {
        return userDao.getOthersById(param);
    }

    public List<Others> deleteOthers(EmployeeParam param) throws Exception {
        return userDao.deleteOthers(param);
    }

    public List<UserRoles> UserAssignedRolesByUserId(RoleParams params) throws Exception {
        return userDao.UserAssignedRolesByUserId(params);
    }

    public List<UserRoles> allUserAndRoles(RoleParams params) throws Exception {
        return userDao.allUserAndRoles(params);
    }

    public List<UserRoles> assignRolesToUser(OrgUserRoles roles) throws Exception {
        return userDao.assignRolesToUser(roles);
    }

    /* user modules */
    public List<SystemUserModules> userAssignedModulesById(SysUserPermissionParams param) throws Exception {
        return userDao.userAssignedModulesById(param);
    }

    public List<SystemUserModules> insertUserModule(Usermodule module) throws Exception {
        return userDao.insertUserModule(module);
    }

    public List<SystemUserModules> updateUserModule(Usermodule module) throws Exception {
        return userDao.updateUserModule(module);
    }

    public List<Audit> auditDetailsByDateRange(AuditParam param) throws Exception {
        return userDao.auditDetailsByDateRange(param);
    }

    public List<Audit> auditDetailsByDate(AuditParam param) throws Exception {
        return userDao.auditDetailsByDate(param);
    }

    public List<Audit> auditDetailsByCurrentDate(AuditParam param) throws Exception {
        return userDao.auditDetailsByCurrentDate(param);
    }

    public List<Generics> allGenerics() throws Exception{
        return userDao.allGenerics();
    }
    public List<Roles> getAllRoles() throws Exception{
        return userDao.getAllRoles();
    }

    /* previous history */
    /* education history*/
    /* achievement history*/
    /* training given */
    /* training received*/


    public List<JoiningInfo> insertUserJoiningDetails(JoiningInfo joinings) throws Exception {
        return userDao.insertUserJoiningDetails(joinings);
    }

    public List<JoiningInfo> updateUserJoiningDetails(List<JoiningInfo> joinings)throws Exception {
        return userDao.updateUserJoiningDetails(joinings);
    }


    public List<JoiningInfo> deleteUserJoiningDetails(List<JoiningInfo> joinings)throws Exception {
        return userDao.deleteUserJoiningDetails(joinings);
    }

    public List<JoiningInfo> userJoiningDetailsById(JoiningInfo joining)throws Exception {
        return userDao.userJoiningDetailsById(joining);
    }

    public List<JoiningInfo> userActiveJoiningDetails(JoiningInfo joinings)throws Exception {
        return userDao.userActiveJoiningDetails(joinings);
    }

    public List<TeacherTrainingReceived> insertUserTrainingInfo(List<TeacherTrainingReceived> trainings)throws Exception {
        return userDao.insertUserTrainingInfo(trainings);
    }

    public List<TeacherTrainingReceived> updateUserTrainingInfo(List<TeacherTrainingReceived> trainings)throws Exception {
        return userDao.updateUserTrainingInfo(trainings);
    }

    public List<TeacherTrainingReceived> deleteUserTrainingInfo(List<TeacherTrainingReceived> trainings)throws Exception {
        return userDao.deleteUserTrainingInfo(trainings);
    }

    public List<TeacherTrainingReceived> userTrainingInfoById(TeacherTrainingReceived training)throws Exception {
        return userDao.userTrainingInfoById(training);
    }

    /*public  insertUserHistory() {
        return insertUserHistory;
    }

    public String updateUserHistory() {
        return updateUserHistory;
    }

    public String deleteUserHistory() {
        return deleteUserHistory;
    }

    public String userHistoryById() {
        return userHistoryById;
    }
*/
    public List<PreviousServiceHistory> insertUserPreviousHistory(List<PreviousServiceHistory> histories)throws Exception {
        return userDao.insertUserPreviousHistory(histories);
    }

    public List<PreviousServiceHistory> updateUserPreviousHistory(List<PreviousServiceHistory> histories)throws Exception {
        return userDao.updateUserPreviousHistory(histories);
    }

    public List<PreviousServiceHistory> deleteUserPreviousHistory(List<PreviousServiceHistory> histories)throws Exception {
        return userDao.deleteUserPreviousHistory(histories);
    }

    public List<PreviousServiceHistory> userPreviousHistoryById(PreviousServiceHistory history)throws Exception {
        return userDao.userPreviousHistoryById(history);
    }

    public List<EducationInfo> insertUserEducationInfo(List<EducationInfo> educations)throws Exception {
        return userDao.insertUserEducationInfo(educations);
    }

    public List<EducationInfo> updateUserEducationInfo(List<EducationInfo> educations)throws Exception {
        return userDao.updateUserEducationInfo(educations);
    }

    public List<EducationInfo> deleteUserEducationInfo(List<EducationInfo> educations)throws Exception {
        return userDao.deleteUserEducationInfo(educations);
    }

    public List<EducationInfo> userEducationInfoById(EducationInfo education)throws Exception {
        return userDao.userEducationInfoById(education);
    }

    public List<TeacherTrainingGiven> insertTrainingGiven(List<TeacherTrainingGiven> trainings)throws Exception {
        return userDao.insertTrainingGiven(trainings);
    }

    public List<TeacherTrainingGiven> deleteTrainingGiven(List<TeacherTrainingGiven> trainings)throws Exception {
        return userDao.deleteTrainingGiven(trainings);
    }

    public List<TeacherTrainingGiven> updateTrainingGiven(List<TeacherTrainingGiven> trainings) throws Exception{
        return userDao.updateTrainingGiven(trainings);
    }

    public List<TeacherTrainingGiven> trainingGevenById(TeacherTrainingGiven training) throws Exception{

        return userDao.trainingGevenById(training);
    }

    public List<Achievements> insertAchievements(List<Achievements> achievements) throws Exception{

        return userDao.insertAchievements(achievements);
    }

    public List<Achievements> deleteAchievements(List<Achievements> achievements) throws Exception{

        return userDao.deleteAchievements(achievements);
    }

    public List<Achievements> updateAchievements(List<Achievements> achievements) throws Exception{

        return userDao.updateAchievements(achievements);
    }

    public List<Achievements> achievementsById(Achievements achievement) throws Exception{

        return userDao.achievementsById(achievement);
    }
    public List<UserDisabilities> insertUserDisabilities(List<UserDisabilities> disabilities) throws Exception{
        return userDao.insertUserDisabilities(disabilities);

    }

    public List<UserDisabilities> updateUserDisabilities(List<UserDisabilities> disabilities) throws Exception{
        return userDao.updateUserDisabilities(disabilities);
    }

    public List<UserDisabilities> deleteDisabilities(List<UserDisabilities> disabilities) throws Exception {
       return userDao.deleteDisabilities(disabilities);
    }

    public List<UserDisabilities> getUserDisabilitiesById(UserDisabilities disability) throws Exception {
        return userDao.getUserDisabilitiesById(disability);
    }
    public String userAdmissionRequest(StudentAdmission admission) throws Exception {
        return userDao.userAdmissionRequest(admission);
    }
    public List<StudentAdmission> insertStudentEnrollment(StudentAdmission admission) throws Exception {
        return userDao.insertStudentEnrollment(admission);
    }
    public List<StudentAdmission> getEnrolledStudentByCourse(StudentAdmission admission) throws Exception{
            return userDao.getEnrolledStudentByCourse(admission);
    }

    public List<StudentAdmission> getEnrolledStudentById(StudentAdmission admission) throws Exception {
        return userDao.getEnrolledStudentById(admission);
        }
    public List<StudentAdmission> getEnrolledStudentList(StudentAdmission admission) throws Exception{
            return userDao.getEnrolledStudentList(admission);
        }
    public List<Student> insertStudent(Student student)throws Exception{
        return userDao.insertStudent(student);
    }
    public List<Student> studentsListByClass(Student student) throws Exception{
        return userDao.studentsListByClass(student);
    }
    public List<Parent> getParentSearchByNameAndContact(Parent parent){
        return userDao.getParentSearchByNameAndContact(parent);
    }
    public List<AdmissionYears> insertAdmissionsYear(AdmissionYears admission) throws Exception{
        return userDao.insertAdmissionsYear(admission);
    }
    public List<AdmissionYears> updateAdmissionsYear(AdmissionYears admission) throws Exception{

        return userDao.updateAdmissionsYear(admission);
    }
    public List<AdmissionYears> deleteAdmissionsYear(AdmissionYears admission) throws Exception{

        return userDao.deleteAdmissionsYear(admission);
    }
    public List<AdmissionYears> getAllAdmissionYears(AdmissionYears admission) throws Exception{
        return userDao.getAllAdmissionYears(admission);
    }
    public List<AdmissionYears> getActiveAdmissionYear(AdmissionYears admission) throws Exception{

        return userDao.getActiveAdmissionYear(admission);
    }

}
