package com.smss.api.smssApi.apiclazz;

import com.smss.api.system.models.*;

import java.util.List;

public class TeacherDetails {
    List<Employee> employees;
    List<Achievements> achievements;
    List<PreviousServiceHistory> previousServiceHistories;
    List<TeacherTrainingReceived> trainingReceived;
    List<TeacherTrainingGiven> trainingGiven;
    List<EducationInfo> qualifications;
    List<JoiningInfo> joiningInfos;
    List<UserDisabilities> disabilities;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Achievements> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievements> achievements) {
        this.achievements = achievements;
    }

    public List<PreviousServiceHistory> getPreviousServiceHistories() {
        return previousServiceHistories;
    }

    public void setPreviousServiceHistories(List<PreviousServiceHistory> previousServiceHistories) {
        this.previousServiceHistories = previousServiceHistories;
    }

    public List<TeacherTrainingReceived> getTrainingReceived() {
        return trainingReceived;
    }

    public void setTrainingReceived(List<TeacherTrainingReceived> trainingReceived) {
        this.trainingReceived = trainingReceived;
    }

    public List<TeacherTrainingGiven> getTrainingGiven() {
        return trainingGiven;
    }

    public void setTrainingGiven(List<TeacherTrainingGiven> trainingGiven) {
        this.trainingGiven = trainingGiven;
    }

    public List<EducationInfo> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<EducationInfo> qualifications) {
        this.qualifications = qualifications;
    }

    public List<JoiningInfo> getJoiningInfos() {
        return joiningInfos;
    }

    public void setJoiningInfos(List<JoiningInfo> joiningInfos) {
        this.joiningInfos = joiningInfos;
    }

    public List<UserDisabilities> getDisabilities() {
        return disabilities;
    }

    public void setDisabilities(List<UserDisabilities> disabilities) {
        this.disabilities = disabilities;
    }
}
