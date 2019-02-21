package com.smss.api.system.mapper;

import com.smss.api.system.models.TeacherTrainingGiven;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MTeacherTrainingGiven  implements ResultSetExtractor<List<TeacherTrainingGiven>> {
    @Override
    public List<TeacherTrainingGiven> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<TeacherTrainingGiven> tgivens =new ArrayList<TeacherTrainingGiven>();
        while(rs.next()){
            TeacherTrainingGiven tgiven = new TeacherTrainingGiven();
            tgiven.setTg_ayid(rs.getInt("tg_ayid"));
            tgiven.setTg_comment(rs.getString("tg_comment"));
            tgiven.setTg_days(rs.getInt("tg_days"));
            tgiven.setTg_givenas(rs.getString("tg_givenas"));
            tgiven.setTg_id(rs.getInt("tg_id"));
            tgiven.setTg_oid(rs.getBigDecimal("tg_oid"));
            tgiven.setTg_remarks(rs.getString("tg_remarks"));
            tgiven.setTg_trainingname(rs.getString("tg_trainingname"));
            tgiven.setTg_uid(rs.getBigDecimal("tg_uid"));
            tgivens.add(tgiven);
        }

        return tgivens;
    }
}
