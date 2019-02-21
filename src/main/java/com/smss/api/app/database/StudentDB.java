package com.smss.api.app.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:database/dev/student.properties"})
@Component
public class StudentDB {
    @Value("${GET_STUDENT_BY_ID}")
    private String studentById;
    @Value("${GET_STUDENT_BY_NAME}")
    private String studentByName;
    @Value("${ADD_STUDENT}")
    private String insertStudent;
    @Value("${DELETE_STUDENT}")
    private String deleteStudent;
    @Value("${UPDATE_STUDENT}")
    private String updateStudent;
    @Value("$(GET_STUDENT_BY_LIST}")
    private String studentList;

    @Value("${ADD_STUDENT_PHOTO}")
    private String addStudentPhoto;
    @Value("${GET_STUDENT_PHOTO}")
    private String studentPhotoList;
    @Value("${UPDATE_STUDENT_PHOTO}")
    private String updateStudentPhoto;
    @Value("${DELETE_STUDENT_PHOTO}")
    private String deleteStudentPhoto;
    @Value("${GET_STUDENT_ATTACHMENT}")
    private String studentAttachmentList;
    @Value("${INSERT_STUDENT_ATTACHMENT}")
    private String insertStudentAttachment;
    @Value("${UPDATE_STUDENT_ATTACHMENT}")
    private String updateStudentAttachment;
    @Value("${DELETE_STUDENT_ATTACHMENT}")
    private String deleteStudentAttachment;
    @Value("${GET_STUDENT_EDU_HISTORY}")
    private String studentEduHistoryList;
    @Value("${INSERT_STUDENT_HISTORY}")
    private String insertStudentHistory;
    @Value("${UPDATE_STUDENT_HISTORY}")
    private String updateStudentHistory;
    @Value("${DELETE_STUDENT_HISTORY}")
    private String deleteStudentHistory;


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

    public String getUpdateStudent() {
        return updateStudent;
    }

    public String getStudentList() {
        return studentList;
    }

    public String getAddStudentPhoto() {
        return addStudentPhoto;
    }

    public String getStudentPhotoList() {
        return studentPhotoList;
    }

    public String getUpdateStudentPhoto() {
        return updateStudentPhoto;
    }

    public String getDeleteStudentPhoto() {
        return deleteStudentPhoto;
    }

    public String getStudentAttachmentList() {
        return studentAttachmentList;
    }

    public String getInsertStudentAttachment() {
        return insertStudentAttachment;
    }

    public String getUpdateStudentAttachment() {
        return updateStudentAttachment;
    }

    public String getDeleteStudentAttachment() {
        return deleteStudentAttachment;
    }

    public String getStudentEduHistoryList() {
        return studentEduHistoryList;
    }

    public String getInsertStudentHistory() {
        return insertStudentHistory;
    }

    public String getUpdateStudentHistory() {
        return updateStudentHistory;
    }

    public String getDeleteStudentHistory() {
        return deleteStudentHistory;
    }
}
