package com.smss.api.smssApi.model.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the users database table.
 */
@Entity
@Table(name = "user.users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id", unique = true, nullable = false)
    private int uId;

    @Column(name = "u_active_ind")
    private byte uActiveInd;

    @Column(name = "u_alt_email_id", length = 100)
    private String uAltEmailId;

    @Column(name = "u_caddress", length = 100)
    private String uCaddress;

    @Column(name = "u_caste", length = 25)
    private String uCaste;

    @Column(name = "u_ccity", length = 25)
    private String uCcity;

    @Column(name = "u_cdistrict", length = 25)
    private String uCdistrict;

    @Column(name = "u_clocation", length = 100)
    private String uClocation;

    @Column(name = "u_cmandal", length = 25)
    private String uCmandal;

    @Column(name = "u_cstate", length = 25)
    private String uCstate;

    @Column(name = "u_cstreet", length = 100)
    private String uCstreet;

    @Column(name = "u_czipcode", length = 15)
    private String uCzipcode;

    @Column(name = "u_decile_group", length = 20)
    private String uDecileGroup;

    @Temporal(TemporalType.DATE)
    @Column(name = "u_dob")
    private Date uDob;

    @Column(name = "u_econtact_no", length = 15)
    private String uEcontactNo;

    @Column(name = "u_email_id", length = 100)
    private String uEmailId;

    @Column(name = "u_ethnic_designation", length = 20)
    private String uEthnicDesignation;

    @Column(name = "u_ethnic_group", length = 20)
    private String uEthnicGroup;

    @Column(name = "u_father_name", length = 50)
    private String uFatherName;

    @Column(name = "u_fcontact_no", length = 15)
    private String uFcontactNo;

    @Column(name = "u_first_name", nullable = false, length = 25)
    private String uFirstName;

    @Column(name = "u_gcontact_no", length = 15)
    private String uGcontactNo;

    @Column(name = "u_guardian_name", length = 50)
    private String uGuardianName;

    @Column(name = "u_guardian_relation", length = 50)
    private String uGuardianRelation;

    @Column(name = "u_last_name", nullable = false, length = 25)
    private String uLastName;

    @Column(name = "u_mcontact_no", length = 15)
    private String uMcontactNo;

    @Column(name = "u_middle_name", length = 25)
    private String uMiddleName;

    @Column(name = "u_mother_name", length = 50)
    private String uMotherName;

    @Column(name = "u_mother_tongue", length = 10)
    private String uMotherTongue;

    @Column(name = "u_nationality", length = 25)
    private String uNationality;

    @Column(name = "u_nativity", length = 25)
    private String uNativity;

    @Column(name = "u_org_id", nullable = false)
    private int uOrgId;

    @Column(name = "u_paddress", length = 100)
    private String uPaddress;

    @Column(name = "u_pcity", length = 25)
    private String uPcity;

    @Column(name = "u_pcontact_no", length = 15)
    private String uPcontactNo;

    @Column(name = "u_pdistrict", length = 25)
    private String uPdistrict;

    @Column(name = "u_plocation", length = 100)
    private String uPlocation;

    @Column(name = "u_pmandal", length = 25)
    private String uPmandal;

    @Column(name = "u_pstate", length = 25)
    private String uPstate;

    @Column(name = "u_pstreet", length = 100)
    private String uPstreet;

    @Column(name = "u_pzipcode", length = 15)
    private String uPzipcode;

    @Column(name = "u_religion", length = 25)
    private String uReligion;

    @Column(name = "u_scontact_no", length = 15)
    private String uScontactNo;

    @Column(length = 20)
    private String u_social_security_Id;

    @Column(name = "u_social_security_name", length = 50)
    private String uSocialSecurityName;

    @Column(name = "u_subcaste", length = 25)
    private String uSubcaste;

    @Column(name = "u_suffix", length = 5)
    private String uSuffix;

    @Column(name = "u_tenure", length = 20)
    private String uTenure;

    public User() {
    }

    public int getUId() {
        return this.uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public byte getUActiveInd() {
        return this.uActiveInd;
    }

    public void setUActiveInd(byte uActiveInd) {
        this.uActiveInd = uActiveInd;
    }

    public String getUAltEmailId() {
        return this.uAltEmailId;
    }

    public void setUAltEmailId(String uAltEmailId) {
        this.uAltEmailId = uAltEmailId;
    }

    public String getUCaddress() {
        return this.uCaddress;
    }

    public void setUCaddress(String uCaddress) {
        this.uCaddress = uCaddress;
    }

    public String getUCaste() {
        return this.uCaste;
    }

    public void setUCaste(String uCaste) {
        this.uCaste = uCaste;
    }

    public String getUCcity() {
        return this.uCcity;
    }

    public void setUCcity(String uCcity) {
        this.uCcity = uCcity;
    }

    public String getUCdistrict() {
        return this.uCdistrict;
    }

    public void setUCdistrict(String uCdistrict) {
        this.uCdistrict = uCdistrict;
    }

    public String getUClocation() {
        return this.uClocation;
    }

    public void setUClocation(String uClocation) {
        this.uClocation = uClocation;
    }

    public String getUCmandal() {
        return this.uCmandal;
    }

    public void setUCmandal(String uCmandal) {
        this.uCmandal = uCmandal;
    }

    public String getUCstate() {
        return this.uCstate;
    }

    public void setUCstate(String uCstate) {
        this.uCstate = uCstate;
    }

    public String getUCstreet() {
        return this.uCstreet;
    }

    public void setUCstreet(String uCstreet) {
        this.uCstreet = uCstreet;
    }

    public String getUCzipcode() {
        return this.uCzipcode;
    }

    public void setUCzipcode(String uCzipcode) {
        this.uCzipcode = uCzipcode;
    }

    public String getUDecileGroup() {
        return this.uDecileGroup;
    }

    public void setUDecileGroup(String uDecileGroup) {
        this.uDecileGroup = uDecileGroup;
    }

    public Date getUDob() {
        return this.uDob;
    }

    public void setUDob(Date uDob) {
        this.uDob = uDob;
    }

    public String getUEcontactNo() {
        return this.uEcontactNo;
    }

    public void setUEcontactNo(String uEcontactNo) {
        this.uEcontactNo = uEcontactNo;
    }

    public String getUEmailId() {
        return this.uEmailId;
    }

    public void setUEmailId(String uEmailId) {
        this.uEmailId = uEmailId;
    }

    public String getUEthnicDesignation() {
        return this.uEthnicDesignation;
    }

    public void setUEthnicDesignation(String uEthnicDesignation) {
        this.uEthnicDesignation = uEthnicDesignation;
    }

    public String getUEthnicGroup() {
        return this.uEthnicGroup;
    }

    public void setUEthnicGroup(String uEthnicGroup) {
        this.uEthnicGroup = uEthnicGroup;
    }

    public String getUFatherName() {
        return this.uFatherName;
    }

    public void setUFatherName(String uFatherName) {
        this.uFatherName = uFatherName;
    }

    public String getUFcontactNo() {
        return this.uFcontactNo;
    }

    public void setUFcontactNo(String uFcontactNo) {
        this.uFcontactNo = uFcontactNo;
    }

    public String getUFirstName() {
        return this.uFirstName;
    }

    public void setUFirstName(String uFirstName) {
        this.uFirstName = uFirstName;
    }

    public String getUGcontactNo() {
        return this.uGcontactNo;
    }

    public void setUGcontactNo(String uGcontactNo) {
        this.uGcontactNo = uGcontactNo;
    }

    public String getUGuardianName() {
        return this.uGuardianName;
    }

    public void setUGuardianName(String uGuardianName) {
        this.uGuardianName = uGuardianName;
    }

    public String getUGuardianRelation() {
        return this.uGuardianRelation;
    }

    public void setUGuardianRelation(String uGuardianRelation) {
        this.uGuardianRelation = uGuardianRelation;
    }

    public String getULastName() {
        return this.uLastName;
    }

    public void setULastName(String uLastName) {
        this.uLastName = uLastName;
    }

    public String getUMcontactNo() {
        return this.uMcontactNo;
    }

    public void setUMcontactNo(String uMcontactNo) {
        this.uMcontactNo = uMcontactNo;
    }

    public String getUMiddleName() {
        return this.uMiddleName;
    }

    public void setUMiddleName(String uMiddleName) {
        this.uMiddleName = uMiddleName;
    }

    public String getUMotherName() {
        return this.uMotherName;
    }

    public void setUMotherName(String uMotherName) {
        this.uMotherName = uMotherName;
    }

    public String getUMotherTongue() {
        return this.uMotherTongue;
    }

    public void setUMotherTongue(String uMotherTongue) {
        this.uMotherTongue = uMotherTongue;
    }

    public String getUNationality() {
        return this.uNationality;
    }

    public void setUNationality(String uNationality) {
        this.uNationality = uNationality;
    }

    public String getUNativity() {
        return this.uNativity;
    }

    public void setUNativity(String uNativity) {
        this.uNativity = uNativity;
    }

    public int getUOrgId() {
        return this.uOrgId;
    }

    public void setUOrgId(int uOrgId) {
        this.uOrgId = uOrgId;
    }

    public String getUPaddress() {
        return this.uPaddress;
    }

    public void setUPaddress(String uPaddress) {
        this.uPaddress = uPaddress;
    }

    public String getUPcity() {
        return this.uPcity;
    }

    public void setUPcity(String uPcity) {
        this.uPcity = uPcity;
    }

    public String getUPcontactNo() {
        return this.uPcontactNo;
    }

    public void setUPcontactNo(String uPcontactNo) {
        this.uPcontactNo = uPcontactNo;
    }

    public String getUPdistrict() {
        return this.uPdistrict;
    }

    public void setUPdistrict(String uPdistrict) {
        this.uPdistrict = uPdistrict;
    }

    public String getUPlocation() {
        return this.uPlocation;
    }

    public void setUPlocation(String uPlocation) {
        this.uPlocation = uPlocation;
    }

    public String getUPmandal() {
        return this.uPmandal;
    }

    public void setUPmandal(String uPmandal) {
        this.uPmandal = uPmandal;
    }

    public String getUPstate() {
        return this.uPstate;
    }

    public void setUPstate(String uPstate) {
        this.uPstate = uPstate;
    }

    public String getUPstreet() {
        return this.uPstreet;
    }

    public void setUPstreet(String uPstreet) {
        this.uPstreet = uPstreet;
    }

    public String getUPzipcode() {
        return this.uPzipcode;
    }

    public void setUPzipcode(String uPzipcode) {
        this.uPzipcode = uPzipcode;
    }

    public String getUReligion() {
        return this.uReligion;
    }

    public void setUReligion(String uReligion) {
        this.uReligion = uReligion;
    }

    public String getUScontactNo() {
        return this.uScontactNo;
    }

    public void setUScontactNo(String uScontactNo) {
        this.uScontactNo = uScontactNo;
    }

    public String getU_social_security_Id() {
        return this.u_social_security_Id;
    }

    public void setU_social_security_Id(String u_social_security_Id) {
        this.u_social_security_Id = u_social_security_Id;
    }

    public String getUSocialSecurityName() {
        return this.uSocialSecurityName;
    }

    public void setUSocialSecurityName(String uSocialSecurityName) {
        this.uSocialSecurityName = uSocialSecurityName;
    }

    public String getUSubcaste() {
        return this.uSubcaste;
    }

    public void setUSubcaste(String uSubcaste) {
        this.uSubcaste = uSubcaste;
    }

    public String getUSuffix() {
        return this.uSuffix;
    }

    public void setUSuffix(String uSuffix) {
        this.uSuffix = uSuffix;
    }

    public String getUTenure() {
        return this.uTenure;
    }

    public void setUTenure(String uTenure) {
        this.uTenure = uTenure;
    }

}