package com.smss.api.smssApi.model.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the systemuser database table.
 */
@Entity
@Table(name = "systemuser", schema = "user", catalog = "user")
//@NamedQuery(name="Systemuser.findAll", query="SELECT s FROM Systemuser s")
public class Systemuser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "su_id")
    private int suId;

    @Column(name = "su_active_ind")
    private byte suActiveInd;

    @Column(name = "su_address")
    private String suAddress;

    @Column(name = "su_country")
    private String suCountry;

    @Column(name = "su_email_id")
    private String suEmailId;

    @Column(name = "su_first_name")
    private String suFirstName;

    @Column(name = "su_last_name")
    private String suLastName;

    @Column(name = "su_location")
    private String suLocation;

    @Column(name = "su_middle_name")
    private String suMiddleName;

    @Column(name = "su_pcontact_no")
    private String suPcontactNo;

    @Column(name = "su_scontact_no")
    private String suScontactNo;

    @Column(name = "su_state")
    private String suState;

    @Column(name = "su_street")
    private String suStreet;

    @Column(name = "su_zipcode")
    private String suZipcode;

    @Column(name = "su_org_id")
    private String suOrgId;

    //bi-directional one-to-one association to Authentication
//    @OneToOne(mappedBy="systemuser")
    // private Authentication authentication;

    public Systemuser() {
    }

    public int getSuId() {
        return this.suId;
    }

    public void setSuId(int suId) {
        this.suId = suId;
    }

    public byte getSuActiveInd() {
        return this.suActiveInd;
    }

    public void setSuActiveInd(byte suActiveInd) {
        this.suActiveInd = suActiveInd;
    }

    public String getSuAddress() {
        return this.suAddress;
    }

    public void setSuAddress(String suAddress) {
        this.suAddress = suAddress;
    }

    public String getSuCountry() {
        return this.suCountry;
    }

    public void setSuCountry(String suCountry) {
        this.suCountry = suCountry;
    }

    public String getSuEmailId() {
        return this.suEmailId;
    }

    public void setSuEmailId(String suEmailId) {
        this.suEmailId = suEmailId;
    }

    public String getSuFirstName() {
        return this.suFirstName;
    }

    public void setSuFirstName(String suFirstName) {
        this.suFirstName = suFirstName;
    }

    public String getSuLastName() {
        return this.suLastName;
    }

    public void setSuLastName(String suLastName) {
        this.suLastName = suLastName;
    }

    public String getSuLocation() {
        return this.suLocation;
    }

    public void setSuLocation(String suLocation) {
        this.suLocation = suLocation;
    }

    public String getSuMiddleName() {
        return this.suMiddleName;
    }

    public void setSuMiddleName(String suMiddleName) {
        this.suMiddleName = suMiddleName;
    }

    public String getSuPcontactNo() {
        return this.suPcontactNo;
    }

    public void setSuPcontactNo(String suPcontactNo) {
        this.suPcontactNo = suPcontactNo;
    }

    public String getSuScontactNo() {
        return this.suScontactNo;
    }

    public void setSuScontactNo(String suScontactNo) {
        this.suScontactNo = suScontactNo;
    }

    public String getSuState() {
        return this.suState;
    }

    public void setSuState(String suState) {
        this.suState = suState;
    }

    public String getSuStreet() {
        return this.suStreet;
    }

    public void setSuStreet(String suStreet) {
        this.suStreet = suStreet;
    }

    public String getSuZipcode() {
        return this.suZipcode;
    }

    public void setSuZipcode(String suZipcode) {
        this.suZipcode = suZipcode;
    }


    public String getSuOrgId() {
        return suOrgId;
    }

    public void setSuOrgId(String suOrgId) {
        this.suOrgId = suOrgId;
    }
}