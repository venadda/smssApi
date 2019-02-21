package com.smss.api.system.mapper;

import com.smss.api.system.models.JoiningInfo;
import org.hibernate.mapping.Join;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MJoiningInfo implements ResultSetExtractor<List<JoiningInfo>> {
    @Override
    public List<JoiningInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<JoiningInfo> joiningdetails = new ArrayList<JoiningInfo>();
        while(rs.next()){
            JoiningInfo joiningdetail = new JoiningInfo();
            joiningdetail.setU_category(rs.getString("u_category"));
            joiningdetail.setU_department(rs.getString("u_department"));
            joiningdetail.setU_desg(rs.getString("u_desg"));
            joiningdetail.setU_doa(rs.getDate("u_doa"));
            joiningdetail.setU_doj(rs.getDate("u_doj"));
            joiningdetail.setU_id(rs.getBigDecimal("u_id"));
            joiningdetail.setU_active_ind(rs.getBoolean("u_active_ind"));
            joiningdetail.setU_comment(rs.getString("u_comment"));
            joiningdetail.setU_dor(rs.getDate("u_dor"));
            joiningdetail.setU_init_off_name(rs.getString("u_init_off_name"));
            joiningdetail.setU_jid(rs.getInt("u_jid"));
            joiningdetail.setU_oid(rs.getBigDecimal("u_oid"));
            joiningdetail.setU_order_no(rs.getString("u_order_no"));
            joiningdetail.setU_recruitment_mode(rs.getString("u_recruitment_mode"));
            joiningdetails.add(joiningdetail);
        }
        return joiningdetails;
    }
}
