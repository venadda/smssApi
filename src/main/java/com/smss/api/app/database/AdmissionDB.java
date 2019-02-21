package com.smss.api.app.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource(value = {"classpath:database/dev/admission.properties"})
@Component
public class AdmissionDB {
    //student enrolled
  /*  @Value("${ADD_STUDENT_ENROLL}")
    private String addEnrollStudent;
    @Value("${DELETE_STUDENT_ENROLL}")
    private String deleteEnrolledStudent;
    @Value("${UPDATE_STUDENT_ENROLL}")
    private String updateStudentEnrolled;
    @Value("${GET_ENROLLED_STUDENT}")
    private String enrolledStudentList;
    @Value("${GET_ENROLLED_STUDENT_BY_ID}")
    private String enrolledStudentById;
*/
  /*  public String getDeleteEnrolledStudent() {
        return deleteEnrolledStudent;
    }

    public String getUpdateStudentEnrolled() {
        return updateStudentEnrolled;
    }

    public String getAddEnrollStudent() {
        return addEnrollStudent;
    }

    public String getEnrolledStudentList() {
        return enrolledStudentList;
    }

    public String getEnrolledStudentById() {
        return enrolledStudentById;
    }
*/}
