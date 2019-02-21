package com.smss.api.system.mapper;

import com.smss.api.system.models.TermFees;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MTermFees implements ResultSetExtractor <List<TermFees>> {
    @Override
    public List<TermFees> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<TermFees> termfees = new ArrayList<TermFees>();
        while(rs.next()){
            TermFees termfee = new TermFees();
            termfee.setTf_active_ind(rs.getBoolean("tf_active_ind"));
            termfee.setTf_amount(rs.getDouble("tf_amount"));
            termfee.setTf_bid(rs.getInt("tf_bid"));
            termfee.setTf_fee_id(rs.getInt("tf_fee_id"));
            termfee.setTf_id(rs.getInt("tf_id"));
            termfee.setTf_oid(rs.getInt("tf_oid"));
            termfee.setTf_other_amount(rs.getDouble("tf_other_amount"));
            termfee.setTf_term_id(rs.getInt("tf_term_id"));
            termfee.setTf_ay_id(rs.getInt("tf_ay_id"));
            termfee.setTf_cls_id(rs.getString("tf_cls_id"));
            termfee.setTf_cls_code(rs.getString("tf_cls_code"));
            termfee.setTf_course_id(rs.getString("tf_course_id"));
            termfees.add(termfee);
        }
        return termfees;
    }
}
