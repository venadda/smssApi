package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Student {
    private BigDecimal s_id;
    private String s_admission_no;
    private int s_roll_no;
    private BigDecimal s_oid;
    private BigDecimal s_bid;
    private String s_first_name;
    private String s_middle_name;
    private String s_last_name;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date s_dob;
    private String s_nativity;
    private String s_nationality;
    private String s_religion;
    private String s_caste;
    private String s_subcaste;
    private String s_bp_village;
    private String s_bp_taluka;
    private String s_bp_district;
    private String s_bp_state;
    private String s_current_address;
    private String s_current_location;
    private String s_current_street;
    private String s_current_city;
    private String s_current_state;
    private String s_current_country;
    private String s_current_zipcode;
    private String s_current_mandal;
    private String s_current_district;
    private String s_pcontactno;
    private String s_scontactno;
    private String s_econtactno;
    private String s_present_address;
    private String s_present_location;
    private String s_present_street;
    private String s_present_city;
    private String s_present_state;
    private String s_present_country;
    private String s_present_zipcode;
    private String s_present_mandal;
    private String s_present_district;
    private String s_gender;
    private Date s_created_date;
    private Date s_date_joined;
    private int s_created_By;
    private int s_approved_by;
    private String s_remark;
    private Date s_updated_date;
    private int s_updated_by;
    @JsonProperty
    private boolean s_active_ind;
    private String s_mother_tongue;
    private String s_height;
    private String s_weight;
    private String s_bloodgroup;
    @JsonProperty
    private boolean s_physically_handicap;
    @JsonProperty
    private boolean s_isOrphan;
    private String s_aadharno;
    private byte[] s_photo;
    private Parent parent;
    private StudentClsSec studentClsSec;
    private int s_pid;
    private List<StudentAcademicHistory> academic;
    private String[] handicaplist;

    public Student() {
    }


    public List<StudentAcademicHistory> getAcademic() {
        return academic;
    }

    public void setAcademic(List<StudentAcademicHistory> academic) {
        this.academic = academic;
    }

    public StudentClsSec getStudentClsSec() {
        return studentClsSec;
    }

    public void setStudentClsSec(StudentClsSec studentClsSec) {
        this.studentClsSec = studentClsSec;
    }

    public String getS_admission_no() {
        return s_admission_no;
    }

    public void setS_admission_no(String s_admission_no) {
        this.s_admission_no = s_admission_no;
    }

    public int getS_roll_no() {
        return s_roll_no;
    }

    public void setS_roll_no(int s_roll_no) {
        this.s_roll_no = s_roll_no;
    }

    public BigDecimal getS_oid() {
        return s_oid;
    }

    public void setS_oid(BigDecimal s_oid) {
        this.s_oid = s_oid;
    }

    public BigDecimal getS_bid() {
        return s_bid;
    }

    public void setS_bid(BigDecimal s_bid) {
        this.s_bid = s_bid;
    }

    public String getS_first_name() {
        return s_first_name;
    }

    public void setS_first_name(String s_first_name) {
        this.s_first_name = s_first_name;
    }

    public String getS_middle_name() {
        return s_middle_name;
    }

    public void setS_middle_name(String s_middle_name) {
        this.s_middle_name = s_middle_name;
    }

    public String getS_last_name() {
        return s_last_name;
    }

    public void setS_last_name(String s_last_name) {
        this.s_last_name = s_last_name;
    }

    public Date getS_dob() {
        return s_dob;
    }

    public void setS_dob(Date s_dob) {
        this.s_dob = s_dob;
    }

    public String getS_nativity() {
        return s_nativity;
    }

    public void setS_nativity(String s_nativity) {
        this.s_nativity = s_nativity;
    }

    public String getS_nationality() {
        return s_nationality;
    }

    public void setS_nationality(String s_nationality) {
        this.s_nationality = s_nationality;
    }

    public String getS_religion() {
        return s_religion;
    }

    public void setS_religion(String s_religion) {
        this.s_religion = s_religion;
    }

    public String getS_caste() {
        return s_caste;
    }

    public void setS_caste(String s_caste) {
        this.s_caste = s_caste;
    }

    public String getS_subcaste() {
        return s_subcaste;
    }

    public void setS_subcaste(String s_subcaste) {
        this.s_subcaste = s_subcaste;
    }

    public String getS_bp_village() {
        return s_bp_village;
    }

    public void setS_bp_village(String s_bp_village) {
        this.s_bp_village = s_bp_village;
    }

    public String getS_bp_taluka() {
        return s_bp_taluka;
    }

    public void setS_bp_taluka(String s_bp_taluka) {
        this.s_bp_taluka = s_bp_taluka;
    }

    public String getS_bp_district() {
        return s_bp_district;
    }

    public void setS_bp_district(String s_bp_district) {
        this.s_bp_district = s_bp_district;
    }

    public String getS_bp_state() {
        return s_bp_state;
    }

    public void setS_bp_state(String s_bp_state) {
        this.s_bp_state = s_bp_state;
    }

    public String getS_current_address() {
        return s_current_address;
    }

    public void setS_current_address(String s_current_address) {
        this.s_current_address = s_current_address;
    }

    public String getS_current_location() {
        return s_current_location;
    }

    public void setS_current_location(String s_current_location) {
        this.s_current_location = s_current_location;
    }

    public String getS_current_street() {
        return s_current_street;
    }

    public void setS_current_street(String s_current_street) {
        this.s_current_street = s_current_street;
    }

    public String getS_current_city() {
        return s_current_city;
    }

    public void setS_current_city(String s_current_city) {
        this.s_current_city = s_current_city;
    }

    public String getS_current_state() {
        return s_current_state;
    }

    public void setS_current_state(String s_current_state) {
        this.s_current_state = s_current_state;
    }

    public String getS_current_country() {
        return s_current_country;
    }

    public void setS_current_country(String s_current_country) {
        this.s_current_country = s_current_country;
    }

    public String getS_current_zipcode() {
        return s_current_zipcode;
    }

    public void setS_current_zipcode(String s_current_zipcode) {
        this.s_current_zipcode = s_current_zipcode;
    }

    public String getS_current_mandal() {
        return s_current_mandal;
    }

    public void setS_current_mandal(String s_current_mandal) {
        this.s_current_mandal = s_current_mandal;
    }

    public String getS_current_district() {
        return s_current_district;
    }

    public void setS_current_district(String s_current_district) {
        this.s_current_district = s_current_district;
    }

    public String getS_pcontactno() {
        return s_pcontactno;
    }

    public void setS_pcontactno(String s_pcontactno) {
        this.s_pcontactno = s_pcontactno;
    }

    public String getS_scontactno() {
        return s_scontactno;
    }

    public void setS_scontactno(String s_scontactno) {
        this.s_scontactno = s_scontactno;
    }

    public String getS_econtactno() {
        return s_econtactno;
    }

    public void setS_econtactno(String s_econtactno) {
        this.s_econtactno = s_econtactno;
    }

    public String getS_present_address() {
        return s_present_address;
    }

    public void setS_present_address(String s_present_address) {
        this.s_present_address = s_present_address;
    }

    public String getS_present_location() {
        return s_present_location;
    }

    public void setS_present_location(String s_present_location) {
        this.s_present_location = s_present_location;
    }

    public String getS_present_street() {
        return s_present_street;
    }

    public void setS_present_street(String s_present_street) {
        this.s_present_street = s_present_street;
    }

    public String getS_present_city() {
        return s_present_city;
    }

    public void setS_present_city(String s_present_city) {
        this.s_present_city = s_present_city;
    }

    public String getS_present_state() {
        return s_present_state;
    }

    public void setS_present_state(String s_present_state) {
        this.s_present_state = s_present_state;
    }

    public String getS_present_country() {
        return s_present_country;
    }

    public void setS_present_country(String s_present_country) {
        this.s_present_country = s_present_country;
    }

    public String getS_present_zipcode() {
        return s_present_zipcode;
    }

    public void setS_present_zipcode(String s_present_zipcode) {
        this.s_present_zipcode = s_present_zipcode;
    }

    public String getS_present_mandal() {
        return s_present_mandal;
    }

    public void setS_present_mandal(String s_present_mandal) {
        this.s_present_mandal = s_present_mandal;
    }

    public String getS_present_district() {
        return s_present_district;
    }

    public void setS_present_district(String s_present_district) {
        this.s_present_district = s_present_district;
    }

    public String getS_gender() {
        return s_gender;
    }

    public void setS_gender(String s_gender) {
        this.s_gender = s_gender;
    }

    public Date getS_created_date() {
        return s_created_date;
    }

    public void setS_created_date(Date s_created_date) {
        this.s_created_date = s_created_date;
    }

    public Date getS_date_joined() {
        return s_date_joined;
    }

    public void setS_date_joined(Date s_date_joined) {
        this.s_date_joined = s_date_joined;
    }

    public int getS_created_By() {
        return s_created_By;
    }

    public void setS_created_By(int s_created_By) {
        this.s_created_By = s_created_By;
    }

    public int getS_approved_by() {
        return s_approved_by;
    }

    public void setS_approved_by(int s_approved_by) {
        this.s_approved_by = s_approved_by;
    }

    public String getS_remark() {
        return s_remark;
    }

    public void setS_remark(String s_remark) {
        this.s_remark = s_remark;
    }

    public Date getS_updated_date() {
        return s_updated_date;
    }

    public void setS_updated_date(Date s_updated_date) {
        this.s_updated_date = s_updated_date;
    }

    public int getS_updated_by() {
        return s_updated_by;
    }

    public void setS_updated_by(int s_updated_by) {
        this.s_updated_by = s_updated_by;
    }

    public boolean isS_active_ind() {
        return s_active_ind;
    }

    public void setS_active_ind(boolean s_active_ind) {
        this.s_active_ind = s_active_ind;
    }

    public String getS_mother_tongue() {
        return s_mother_tongue;
    }

    public void setS_mother_tongue(String s_mother_tongue) {
        this.s_mother_tongue = s_mother_tongue;
    }

    public String getS_height() {
        return s_height;
    }

    public void setS_height(String s_height) {
        this.s_height = s_height;
    }

    public String getS_weight() {
        return s_weight;
    }

    public void setS_weight(String s_weight) {
        this.s_weight = s_weight;
    }

    public String getS_bloodgroup() {
        return s_bloodgroup;
    }

    public void setS_bloodgroup(String s_bloodgroup) {
        this.s_bloodgroup = s_bloodgroup;
    }

    public boolean isS_physically_handicap() {
        return s_physically_handicap;
    }

    public void setS_physically_handicap(boolean s_physically_handicap) {
        this.s_physically_handicap = s_physically_handicap;
    }

    public boolean isS_isOrphan() {
        return s_isOrphan;
    }

    public void setS_isOrphan(boolean s_isOrphan) {
        this.s_isOrphan = s_isOrphan;
    }

    public String getS_aadharno() {
        return s_aadharno;
    }

    public void setS_aadharno(String s_aadharno) {
        this.s_aadharno = s_aadharno;
    }

    public byte[] getS_photo() {
        return s_photo;
    }

    public void setS_photo(byte[] s_photo) {
        this.s_photo = s_photo;
    }

    public BigDecimal getS_id() {
        return s_id;
    }

    public void setS_id(BigDecimal s_id) {
        this.s_id = s_id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public int getS_pid() {
        return s_pid;
    }

    public void setS_pid(int s_pid) {
        this.s_pid = s_pid;
    }

    public String[] getHandicaplist() {
        return handicaplist;
    }

    public void setHandicaplist(String[] handicaplist) {
        this.handicaplist = handicaplist;
    }

    @Override
    public String toString() {
        return "Student{" +
                "s_id=" + s_id +
                ", s_admission_no='" + s_admission_no + '\'' +
                ", s_roll_no=" + s_roll_no +
                ", s_oid=" + s_oid +
                ", s_bid=" + s_bid +
                ", s_first_name='" + s_first_name + '\'' +
                ", s_middle_name='" + s_middle_name + '\'' +
                ", s_last_name='" + s_last_name + '\'' +
                ", s_dob=" + s_dob +
                ", s_nativity='" + s_nativity + '\'' +
                ", s_nationality='" + s_nationality + '\'' +
                ", s_religion='" + s_religion + '\'' +
                ", s_caste='" + s_caste + '\'' +
                ", s_subcaste='" + s_subcaste + '\'' +
                ", s_bp_village='" + s_bp_village + '\'' +
                ", s_bp_taluka='" + s_bp_taluka + '\'' +
                ", s_bp_district='" + s_bp_district + '\'' +
                ", s_bp_state='" + s_bp_state + '\'' +
                ", s_current_address='" + s_current_address + '\'' +
                ", s_current_location='" + s_current_location + '\'' +
                ", s_current_street='" + s_current_street + '\'' +
                ", s_current_city='" + s_current_city + '\'' +
                ", s_current_state='" + s_current_state + '\'' +
                ", s_current_country='" + s_current_country + '\'' +
                ", s_current_zipcode='" + s_current_zipcode + '\'' +
                ", s_current_mandal='" + s_current_mandal + '\'' +
                ", s_current_district='" + s_current_district + '\'' +
                ", s_pcontactno='" + s_pcontactno + '\'' +
                ", s_scontactno='" + s_scontactno + '\'' +
                ", s_econtactno='" + s_econtactno + '\'' +
                ", s_present_address='" + s_present_address + '\'' +
                ", s_present_location='" + s_present_location + '\'' +
                ", s_present_street='" + s_present_street + '\'' +
                ", s_present_city='" + s_present_city + '\'' +
                ", s_present_state='" + s_present_state + '\'' +
                ", s_present_country='" + s_present_country + '\'' +
                ", s_present_zipcode='" + s_present_zipcode + '\'' +
                ", s_present_mandal='" + s_present_mandal + '\'' +
                ", s_present_district='" + s_present_district + '\'' +
                ", s_gender='" + s_gender + '\'' +
                ", s_created_date=" + s_created_date +
                ", s_date_joined=" + s_date_joined +
                ", s_created_By=" + s_created_By +
                ", s_approved_by=" + s_approved_by +
                ", s_remark='" + s_remark + '\'' +
                ", s_updated_date=" + s_updated_date +
                ", s_updated_by=" + s_updated_by +
                ", s_active_ind=" + s_active_ind +
                ", s_mother_tongue='" + s_mother_tongue + '\'' +
                ", s_height='" + s_height + '\'' +
                ", s_weight='" + s_weight + '\'' +
                ", s_bloodgroup='" + s_bloodgroup + '\'' +
                ", s_physically_handicap=" + s_physically_handicap +
                ", s_isOrphan=" + s_isOrphan +
                ", s_aadharno='" + s_aadharno + '\'' +
                ", s_photo=" + Arrays.toString(s_photo) +
                ", parent=" + parent +
                ", studentClsSec=" + studentClsSec +
                ", s_pid=" + s_pid +
                '}';
    }
}
