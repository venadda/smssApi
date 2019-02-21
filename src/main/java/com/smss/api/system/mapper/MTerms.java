package com.smss.api.system.mapper;


import com.smss.api.system.models.Terms;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MTerms implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Terms term = new Terms();
        term.setT_active_ind(resultSet.getBoolean("t_active_ind"));
        term.setT_ay(resultSet.getBigDecimal("t_ay"));
        term.setT_fromdate(resultSet.getString("t_fromdate"));
        term.setT_id(resultSet.getBigDecimal("t_id"));
        term.setT_title(resultSet.getString("t_title"));
        term.setT_todate(resultSet.getString("t_todate"));
        term.setT_oid(resultSet.getInt("t_oid"));
        term.setT_bid(resultSet.getInt("t_bid"));
        term.setT_cls_id(resultSet.getString("t_cls_id"));
        term.setT_course(resultSet.getString("t_course"));
        term.setT_course_category(resultSet.getString("t_course_category"));
        return term;
    }
}
