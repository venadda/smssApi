package com.smss.api.system.models;

import java.math.BigDecimal;

public class MandalLookup {
    private BigDecimal m_id;
    private String m_title;
    private String m_district;
    private String m_state;
    private String m_country;

    public MandalLookup() {
    }

    public BigDecimal getM_id() {
        return m_id;
    }

    public void setM_id(BigDecimal m_id) {
        this.m_id = m_id;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public String getM_district() {
        return m_district;
    }

    public void setM_district(String m_district) {
        this.m_district = m_district;
    }

    public String getM_state() {
        return m_state;
    }

    public void setM_state(String m_state) {
        this.m_state = m_state;
    }

    public String getM_country() {
        return m_country;
    }

    public void setM_country(String m_country) {
        this.m_country = m_country;
    }
}
